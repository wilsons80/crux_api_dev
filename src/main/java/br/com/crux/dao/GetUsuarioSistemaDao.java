package br.com.crux.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.dao.repository.UsuarioSistemaRepository;
import br.com.crux.entity.UsuariosSistema;

@Component
public class GetUsuarioSistemaDao {

	@Autowired private UsuarioSistemaRepository usuarioSistemaRepository;

	
	public Optional<UsuariosSistema>  getUsuarioByUsername(String username) {
		Optional<UsuariosSistema> usuarioSistema = usuarioSistemaRepository.findByUsername(username);
		return usuarioSistema;
	}
	
}
