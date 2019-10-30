package br.com.crux.cmd;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.AtividadesAlunoTOBuilder;
import br.com.crux.builder.FrequenciasAlunosTOBuilder;
import br.com.crux.dao.repository.FrequenciasAlunosRepository;
import br.com.crux.entity.FrequenciasAlunos;
import br.com.crux.exception.NotFoundException;
import br.com.crux.infra.util.Java8DateUtil;
import br.com.crux.to.AtividadesAlunoTO;
import br.com.crux.to.FrequenciasAlunosTO;

@Component
public class GetFrequenciasAlunosCmd {

	@Autowired private FrequenciasAlunosRepository repository;
	@Autowired private FrequenciasAlunosTOBuilder toBuilder;
	@Autowired private GetUnidadeLogadaCmd getUnidadeLogadaCmd;
	@Autowired private GetAtividadesAlunoCmd getAtividadesAlunoCmd;
	@Autowired private AtividadesAlunoTOBuilder atividadeAlunoTOBuilder;
	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;
	

	public List<FrequenciasAlunosTO> getAllAlunosMatriculadosTO(Long idAtividade, Long dataFrequenciaLong) {
		List<FrequenciasAlunos> frequencias = getAlunosMatriculados(idAtividade, dataFrequenciaLong);
		return toBuilder.buildAll(frequencias);
	}

	
	public List<FrequenciasAlunosTO> getAllTO(Long idAtividade, Long dataFrequenciaLong) {
		List<FrequenciasAlunos> frequencias = get(idAtividade, dataFrequenciaLong);
		return toBuilder.buildAll(frequencias);
	}
	
	public List<FrequenciasAlunos> getAll(Long idAtividade, Long dataFrequenciaLong) {
		return get(idAtividade, dataFrequenciaLong);
	}
	
	private List<FrequenciasAlunos> get(Long idAtividade, Long dataFrequenciaLong) {
		LocalDate dataFrequencia = Java8DateUtil.getLocalDate(new Date(dataFrequenciaLong));
		
		Optional<List<FrequenciasAlunos>> entitys = Optional.empty();
		entitys = repository.findByAtividadeAndData(idAtividade,dataFrequencia);
		
		if(entitys.isPresent()) {
			return entitys.get();
		}
		
		return new ArrayList<FrequenciasAlunos>();		
	}
	
	private List<FrequenciasAlunos> getAlunosMatriculados(Long idAtividade, Long dataFrequenciaLong) {
		List<FrequenciasAlunos> frequencias = new ArrayList<FrequenciasAlunos>();
		LocalDate dataFrequencia = Java8DateUtil.getLocalDate(new Date(dataFrequenciaLong));
		
		
		List<AtividadesAlunoTO> atividades = getAtividadesAlunoCmd.getAllAlunosMatriculadosNaAtividade(idAtividade);
		List<AtividadesAlunoTO> atividadesAlunos = atividades.stream().filter( atividadeAluno -> {
			return Java8DateUtil.isVigente(dataFrequencia, atividadeAluno.getDataInicioAtividade().toLocalDate(), 
					(Objects.nonNull(atividadeAluno.getDataDesvinculacao()) ? 
							atividadeAluno.getDataDesvinculacao().toLocalDate() : null));
		}).collect(Collectors.toList());
		
		atividadesAlunos.stream().forEach( atividade -> {
			FrequenciasAlunos frequencia = new FrequenciasAlunos();
			
			frequencia.setAtividadesAluno(atividadeAlunoTOBuilder.build(atividade));
			frequencia.setDataFrequencia(dataFrequencia);
			frequencia.setFrequencia(Boolean.TRUE);
			frequencia.setUsuarioAlteracao(getUsuarioLogadoCmd.getUsuarioLogado().getIdUsuario());
			frequencias.add(frequencia);
		});
		
		
		return frequencias;		
	}
	
	
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

			
}
