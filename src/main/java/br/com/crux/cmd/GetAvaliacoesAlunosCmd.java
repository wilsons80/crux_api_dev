package br.com.crux.cmd;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.AvaliacoesAlunosTOBuilder;
import br.com.crux.dao.repository.AvaliacoesAlunosRepository;
import br.com.crux.entity.AvaliacoesAlunos;
import br.com.crux.entity.UniformesAluno;
import br.com.crux.exception.NotFoundException;
import br.com.crux.to.AlunoTO;
import br.com.crux.to.AvaliacoesAlunosTO;
import br.com.crux.to.UniformesAlunoTO;

@Component
public class GetAvaliacoesAlunosCmd {

	@Autowired private AvaliacoesAlunosRepository repository;
	@Autowired private AvaliacoesAlunosTOBuilder toBuilder;
	@Autowired private GetUnidadeLogadaCmd getUnidadeLogadaCmd;
	@Autowired private GetAlunoCmd getAlunoCmd;
	
	
	public List<AvaliacoesAlunosTO> getAll() {
		Long idUnidade = getUnidadeLogadaCmd.get().getId();
		Optional<List<AvaliacoesAlunos>> entitys = repository.findByUnidade(idUnidade);
		if(entitys.isPresent()) {
			return toBuilder.buildAll(entitys.get());
		}
		return new ArrayList<AvaliacoesAlunosTO>();
	}
	
	public AvaliacoesAlunosTO getById(Long id) {
		Optional<AvaliacoesAlunos> entityOptional = repository.findById(id);
		if(!entityOptional.isPresent()) {
			throw new NotFoundException("Avaliação do aluno não encontrada.");
		}
		return toBuilder.buildTO(entityOptional.get());
	}
		
	
	
	public List<AvaliacoesAlunosTO>  getAllAlunosMatriculadosTO(Long idAtividade) {
		return toBuilder.buildAll(getAllFilter(null, idAtividade));
	}
	
	public List<AvaliacoesAlunos>  getAllAlunosMatriculados(Long idAtividade) {
		return getAllFilter(null, idAtividade);
	}
	
	public List<AvaliacoesAlunos> getAllFilter(Long idAluno, Long idAtividade) {
		Long idUnidade = null;
		
		if(Objects.isNull(idAluno)) {
			idUnidade = getUnidadeLogadaCmd.get().getId(); 
		}else {
			AlunoTO alunoTO = getAlunoCmd.getTOById(idAluno);
			idUnidade = alunoTO.getUnidade().getIdUnidade();
		}
		Optional<List<AvaliacoesAlunos>> entitys = Optional.empty();
		
		if(Objects.isNull(idAluno) && Objects.isNull(idAtividade)) {
			entitys = repository.findByUnidade(idUnidade);	
		}else if(Objects.isNull(idAluno) && Objects.nonNull(idAtividade)) {
			entitys = repository.findByAtividade(idAtividade);
		}else if(Objects.isNull(idAtividade)  && Objects.nonNull(idAluno)) {
			entitys = repository.findByAluno(idAluno);
		}else if(Objects.nonNull(idAluno) && Objects.nonNull(idAtividade)) {
			entitys = repository.findByAlunoAndAtividade(idAluno, idAtividade);
		}
		
		if(entitys.isPresent()) {
			return entitys.get();
		}
		return new ArrayList<AvaliacoesAlunos>();
	}
}
