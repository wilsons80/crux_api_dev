package br.com.crux.rule;

import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import br.com.crux.exception.CamposObrigatoriosException;

@Component
public class CamposObrigatoriosDocumentosAtividadeRule {

	public void verificar(String descricao, Long idAtividade) {
		
		if(StringUtils.isEmpty(descricao)) {
			throw new CamposObrigatoriosException("Descrição deve ser informada.");
		}
		if(Objects.isNull(idAtividade)) {
			throw new CamposObrigatoriosException("Atividade deve ser informada.");
		}
		
	}
}
