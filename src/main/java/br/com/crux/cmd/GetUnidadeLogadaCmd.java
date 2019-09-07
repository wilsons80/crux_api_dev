package br.com.crux.cmd;

import java.util.Objects;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import br.com.crux.exception.NotFoundException;
import br.com.crux.security.CustomUserDetails;
import br.com.crux.to.AcessoUnidadeTO;

@Component
public class GetUnidadeLogadaCmd {

	public AcessoUnidadeTO get() {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(Objects.isNull(auth)) {
			throw new NotFoundException("Problema ao recuperar o usuário logado.");
		}
		
		if(auth.getPrincipal() == null) {
			throw new NotFoundException("Não é possível recuperar a unidade logada.");
		}
		
		return ((CustomUserDetails) auth.getPrincipal()).getUnidadeLogada();
	}
}
