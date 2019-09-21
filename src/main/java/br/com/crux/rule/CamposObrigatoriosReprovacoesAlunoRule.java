package br.com.crux.rule;

import java.util.Objects;

import org.springframework.stereotype.Component;

import br.com.crux.exception.CamposObrigatoriosException;

@Component
public class CamposObrigatoriosReprovacoesAlunoRule {

	public void verificar(Long idAluno) {
		if(Objects.isNull(idAluno)) {
			throw new CamposObrigatoriosException("Aluno deve ser informado.");
		}
		
	}
}
