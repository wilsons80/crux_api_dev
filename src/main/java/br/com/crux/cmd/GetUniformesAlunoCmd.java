package br.com.crux.cmd;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.UniformesAlunoTOBuilder;
import br.com.crux.dao.repository.UniformesAlunoRepository;
import br.com.crux.entity.UniformesAluno;
import br.com.crux.exception.NotFoundException;
import br.com.crux.infra.util.Java8DateUtil;
import br.com.crux.to.AlunoTO;
import br.com.crux.to.UniformesAlunoTO;

@Component
public class GetUniformesAlunoCmd {

	@Autowired private UniformesAlunoRepository repository;
	@Autowired private UniformesAlunoTOBuilder toBuilder;
	@Autowired private GetUnidadeLogadaCmd getUnidadeLogadaCmd;
	@Autowired private GetAlunoCmd getAlunoCmd;
	
	
	public List<UniformesAlunoTO>  getAllAlunosMatriculadosNaAtividadeNoPeriodo(Long idAtividade, LocalDateTime dataReferencia) {
		List<UniformesAlunoTO> atividadesTO = getAllFilter(null, idAtividade);
		
		List<UniformesAlunoTO> resultado = atividadesTO.stream().filter( r -> {
			return Java8DateUtil.isVigente( r.getAtividadesAluno().getDataInicioAtividade().toLocalDate(), (Objects.nonNull(r.getAtividadesAluno().getDataDesvinculacao()) ? r.getAtividadesAluno().getDataDesvinculacao().toLocalDate() : null) );
		}).collect(Collectors.toList());

		return resultado;
	}
	
	public List<UniformesAlunoTO> getAllFilter(Long idAluno, Long idAtividade) {
		Long idUnidade = null;
		
		if(Objects.isNull(idAluno)) {
			idUnidade = getUnidadeLogadaCmd.get().getId(); 
		}else {
			AlunoTO alunoTO = getAlunoCmd.getTOById(idAluno);
			idUnidade = alunoTO.getUnidade().getIdUnidade();
		}
		Optional<List<UniformesAluno>> entitys = Optional.empty();
		
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
			return toBuilder.buildAll(entitys.get());
		}
		return new ArrayList<UniformesAlunoTO>();
	}
	
	public UniformesAlunoTO getById(Long id) {
		Optional<UniformesAluno> entityOptional = repository.findById(id);
		if(!entityOptional.isPresent()) {
			throw new NotFoundException("Uniforme do aluno não encontrada.");
		}
		return toBuilder.buildTO(entityOptional.get());
	}
			
}
