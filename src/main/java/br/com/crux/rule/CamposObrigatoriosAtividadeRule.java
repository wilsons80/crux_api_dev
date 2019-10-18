package br.com.crux.rule;

import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import br.com.crux.exception.CamposObrigatoriosException;
import br.com.crux.to.AtividadesTO;

@Component
public class CamposObrigatoriosAtividadeRule {

	public void verificar(AtividadesTO to) {
		if (Objects.isNull(to.getDataInicio())) {
			throw new CamposObrigatoriosException("Data de Início deve ser informada.");
		}

		if (Objects.isNull(to.getDataPrevisaoInicio())) {
			throw new CamposObrigatoriosException("Data de Previsão Início deve ser informada.");
		}

		if (StringUtils.isEmpty(to.getDescricao())) {
			throw new CamposObrigatoriosException("Descrição deve ser informada.");
		}

		if (Objects.isNull(to.getUnidade())) {
			throw new CamposObrigatoriosException("Unidade deve ser informada.");
		}

		if (Objects.isNull(to.getProjeto())) {
			throw new CamposObrigatoriosException("Projeto deve ser informado.");
		}

		if (Objects.isNull(to.getPlanosAcao())) {
			throw new CamposObrigatoriosException("Plano de Ação deve ser informado.");
		}

	}
}
