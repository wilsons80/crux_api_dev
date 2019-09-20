package br.com.crux.rule;

import java.time.LocalDateTime;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import br.com.crux.exception.CamposObrigatoriosException;

@Component
public class CamposObrigatoriosAlunoRule {

	public void verificar(LocalDateTime dataCadastro, String matricula,  Long idUnidade, Long idPessoaFisica) {
		if(Objects.isNull(dataCadastro)) {
			throw new CamposObrigatoriosException("Data de Cadastro deve ser informada.");
		}
		
		if(StringUtils.isEmpty(matricula)) {
			throw new CamposObrigatoriosException("Matricula deve ser informada.");
		}

		if(Objects.isNull(idUnidade)) {
			throw new CamposObrigatoriosException("Unidade deve ser informada.");
		}

		if(Objects.isNull(idPessoaFisica)) {
			throw new CamposObrigatoriosException("Pessoa Fícisa deve ser informada.");
		}		
	}
}
