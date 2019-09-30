package br.com.crux.rule;

import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import br.com.crux.enums.TipoCargo;
import br.com.crux.exception.CamposObrigatoriosException;

@Component
public class CamposObrigatoriosCargosRule {

	public void verificar(String codigo, String nome, TipoCargo tipoCargo) {
		if(StringUtils.isEmpty(nome)) {
			throw new CamposObrigatoriosException("Nome deve ser informado.");
		}
		if(StringUtils.isEmpty(codigo)) {
			throw new CamposObrigatoriosException("Código deve ser informado.");
		}
		
		if(Objects.isNull(tipoCargo)) {
			throw new CamposObrigatoriosException("Tipo do Cargo deve ser informada.");
		}
		
	}
	
}
