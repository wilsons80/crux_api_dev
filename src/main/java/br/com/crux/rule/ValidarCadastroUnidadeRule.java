package br.com.crux.rule;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import br.com.crux.exception.ParametroNaoInformado;

@Component
public class ValidarCadastroUnidadeRule {
	
	
	public void validar(String sigla, String nome) {
		if(StringUtils.isEmpty(sigla)) {
			throw new ParametroNaoInformado("A sigla da unidade não foi informada.");
		}
		if(StringUtils.isEmpty(nome)) {
			throw new ParametroNaoInformado("O nomeda da unidade não foi informada.");
		}
	}

}
