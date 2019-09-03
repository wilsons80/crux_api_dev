package br.com.crux.rule;

import java.time.LocalDateTime;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import br.com.crux.exception.CamposObrigatoriosException;

@Component
public class CamposObrigatoriosProjetoRule {

	public void verificar(String nome, LocalDateTime dataPrevisaoInicio) {
		
		if(StringUtils.isEmpty(nome)) {
			throw new CamposObrigatoriosException("Nome deve ser informado.");
		}
		if(Objects.isNull(dataPrevisaoInicio)) {
			throw new CamposObrigatoriosException("Data de Início da Previsão deve ser informada.");
		}
		
	}
}
