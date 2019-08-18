package br.com.crux.rule;

import java.util.Objects;

import br.com.crux.exception.ParametroNaoInformado;

public class VerificaParametrosAcessoRule {

	public void verificar(Long idUsarname, Long idUnidade) {
		if (Objects.isNull(idUsarname)) {
			throw new ParametroNaoInformado("Parâmetro username não informado");
		}
		if (Objects.isNull(idUnidade)) {
			throw new ParametroNaoInformado("Parâmetro unidade não informado");
		}
		
	}

}
