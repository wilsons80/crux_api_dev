package br.com.crux.rule;

import java.util.Objects;

import org.springframework.stereotype.Component;

import br.com.crux.exception.CamposObrigatoriosException;

@Component
public class CamposObrigatoriosUniformesAlunoRule {

	public void verificar(Long idAtividadesAluno) {
		if(Objects.isNull(idAtividadesAluno)) {
			throw new CamposObrigatoriosException("Atividade do aluno deve ser informada.");
		}
		
	}
}
