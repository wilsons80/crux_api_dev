package br.com.crux.cmd;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.UsuarioUnidadeTOBuilder;
import br.com.crux.dao.GetUsuarioSistemaDao;
import br.com.crux.exception.ParametroNaoInformadoException;
import br.com.crux.to.UsuarioUnidadeTO;

@Component
public class GetUsuariosPorUnidadeCmd {

	@Autowired private GetUsuarioSistemaDao getUsuarioSistemaDao;
	@Autowired private UsuarioUnidadeTOBuilder usuarioUnidadeTOBuilder;
	@Autowired private GetUnidadeLogadaCmd getUnidadeLogadaCmd;

	public List<UsuarioUnidadeTO> getUsuariosPorUnidade() {
		return usuarioUnidadeTOBuilder.buildAll(getUsuarioSistemaDao.getUsuariosPorUnidade(getUnidadeLogadaCmd.get().getId()));
	}

	
	public List<UsuarioUnidadeTO> getUsuariosPorUnidade(Long idUnidade) {
		if (Objects.isNull(idUnidade)) {
			throw new ParametroNaoInformadoException("A unidade não foi informada para buscar os usuários.");
		}
		return usuarioUnidadeTOBuilder.buildAll(getUsuarioSistemaDao.getUsuariosPorUnidade(idUnidade));
	}
}
