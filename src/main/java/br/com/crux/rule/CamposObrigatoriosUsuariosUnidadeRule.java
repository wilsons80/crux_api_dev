package br.com.crux.rule;

import java.util.Optional;

import org.springframework.stereotype.Component;

import br.com.crux.entity.Unidade;
import br.com.crux.entity.UsuariosSistema;
import br.com.crux.exception.CamposObrigatoriosException;

@Component
public class CamposObrigatoriosUsuariosUnidadeRule {

	public void verificar(UsuariosSistema usuariosSistema, Unidade unidade) {

		Optional.ofNullable(usuariosSistema).orElseThrow(() -> new CamposObrigatoriosException("Usuário do Sistema deve ser informado."));
		Optional.ofNullable(unidade).orElseThrow(() -> new CamposObrigatoriosException("Unidade deve ser informado."));

	}
}
