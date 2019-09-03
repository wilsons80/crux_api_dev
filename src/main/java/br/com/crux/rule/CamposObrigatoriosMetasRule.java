package br.com.crux.rule;

import java.time.LocalDateTime;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import br.com.crux.exception.CamposObrigatoriosException;

@Component
public class CamposObrigatoriosMetasRule {

	public void verificar(String nome, LocalDateTime dataInicio, Long idIndicadores) {
		if(StringUtils.isEmpty(nome)) {
			throw new CamposObrigatoriosException("O nome do departamento deve ser informado.");
		}
		
		if(Objects.isNull(dataInicio)) {
			throw new CamposObrigatoriosException("Data de Início deve ser informada.");
		}

		if(Objects.isNull(idIndicadores)) {
			throw new CamposObrigatoriosException("Indicador deve ser informado.");
		}
		
	}
}