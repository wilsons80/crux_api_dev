package br.com.crux.rule;

import java.time.LocalDateTime;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import br.com.crux.exception.CamposObrigatoriosException;

@Component
public class CamposObrigatoriosAtividadeRule {

	public void verificar(LocalDateTime dataInicio, String descricao,  Long idUnidade, Long idProjeto , Long idPlanoAcao) {
		if(Objects.isNull(dataInicio)) {
			throw new CamposObrigatoriosException("Data de Início deve ser informada.");
		}
		
		if(StringUtils.isEmpty(descricao)) {
			throw new CamposObrigatoriosException("Descrição deve ser informada.");
		}

		if(Objects.isNull(idUnidade)) {
			throw new CamposObrigatoriosException("Unidade deve ser informada.");
		}
		
		if(Objects.isNull(idProjeto)) {
			throw new CamposObrigatoriosException("Projeto deve ser informado.");
		}

		if(Objects.isNull(idPlanoAcao)) {
			throw new CamposObrigatoriosException("Plano de Ação deve ser informado.");
		}
		
	}
}
