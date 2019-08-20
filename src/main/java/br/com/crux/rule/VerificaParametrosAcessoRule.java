package br.com.crux.rule;

import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import br.com.crux.exception.ParametroNaoInformado;

@Component
public class VerificaParametrosAcessoRule {

	public void verificar(String username, Long idUnidade) {
		if (StringUtils.isEmpty(username)) {
			throw new ParametroNaoInformado("Parâmetro username não informado");
		}
		if (Objects.isNull(idUnidade)) {
			throw new ParametroNaoInformado("Parâmetro unidade não informado");
		}
		
	}

}
