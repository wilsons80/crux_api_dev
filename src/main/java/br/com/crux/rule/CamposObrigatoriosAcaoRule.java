package br.com.crux.rule;

import java.time.LocalDateTime;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import br.com.crux.exception.CamposObrigatoriosException;

@Component
public class CamposObrigatoriosAcaoRule {

	public void verificar(LocalDateTime dataInicio, String nome,  Long idAtividade) {
		if(Objects.isNull(dataInicio)) {
			throw new CamposObrigatoriosException("Data de Início deve ser informada.");
		}
		
		if(StringUtils.isEmpty(nome)) {
			throw new CamposObrigatoriosException("Nome deve ser informado.");
		}

		if(Objects.isNull(idAtividade)) {
			throw new CamposObrigatoriosException("Atividade deve ser informada.");
		}
		
	}
}
