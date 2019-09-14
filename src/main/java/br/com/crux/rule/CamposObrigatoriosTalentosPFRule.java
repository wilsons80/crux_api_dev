package br.com.crux.rule;

import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import br.com.crux.exception.CamposObrigatoriosException;

@Component
public class CamposObrigatoriosTalentosPFRule {

	public void verificar(String respostaTalento, Long idPessoaFisica, Long idQuestionario) {
		if(Objects.isNull(idPessoaFisica)) {
			throw new CamposObrigatoriosException("Pessoa Fisico deve ser informada.");
		}
		
		if(StringUtils.isEmpty(respostaTalento)) {
			throw new CamposObrigatoriosException("Resposta do Talento deve ser informado.");
		}

		if(Objects.isNull(idQuestionario)) {
			throw new CamposObrigatoriosException("Questionário deve ser informado.");
		}
		
	}
}
