package br.com.crux.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import br.com.crux.entity.UsuariosSistema;
import br.com.crux.exception.NotFoundException;
import br.com.crux.repository.AutenticadorRepository;

@Component("accessManager")
public class AccessManager {
	
	@Autowired
	private AutenticadorRepository autenticadorRepository;

	
	public boolean isOwner(Long id) {
		String userName = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Optional<UsuariosSistema> result = autenticadorRepository.findByUserName(userName);
		
		if(!result.isPresent()) throw new NotFoundException("Não existe usuário com userName = " + userName);
		
		UsuariosSistema user = result.get();
		
		return user.getIdUsuario() == id;
	}

}
