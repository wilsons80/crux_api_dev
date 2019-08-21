package br.com.crux.cmd;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.dao.GetUsuarioSistemaDao;
import br.com.crux.entity.UsuariosSistema;
import br.com.crux.rule.UsuarioSistemaNaoEncontradoRule;

@Component
public class GetUsuarioSistemaCmd {
	
	@Autowired private GetUsuarioSistemaDao getUsuarioSistemaDao;
	@Autowired private UsuarioSistemaNaoEncontradoRule usuarioSistemaNaoEncontradoRule;
	
	public UsuariosSistema get(String username) {
		Optional<UsuariosSistema> usuarioSistema = getUsuarioSistemaDao.getUsuarioByUsername(username);
		usuarioSistemaNaoEncontradoRule.verificar(usuarioSistema);
		return usuarioSistema.get();
	}

}
