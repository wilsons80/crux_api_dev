package br.com.crux.rule;

import java.util.Objects;

import org.springframework.stereotype.Component;

import br.com.crux.exception.CamposObrigatoriosException;

@Component
public class CamposObrigatoriosFrequenciasAlunosRule {

	public void verificar(Long idAtividadeAlunos) {
		if(Objects.isNull(idAtividadeAlunos)) {
			throw new CamposObrigatoriosException("Atividade do aluno deve ser informada.");
		}
		
	}
}
