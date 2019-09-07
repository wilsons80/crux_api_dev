package br.com.crux.cmd;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import br.com.crux.exception.NotFoundException;
import br.com.crux.to.UsuarioLogadoHolder;
import br.com.crux.to.UsuarioLogadoTO;

@SessionScope
@Component
public class GetUsuarioLogadoCmd {

	@Autowired private UsuarioLogadoHolder usuarioLogadoHolder;
	
	
	public Authentication get() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(Objects.isNull(authentication)) {
			throw new NotFoundException("Problema ao recuperar o usuário logado.");
		}
		return authentication;
	}
	
	public UsuarioLogadoTO getUsuarioLogado() {
		UsuarioLogadoTO usuarioLogado = usuarioLogadoHolder.getUsuarioLogadoTO();
		
		if(usuarioLogado == null) {
			throw new NotFoundException("Erro ao recuperar o usuário logado.");
		}

		return usuarioLogado;
	}
	
}
