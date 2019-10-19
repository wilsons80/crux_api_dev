package br.com.crux.cmd;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.dao.repository.UsuariosUnidadeRepository;
import br.com.crux.entity.UsuariosSistema;
import br.com.crux.entity.UsuariosUnidade;

@Component
public class GetUsuarioUnidadeCmd {

	@Autowired private UsuariosUnidadeRepository usuariosUnidadeRepository;
	@Autowired private GetUsuarioSistemaCmd getUsuarioSistemaCmd;

	public List<UsuariosUnidade> getListaUnidadesUsuarioTemAcesso(Long idUsuario) {

		UsuariosSistema usuario = getUsuarioSistemaCmd.getById(idUsuario);

		return usuariosUnidadeRepository.findByUsuarioSistema(usuario).orElse(Collections.emptyList());

	}

}
