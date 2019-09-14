package br.com.crux.rule;

import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import br.com.crux.exception.CamposObrigatoriosException;

@Component
public class CamposObrigatoriosFaltasFuncionarioRule {

	public void verificar(String descricao, Long idFuncionarioFaltou, Long idFuncionarioCadastro) {
		if(StringUtils.isEmpty(descricao)) {
			throw new CamposObrigatoriosException("Descrição deve ser informada.");
		}
		if(Objects.isNull(idFuncionarioCadastro)) {
			throw new CamposObrigatoriosException("Funcionário do cadastro deve ser informado.");
		}
		if(Objects.isNull(idFuncionarioFaltou)) {
			throw new CamposObrigatoriosException("Funcionário que faltou deve ser informado.");
		}
	}
}
