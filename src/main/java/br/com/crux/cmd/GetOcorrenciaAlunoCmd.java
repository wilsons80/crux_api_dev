package br.com.crux.cmd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.OcorrenciaAlunoTOBuilder;
import br.com.crux.dao.repository.OcorrenciaAlunoRepository;
import br.com.crux.entity.OcorrenciaAluno;
import br.com.crux.exception.NotFoundException;
import br.com.crux.to.OcorrenciaAlunoTO;

@Component
public class GetOcorrenciaAlunoCmd {

	@Autowired private OcorrenciaAlunoRepository repository;
	@Autowired private OcorrenciaAlunoTOBuilder tOBuilder;
	@Autowired private GetUnidadeLogadaCmd getUnidadeLogadaCmd;
	
	public List<OcorrenciaAlunoTO> getAll() {
		Optional<List<OcorrenciaAluno>> entitys = repository.findAllByUnidade(getUnidadeLogadaCmd.get().getId());
		
		if(entitys.isPresent()) {
			return tOBuilder.buildAll(entitys.get());
		}
		return new ArrayList<OcorrenciaAlunoTO>();
	}
	
	public OcorrenciaAlunoTO getById(Long id) {
		Optional<OcorrenciaAluno> entityOptional = repository.findById(id);
		if(!entityOptional.isPresent()) {
			throw new NotFoundException("Ocorrência do aluno não encontrada.");
		}
		return tOBuilder.buildTO(entityOptional.get());
	}
			
}
