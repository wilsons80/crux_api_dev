package br.com.crux.rule;

import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import br.com.crux.exception.CamposObrigatoriosException;
import br.com.crux.to.UsuariosSistemaTO;

@Component
public class CamposObrigatoriosUsuariosSistemaRule {

	public void verificar(UsuariosSistemaTO to) {
		if(StringUtils.isEmpty(to.getUsername())) {
			throw new CamposObrigatoriosException("Username deve ser informado.");
		}

		if (Objects.isNull(to.getSenha())) {
			throw new CamposObrigatoriosException("Senha deve ser informada.");
		}

		if(Objects.isNull(to.getPessoaFisica())) {
			throw new CamposObrigatoriosException("Pessoa Fícisa deve ser informada.");
		}		
	}
}
