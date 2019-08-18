package br.com.crux.cmd;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import br.com.crux.builder.UnidadeTOBuilder;
import br.com.crux.entity.UsuariosSistema;
import br.com.crux.entity.UsuariosUnidade;
import br.com.crux.to.UnidadeTO;

@Component
public class GetUnidadeCmd {

	@Autowired private GetUsuarioAutenticadoCmd getUsuarioAutenticadoCmd;
	@Autowired private UnidadeTOBuilder unidadeTOBuilder;

	public List<UnidadeTO> getUnidadePorIdUsuario(Long id) throws UsernameNotFoundException {
		UsuariosSistema user = getUsuarioAutenticadoCmd.loadUserById(id);
		
		return user.getUsuariosUnidades().stream().map((UsuariosUnidade unidade) -> {
			return unidadeTOBuilder.build(unidade.getUnidade());
		}).collect(Collectors.toList());
		
	}

}
