package br.com.crux.rule;

import java.util.Optional;

import org.springframework.stereotype.Component;

import br.com.crux.entity.UsuariosSistema;
import br.com.crux.exception.UsuarioSemAcessoUnidadeException;

@Component
public class UsuarioSistemaNaoEncontradoRule {

	public void verificar(Optional<UsuariosSistema> usuarioSistema) {
		if(!usuarioSistema.isPresent()) {
			throw new UsuarioSemAcessoUnidadeException("O usuário informado não existe.");
		}
	}

}
