package br.com.crux.cmd;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import br.com.crux.builder.UnidadeTOBuilder;
import br.com.crux.dao.repository.UsuarioSistemaRepository;
import br.com.crux.entity.UsuariosSistema;
import br.com.crux.entity.UsuariosUnidade;
import br.com.crux.exception.NotFoundException;
import br.com.crux.to.AcessoUnidadeTO;

@Component
public class GetUnidadeCmd {

	@Autowired private GetUsuarioAutenticadoCmd getUsuarioAutenticadoCmd;
	@Autowired private UsuarioSistemaRepository usuarioSistemaRepository;

	@Autowired private UnidadeTOBuilder unidadeTOBuilder;

	public List<AcessoUnidadeTO> getUnidadePorUsuario() throws UsernameNotFoundException {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(Objects.isNull(authentication)) {
			throw new NotFoundException("Problema ao recuperar o usuário logado.");
		}

		String username = authentication.getName();
		Optional<UsuariosSistema> usuario = usuarioSistemaRepository.findByUsername(username);
		if(!usuario.isPresent()) throw new UsernameNotFoundException("Não existe usuário com username = " + username);
		
		UsuariosSistema user = getUsuarioAutenticadoCmd.loadUserById(usuario.get().getIdUsuario());
		return user.getUsuariosUnidades().stream().map((UsuariosUnidade unidade) -> {
			return unidadeTOBuilder.build(unidade.getUnidade());
		}).collect(Collectors.toList());
	}

}
