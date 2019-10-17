package br.com.crux.cmd;

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
	
	public ResponsaveisAlunoTO isResponsavelVigente(Long idAluno) {
		Optional<ResponsaveisAluno> responsavelVigente = responsaveisAlunoRepository.findResponsavelVigente(idAluno, getUnidadeLogadaCmd.get().getId());
		if(responsavelVigente.isPresent()) {
			return responsaveisAlunoTOBuilder.buildTO(responsavelVigente.get());
		}
		return null;
	}
	
}
