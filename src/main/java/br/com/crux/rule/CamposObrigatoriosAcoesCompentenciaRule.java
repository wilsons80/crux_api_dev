package br.com.crux.rule;

import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import br.com.crux.exception.CamposObrigatoriosException;

@Component
public class CamposObrigatoriosAcoesCompentenciaRule {

	public void verificar(String descricao, Long idtalentoPF) {
		if(Objects.isNull(idtalentoPF)) {
			throw new CamposObrigatoriosException("Talento do Funcionário deve ser informado.");
		}
		
		if(StringUtils.isEmpty(descricao)) {
			throw new CamposObrigatoriosException("Descricao deve ser informado.");
		}
		
	}
}
