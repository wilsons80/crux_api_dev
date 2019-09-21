package br.com.crux.rule;

import java.util.Objects;

import org.springframework.stereotype.Component;

import br.com.crux.exception.CamposObrigatoriosException;

@Component
public class CamposObrigatoriosEntidadesSociaisRule {

	public void verificar(Long idEmpresa) {
		if(Objects.isNull(idEmpresa)) {
			throw new CamposObrigatoriosException("Empresa deve ser informada.");
		}
		
	}
}
