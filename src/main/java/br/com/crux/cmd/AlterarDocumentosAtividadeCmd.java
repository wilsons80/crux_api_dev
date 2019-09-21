package br.com.crux.cmd;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.AtividadesTOBuilder;
import br.com.crux.dao.repository.AtividadeRepository;
import br.com.crux.dao.repository.DocumentosAtividadeRepository;
import br.com.crux.entity.Atividades;
import br.com.crux.entity.DocumentosAtividade;
import br.com.crux.exception.NotFoundException;
import br.com.crux.rule.CamposObrigatoriosDocumentosAtividadeRule;
import br.com.crux.to.DocumentosAtividadeTO;
import br.com.crux.to.UsuarioLogadoTO;

@Component
public class AlterarDocumentosAtividadeCmd {

	@Autowired private DocumentosAtividadeRepository repository;
	
	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;
	@Autowired private AtividadeRepository atividadeRepository;
	
	@Autowired private AtividadesTOBuilder atividadeBuilder;
	
	@Autowired private CamposObrigatoriosDocumentosAtividadeRule camposObrigatoriosRule;
	
	
	public void alterar(DocumentosAtividadeTO to) {
		Optional<DocumentosAtividade> entityOptional = repository.findById(to.getId());
		if(!entityOptional.isPresent()) {
			throw new NotFoundException("Documento da Atividade não existe.");
		}
		
		if(Objects.isNull(to.getAtividade())) {
			throw new NotFoundException("Atividade não informada.");
		}
		
		camposObrigatoriosRule.verificar(to.getDescricao(), to.getAtividade().getId());
		
		Optional<Atividades> atividadeOptional = atividadeRepository.findById(to.getAtividade().getId());
		if(!atividadeOptional.isPresent()) {
			throw new NotFoundException("Atividade informado não existe.");
		}
		
		DocumentosAtividade entity = entityOptional.get();

		entity.setId(to.getId());
		entity.setDescricao(to.getDescricao());
		entity.setObservacao(to.getObservacao());
		entity.setAtividade(atividadeBuilder.build(to.getAtividade()));
		
		UsuarioLogadoTO usuarioLogado = getUsuarioLogadoCmd.getUsuarioLogado();
		entity.setUsuarioAlteracao(usuarioLogado.getIdUsuario());
		
		repository.save(entity);
		
	}
}
