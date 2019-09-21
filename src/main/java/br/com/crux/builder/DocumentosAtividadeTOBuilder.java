package br.com.crux.builder;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.entity.DocumentosAtividade;
import br.com.crux.to.DocumentosAtividadeTO;


@Component
public class DocumentosAtividadeTOBuilder {
	
	@Autowired
	private AtividadesTOBuilder atividadeTOBuilder;
	

	public DocumentosAtividade build(DocumentosAtividadeTO param) {
		DocumentosAtividade retorno = new DocumentosAtividade();
		
		retorno.setId(param.getId());
		retorno.setDescricao(param.getDescricao());
		retorno.setObservacao(param.getObservacao());
		retorno.setAtividade(atividadeTOBuilder.build(param.getAtividade()));
		retorno.setUsuarioAlteracao(param.getUsuarioAlteracao());
		
		return retorno;
	}

	
	public DocumentosAtividadeTO buildTO(DocumentosAtividade param) {
		DocumentosAtividadeTO retorno = new DocumentosAtividadeTO();
		
		retorno.setId(param.getId());
		retorno.setDescricao(param.getDescricao());
		retorno.setObservacao(param.getObservacao());
		retorno.setAtividade(atividadeTOBuilder.buildTO(param.getAtividade()));
		retorno.setUsuarioAlteracao(param.getUsuarioAlteracao());

		
		return retorno;
	}
	
	
	
	public List<DocumentosAtividadeTO> buildAll(List<DocumentosAtividade> dtos){
		return dtos.stream().map(dto -> buildTO(dto)).collect(Collectors.toList());
	}

}
