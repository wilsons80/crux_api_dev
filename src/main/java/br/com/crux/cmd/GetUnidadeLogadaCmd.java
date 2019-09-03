package br.com.crux.cmd;

import java.util.Objects;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import br.com.crux.exception.NotFoundException;
import br.com.crux.to.UnidadeLogadaTO;

@Component
public class GetUnidadeLogadaCmd {

	public UnidadeLogadaTO get() {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(Objects.isNull(auth)) {
			throw new NotFoundException("Problema ao recuperar o usuário logado.");
		}
		
		if(Objects.nonNull(auth.getDetails())) {
			return (UnidadeLogadaTO) auth.getDetails();
		}

		return null;
	}
}
