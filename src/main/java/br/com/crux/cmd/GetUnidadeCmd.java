package br.com.crux.cmd;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import br.com.crux.builder.UnidadeTOBuilder;
import br.com.crux.entity.UsuariosSistema;
import br.com.crux.entity.UsuariosUnidade;
import br.com.crux.repository.UsuarioSistemaRepository;
import br.com.crux.to.UnidadeTO;

@Component
public class GetUnidadeCmd {

	@Autowired private GetUsuarioAutenticadoCmd getUsuarioAutenticadoCmd;
	@Autowired private UsuarioSistemaRepository usuarioSistemaRepository;

	@Autowired private UnidadeTOBuilder unidadeTOBuilder;

	public List<UnidadeTO> getUnidadePorUsuario(String username) throws UsernameNotFoundException {
		Optional<UsuariosSistema> usuario = usuarioSistemaRepository.findByUsername(username);
		if(!usuario.isPresent()) throw new UsernameNotFoundException("Não existe usuário com username = " + username);
		
		UsuariosSistema user = getUsuarioAutenticadoCmd.loadUserById(usuario.get().getIdUsuario());
		return user.getUsuariosUnidades().stream().map((UsuariosUnidade unidade) -> {
			return unidadeTOBuilder.build(unidade.getUnidade());
		}).collect(Collectors.toList());
	}

}
