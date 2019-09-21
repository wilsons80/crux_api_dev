package br.com.crux.cmd;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.dao.repository.SituacoesVulnerabilidadeRepository;
import br.com.crux.entity.SituacoesVulnerabilidade;
import br.com.crux.exception.NotFoundException;
import br.com.crux.rule.CamposObrigatoriosSituacoesVulnerabilidadeRule;
import br.com.crux.to.SituacoesVulnerabilidadeTO;
import br.com.crux.to.UsuarioLogadoTO;

@Component
public class AlterarSituacoesVulnerabilidadeCmd {

	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;
	
	@Autowired private SituacoesVulnerabilidadeRepository repository;
	@Autowired private CamposObrigatoriosSituacoesVulnerabilidadeRule camposObrigatoriosRule;
	
	
	
	public void alterar(SituacoesVulnerabilidadeTO to) {
		Optional<SituacoesVulnerabilidade> entityOptional = repository.findById(to.getId());
		if(!entityOptional.isPresent()) {
			throw new NotFoundException("Situacoes de vulnerabilidade informada não existe.");
		}
		
		camposObrigatoriosRule.verificar(to.getDescricao());
		
		SituacoesVulnerabilidade entity = entityOptional.get();

		entity.setDescricao(to.getDescricao());
		
		UsuarioLogadoTO usuarioLogado = getUsuarioLogadoCmd.getUsuarioLogado();
		entity.setUsuarioAlteracao(usuarioLogado.getIdUsuario());
		
		repository.save(entity);
		
	}
}
