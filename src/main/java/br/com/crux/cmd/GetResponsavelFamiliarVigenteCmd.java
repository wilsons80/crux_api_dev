package br.com.crux.cmd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.ResponsaveisAlunoTOBuilder;
import br.com.crux.dao.repository.ResponsaveisAlunoRepository;
import br.com.crux.entity.ResponsaveisAluno;
import br.com.crux.to.ResponsaveisAlunoTO;

@Component
public class GetResponsavelFamiliarVigenteCmd {

	@Autowired private ResponsaveisAlunoRepository responsaveisAlunoRepository;
	@Autowired private GetUnidadeLogadaCmd getUnidadeLogadaCmd;
	@Autowired private ResponsaveisAlunoTOBuilder responsaveisAlunoTOBuilder;
	
	public List<ResponsaveisAlunoTO> getAllResponsaveisVigentes(Long idAluno) {
		Optional<List<ResponsaveisAluno>> responsavelVigente = responsaveisAlunoRepository.findAllResponsaveisVigentes(idAluno, getUnidadeLogadaCmd.get().getId());
		if(responsavelVigente.isPresent()) {
			List<ResponsaveisAluno> list = responsavelVigente.get();
			return responsaveisAlunoTOBuilder.buildAll(list);
		}
		return new ArrayList<ResponsaveisAlunoTO>();
	}
	
}
