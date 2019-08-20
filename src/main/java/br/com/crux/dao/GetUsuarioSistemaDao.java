package br.com.crux.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.dao.repository.UsuarioSistemaRepository;
import br.com.crux.entity.UsuariosSistema;
import br.com.crux.rule.UsuarioSistemaNaoEncontradoRule;

@Component
public class GetUsuarioSistemaDao {

	@Autowired private UsuarioSistemaRepository usuarioSistemaRepository;
	@Autowired private UsuarioSistemaNaoEncontradoRule usuarioSistemaNaoEncontradoRule;
	
	public UsuariosSistema getUsuarioByUsername(String username) {
		Optional<UsuariosSistema> usuarioSistema = usuarioSistemaRepository.findByUsername(username);
		
		usuarioSistemaNaoEncontradoRule.verificar(usuarioSistema);
		
		return usuarioSistema.get();
	}
	
}
