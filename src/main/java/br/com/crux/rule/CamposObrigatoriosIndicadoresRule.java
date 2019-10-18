package br.com.crux.rule;

import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import br.com.crux.exception.CamposObrigatoriosException;
import br.com.crux.to.IndicadoresTO;

@Component
public class CamposObrigatoriosIndicadoresRule {

	public void verificar(IndicadoresTO to) {
		if (StringUtils.isEmpty(to.getNome())) {
			throw new CamposObrigatoriosException("O nome do departamento deve ser informado.");
		}

		if (Objects.isNull(to.getDataInicio())) {
			throw new CamposObrigatoriosException("Data de Início deve ser informada.");
		}

		if (Objects.isNull(to.getObjetivo())) {
			throw new CamposObrigatoriosException("Objetivo deve ser informado.");
		}

	}
}
