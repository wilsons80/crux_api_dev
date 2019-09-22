package br.com.crux.rule;

import java.util.Objects;

import org.springframework.stereotype.Component;

import br.com.crux.exception.CamposObrigatoriosException;

@Component
public class CamposObrigatoriosParticipantesAtendimentosRule {

	public void verificar(Long idAtendimento, Long idFuncionario) {
		if(Objects.isNull(idAtendimento)) {
			throw new CamposObrigatoriosException("Atendimento deve ser informado.");
		}
		if(Objects.isNull(idFuncionario)) {
			throw new CamposObrigatoriosException("Funcionario deve ser informado.");
		}
		
	}
}
