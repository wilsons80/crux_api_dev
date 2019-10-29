package br.com.crux.rule;

import java.util.Objects;

import org.springframework.stereotype.Component;

import br.com.crux.exception.CamposObrigatoriosException;
import br.com.crux.to.ColaboradoresAtividadeTO;

@Component
public class CamposObrigatoriosColaboradoresAtividadeRule {

	public void verificar(ColaboradoresAtividadeTO to) {

		if (Objects.isNull(to.getDtEntradaAtividade())) {
			throw new CamposObrigatoriosException("Data de entrada na atividade deve ser infomada.");
		}

		if (Objects.isNull(to.getFuncionario()) || Objects.isNull(to.getFuncionario().getId())) {
			throw new CamposObrigatoriosException("Funcionário deve ser informado.");
		}

		if (Objects.isNull(to.getCargo()) || Objects.isNull(to.getCargo().getId())) {
			throw new CamposObrigatoriosException("Cargo deve ser informado.");
		}

		if (Objects.isNull(to.getAtividade()) || Objects.isNull(to.getAtividade().getId())) {
			throw new CamposObrigatoriosException("Atividade deve ser informado.");
		}

	}
}
