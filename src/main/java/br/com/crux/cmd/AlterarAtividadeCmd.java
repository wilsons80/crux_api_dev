package br.com.crux.cmd;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.AtividadesTOBuilder;
import br.com.crux.dao.repository.AtividadeRepository;
import br.com.crux.entity.Atividades;
import br.com.crux.exception.NotFoundException;
import br.com.crux.rule.CamposObrigatoriosAtividadeRule;
import br.com.crux.to.AtividadesTO;
import br.com.crux.to.UsuarioLogadoTO;

@Component
public class AlterarAtividadeCmd {

	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;
	@Autowired private AtividadeRepository repository;
	@Autowired private AtividadesTOBuilder atividadesTOBuilder;  
	
	@Autowired private CamposObrigatoriosAtividadeRule camposObrigatoriosRule;
	
	
	public void alterar(AtividadesTO to) {
		Optional<Atividades> entityOptional = repository.findById(to.getId());
		if(!entityOptional.isPresent()) {
			throw new NotFoundException("Atividade informado não existe.");
		}
		
		if(Objects.isNull(to.getUnidade())) {
			throw new NotFoundException("Unidade não informada.");
		}
		if(Objects.isNull(to.getProjeto())) {
			throw new NotFoundException("Projeto não informado.");
		}
		if(Objects.isNull(to.getPlanosAcao())) {
			throw new NotFoundException("Plano de Ação não informado.");
		}
		
		
		camposObrigatoriosRule.verificar(to.getDataInicio(), to.getDataPrevisaoInicio(), to.getDescricao(), to.getUnidade().getIdUnidade(), to.getProjeto().getId(), to.getPlanosAcao().getId());
		
		Atividades entity = entityOptional.get();
		
		entity = atividadesTOBuilder.build(to);
		
		UsuarioLogadoTO usuarioLogado = getUsuarioLogadoCmd.getUsuarioLogado();
		entity.setUsuarioAlteracao(usuarioLogado.getIdUsuario());
		
		repository.save(entity);
		
	}
}
