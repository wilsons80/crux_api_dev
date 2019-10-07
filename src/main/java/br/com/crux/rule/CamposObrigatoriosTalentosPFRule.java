package br.com.crux.rule;

import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import br.com.crux.exception.CamposObrigatoriosException;
import br.com.crux.to.TalentosPfTO;

@Component
public class CamposObrigatoriosTalentosPFRule {


	public void verificar(TalentosPfTO to) {

		if(Objects.isNull(to.getPessoasFisica())) {
			throw new CamposObrigatoriosException("Pessoa Física deve ser informada.");
		}
		
		if(StringUtils.isEmpty(to.getRespostaTalento())) {
			throw new CamposObrigatoriosException("Resposta do Talento deve ser informado.");
		}

		if(Objects.isNull(to.getQuestionario())) {
			throw new CamposObrigatoriosException("Questionário deve ser informado.");
		}
	}
}
