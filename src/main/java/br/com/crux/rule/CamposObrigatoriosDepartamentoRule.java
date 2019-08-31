package br.com.crux.rule;

import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import br.com.crux.exception.CamposObrigatoriosException;

@Component
public class CamposObrigatoriosDepartamentoRule {

	public void verificar(String cdUnidadeDepartamento, String nome, Long idUnidade) {
		if(StringUtils.isEmpty(nome)) {
			throw new CamposObrigatoriosException("O nome do departamento deve ser informado.");
		}
		
		if(StringUtils.isEmpty(cdUnidadeDepartamento)) {
			throw new CamposObrigatoriosException("O código do departamento deve ser informado.");
		}
		
		if(Objects.isNull(idUnidade)) {
			throw new CamposObrigatoriosException("A unidade deve ser informada.");
		}
		
	}
}
