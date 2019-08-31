package br.com.crux.rule;

import java.time.LocalDateTime;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import br.com.crux.exception.CamposObrigatoriosException;

@Component
public class CamposObrigatoriosPerspectivaRule {

	public void verificar(String nome, LocalDateTime dataImplantacao, Long idUnidade) {
		if(StringUtils.isEmpty(nome)) {
			throw new CamposObrigatoriosException("O nome do departamento deve ser informado.");
		}
		
		if(Objects.isNull(dataImplantacao)) {
			throw new CamposObrigatoriosException("Data de implantação deve ser informada.");
		}

		if(Objects.isNull(idUnidade)) {
			throw new CamposObrigatoriosException("Unidade deve ser informada.");
		}
		
	}
}
