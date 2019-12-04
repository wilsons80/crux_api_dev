package br.com.crux.rule;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import br.com.crux.exception.CamposObrigatoriosException;
import br.com.crux.to.NiveisTurmasTO;

@Component
public class CamposObrigatoriosNiveisTurmasRule {


	public void verificar(NiveisTurmasTO to) {
		if(StringUtils.isEmpty(to.getCodigo())) {
			throw new CamposObrigatoriosException("O código deve ser informado.");
		}
		
		if(StringUtils.isEmpty(to.getDescricao())) {
			throw new CamposObrigatoriosException("Descrição deve ser informada.");
		}
	}
}
