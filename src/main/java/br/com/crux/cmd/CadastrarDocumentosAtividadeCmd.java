package br.com.crux.cmd;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.AtividadeTOBuilder;
import br.com.crux.dao.repository.AtividadeRepository;
import br.com.crux.dao.repository.DocumentosAtividadeRepository;
import br.com.crux.entity.Atividade;
import br.com.crux.entity.DocumentosAtividade;
import br.com.crux.exception.NotFoundException;
import br.com.crux.rule.CamposObrigatoriosDocumentosAtividadeRule;
import br.com.crux.to.DocumentosAtividadeTO;
import br.com.crux.to.UsuarioLogadoTO;

@Component
public class CadastrarDocumentosAtividadeCmd {

	@Autowired private DocumentosAtividadeRepository repository;
	
	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;
	@Autowired private AtividadeRepository atividadeRepository;
	
	@Autowired private AtividadeTOBuilder atividadeBuilder;
	
	@Autowired private CamposObrigatoriosDocumentosAtividadeRule camposObrigatoriosRule;
	
	
	public void cadastrar(DocumentosAtividadeTO to) {
		
		if(Objects.isNull(to.getAtividade())) {
			throw new NotFoundException("Atividade não informada.");
		}
		
		camposObrigatoriosRule.verificar(to.getDescricao(), to.getAtividade().getId());
		
		Optional<Atividade> entityOptional = atividadeRepository.findById(to.getAtividade().getId());
		if(!entityOptional.isPresent()) {
			throw new NotFoundException("Atividade informada não existe.");
		}		
				
		DocumentosAtividade entity = new DocumentosAtividade();

		entity.setDescricao(to.getDescricao());
		entity.setObservacao(to.getObservacao());
		entity.setAtividade(atividadeBuilder.build(to.getAtividade()));
		
		UsuarioLogadoTO usuarioLogado = getUsuarioLogadoCmd.getUsuarioLogado();
		entity.setUsuarioAlteracao(usuarioLogado.getIdUsuario());
		
		repository.save(entity);
		
	}
}
