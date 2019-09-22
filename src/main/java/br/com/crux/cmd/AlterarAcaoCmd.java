package br.com.crux.cmd;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.AtividadesTOBuilder;
import br.com.crux.dao.repository.AcaoRepository;
import br.com.crux.dao.repository.AtividadeRepository;
import br.com.crux.entity.Acoes;
import br.com.crux.entity.Atividades;
import br.com.crux.exception.NotFoundException;
import br.com.crux.rule.CamposObrigatoriosAcaoRule;
import br.com.crux.to.AcaoTO;
import br.com.crux.to.UsuarioLogadoTO;

@Component
public class AlterarAcaoCmd {

	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;

	@Autowired private AcaoRepository repository;
	@Autowired private CamposObrigatoriosAcaoRule camposObrigatoriosRule;

	@Autowired private AtividadeRepository atividadeRepository;
	@Autowired private AtividadesTOBuilder atividadeBuilder;
	
	
	
	public void alterar(AcaoTO to) {
		Optional<Acoes> entityOptional = repository.findById(to.getId());
		if(!entityOptional.isPresent()) {
			throw new NotFoundException("Ação informada não existe.");
		}
		
		if(Objects.isNull(to.getAtividade())) {
			throw new NotFoundException("Atividade não informada.");
		}
		
		camposObrigatoriosRule.verificar(to.getDataInicio(), to.getNome(), to.getAtividade().getId());
		
		Optional<Atividades> atividadeOptional = atividadeRepository.findById(to.getAtividade().getId());
		if(!atividadeOptional.isPresent()) {
			throw new NotFoundException("Atividade informado não existe.");
		}
		
		Acoes entity = entityOptional.get();

		entity.setNome(to.getNome());
		entity.setDataFim(to.getDataFim());
		entity.setDataInicio(to.getDataInicio());
		entity.setDataPrevisaoInicio(to.getDataPrevisaoInicio());
		entity.setDataPrevisaoFim(to.getDataPrevisaoFim());
		entity.setAtividade(atividadeBuilder.build(to.getAtividade()));
		
		UsuarioLogadoTO usuarioLogado = getUsuarioLogadoCmd.getUsuarioLogado();
		entity.setUsuarioAlteracao(usuarioLogado.getIdUsuario());
		
		repository.save(entity);
		
	}
}
