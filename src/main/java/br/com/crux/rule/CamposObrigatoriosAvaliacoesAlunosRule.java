package br.com.crux.rule;

import java.util.Objects;

import org.springframework.stereotype.Component;

import br.com.crux.exception.CamposObrigatoriosException;

@Component
public class CamposObrigatoriosAvaliacoesAlunosRule {

	public void verificar(Long idAtividade, Long idAvaliacao) {
		if(Objects.isNull(idAtividade)) {
			throw new CamposObrigatoriosException("Atividade deve ser informada.");
		}
		if(Objects.isNull(idAvaliacao)) {
			throw new CamposObrigatoriosException("Avaliacao deve ser informada.");
		}
		
	}
}
