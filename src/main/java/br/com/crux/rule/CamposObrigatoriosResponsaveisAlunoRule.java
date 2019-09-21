package br.com.crux.rule;

import java.util.Objects;

import org.springframework.stereotype.Component;

import br.com.crux.exception.CamposObrigatoriosException;

@Component
public class CamposObrigatoriosResponsaveisAlunoRule {

	public void verificar(Long idAluno, Long idFamiliar) {

		if(Objects.isNull(idAluno)) {
			throw new CamposObrigatoriosException("Atividade deve ser informada.");
		}

		if(Objects.isNull(idAluno)) {
			throw new CamposObrigatoriosException("Familiar deve ser informado.");
		}

	}
}
