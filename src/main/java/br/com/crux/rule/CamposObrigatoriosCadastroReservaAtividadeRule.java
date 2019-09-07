package br.com.crux.rule;

import java.util.Objects;

import org.springframework.stereotype.Component;

import br.com.crux.exception.CamposObrigatoriosException;

@Component
public class CamposObrigatoriosCadastroReservaAtividadeRule {

	public void verificar(Long idAtividade, Long idPessoaFisica) {
		if(Objects.isNull(idPessoaFisica)) {
			throw new CamposObrigatoriosException("Pessoa física deve ser informada.");
		}

		if(Objects.isNull(idAtividade)) {
			throw new CamposObrigatoriosException("Atividade deve ser informada.");
		}
		
	}
}
