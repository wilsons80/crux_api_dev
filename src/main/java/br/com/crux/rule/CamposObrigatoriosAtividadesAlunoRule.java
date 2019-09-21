package br.com.crux.rule;

import java.util.Objects;

import org.springframework.stereotype.Component;

import br.com.crux.exception.CamposObrigatoriosException;

@Component
public class CamposObrigatoriosAtividadesAlunoRule {

	public void verificar(Long idAluno, Long idAtividade) {
		if(Objects.isNull(idAtividade)) {
			throw new CamposObrigatoriosException("Atividade deve ser informada.");
		}
		if(Objects.isNull(idAluno)) {
			throw new CamposObrigatoriosException("Aluno deve ser informado.");
		}
		
	}
}
