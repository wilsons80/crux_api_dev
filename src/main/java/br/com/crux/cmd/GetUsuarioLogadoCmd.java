package br.com.crux.cmd;

import java.util.Objects;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import br.com.crux.exception.NotFoundException;

@Component
public class GetUsuarioLogadoCmd {

	
	public Authentication get() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(Objects.isNull(authentication)) {
			throw new NotFoundException("Problema ao recuperar o usuário logado.");
		}
		return authentication;
	}
	
}
