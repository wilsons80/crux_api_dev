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
		Optional<UsuariosSistema> usuarioLogado = usuarioSistemaRepository.findByUsername(get().getName());
		if(!usuarioLogado.isPresent()) {
			throw new NotFoundException("Erro ao recuperar o usuário logado.");
		}

		return usuarioLogado.get();
	}
	
}
