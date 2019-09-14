package br.com.crux.rule;

import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import br.com.crux.exception.CamposObrigatoriosException;

@Component
public class CamposObrigatoriosPessoaFisicaRule {

	public void verificar(String nome, Long cpf, String endereco, String foneCelular) {
		if(StringUtils.isEmpty(nome)) {
			throw new CamposObrigatoriosException("Nome deve ser informado.");
		}

		if(Objects.isNull(cpf)) {
			throw new CamposObrigatoriosException("CPF deve ser informado.");
		}
		if(StringUtils.isEmpty(endereco)) {
			throw new CamposObrigatoriosException("Endereço deve ser informado.");
		}
		if(StringUtils.isEmpty(foneCelular)) {
			throw new CamposObrigatoriosException("Celular deve ser informado.");
		}
		
	}
}
