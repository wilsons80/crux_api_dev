package br.com.crux.cmd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.FrequenciasAlunosTOBuilder;
import br.com.crux.dao.repository.FrequenciasAlunosRepository;
import br.com.crux.entity.FrequenciasAlunos;
import br.com.crux.exception.NotFoundException;
import br.com.crux.to.FrequenciasAlunosTO;

@Component
public class GetFrequenciasAlunosCmd {

	@Autowired private FrequenciasAlunosRepository repository;
	@Autowired private FrequenciasAlunosTOBuilder toBuilder;
	@Autowired private GetUnidadeLogadaCmd getUnidadeLogadaCmd;
	
	
	public List<FrequenciasAlunosTO> getAll() {
		Optional<List<FrequenciasAlunos>> entitys = repository.findByUnidade(getUnidadeLogadaCmd.get().getId());
		if(entitys.isPresent()) {
			return toBuilder.buildAll(entitys.get());
		}
		return new ArrayList<FrequenciasAlunosTO>();
	}
	
	public FrequenciasAlunosTO getTOById(Long id) {
		FrequenciasAlunos entity = repository.findById(id).orElseThrow(() -> new NotFoundException("Frequencia do aluno não encontrada."));
		return toBuilder.buildTO(entity);
	}
	
	public FrequenciasAlunos getById(Long id) {
		return repository.findById(id).orElseGet(null);
	}


	public FrequenciasAlunosTO getPorAlunoAtividadeUnidadeLogada(Long idAluno, Long idAtividade) {
	//	return repository.getPorAlunoAtividadeUnidadeLogada(idAluno, idAtividade, getUnidadeLogadaCmd.get().getId());
	return null;	
	}

//	public FrequenciasAlunosTO getPorAluno(Long idAluno) {
//		Long idUnidade = getUnidadeLogadaCmd.get().getId();
//		return repository.getPorAluno(idAluno,idUnidade);
//	}
//
//	public FrequenciasAlunosTO getPorAtividade(Long idAtividade) {
//		Long idUnidade = getUnidadeLogadaCmd.get().getId();
//		return repository.getPorAtividade(idAtividade,idUnidade);
//	}
//	
	
			
}
