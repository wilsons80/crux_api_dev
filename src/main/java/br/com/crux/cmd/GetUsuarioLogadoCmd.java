package br.com.crux.cmd;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import br.com.crux.dao.repository.UsuarioSistemaRepository;
import br.com.crux.entity.UsuariosSistema;
import br.com.crux.exception.NotFoundException;
import br.com.crux.security.CustomUserDetails;

@Component
public class GetUsuarioLogadoCmd {

	@Autowired
	private UsuarioSistemaRepository usuarioSistemaRepository;
	
	
	private Authentication get() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(Objects.isNull(authentication)) {
			throw new NotFoundException("Problema ao recuperar o usuário logado.");
		}
		return authentication;
	}
	
	public UsuariosSistema getUsuarioLogado() {
		CustomUserDetails userDetails = ((CustomUserDetails)get().getPrincipal());
		if(Objects.isNull(userDetails)) {
			throw new NotFoundException("Usuário logado ausente no contexto.");
		}
		
		Optional<UsuariosSistema> usuarioLogado = usuarioSistemaRepository.findByUsername(userDetails.getUsername());
		if(!usuarioLogado.isPresent()) {
			throw new NotFoundException("Erro ao recuperar o usuário logado.");
		}

		return usuarioLogado.get();
	}
	
}
