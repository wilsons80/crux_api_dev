package br.com.crux.cmd;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import br.com.crux.builder.UnidadeTOBuilder;
import br.com.crux.dao.GetUsuarioSistemaDao;
import br.com.crux.entity.Unidade;
import br.com.crux.entity.UsuariosSistema;
import br.com.crux.exception.NotFoundException;
import br.com.crux.repository.UnidadeRepository;
import br.com.crux.to.UnidadeTO;
import br.com.crux.to.UsuarioLogadoTO;
import br.com.crux.to.UsuarioTO;

@Component
public class AutenticadorCmd {
	
	@Autowired private AuthenticationManager authManager;
	@Autowired private TokenJwtCmd createTokenJwtCmd;
	@Autowired private UnidadeRepository unidadeRepository;
	@Autowired private UnidadeTOBuilder unidadeTOBuilder;
	@Autowired private TrocarSenhaCmd trocarSenhaCmd;
	@Autowired private GetUsuarioSistemaDao usuarioSistemaDao;
	
	
	public UsuarioLogadoTO autenticar(UsuarioTO user) {

		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user.getUserName(),user.getSenha());
		Authentication auth = authManager.authenticate(token);

		SecurityContextHolder.getContext().setAuthentication(auth);
		User userSpring = (User) auth.getPrincipal();
		UsuarioLogadoTO usuarioLogadoTO = getUsuarioLogado(userSpring);

		return usuarioLogadoTO;
	}

	
	public UsuarioLogadoTO refreshToken(Authentication authentication) {
		
		if(Objects.isNull(authentication)) {
			throw new NotFoundException("Problema ao recuperar o usuário logado.");
		}
		
		String username = (String) authentication.getPrincipal();
		UsuariosSistema usuarioByUsername = usuarioSistemaDao.getUsuarioByUsername(username);
		
		User userSpring = new User(username, usuarioByUsername.getDsSenha(), authentication.getAuthorities());
		UsuarioLogadoTO usuarioLogadoTO = getUsuarioLogado(userSpring);

		return usuarioLogadoTO;
	}
	
	
	public void trocarSenha(String username, String senha) {
		trocarSenhaCmd.trocarSenha(username, senha);
	}
	
	

	private UsuarioLogadoTO getUsuarioLogado(User userSpring) {
		String jwt = createTokenJwtCmd.createToken(userSpring.getUsername(), userSpring);
		
		UsuarioLogadoTO usuarioLogadoTO = new UsuarioLogadoTO();
		usuarioLogadoTO.setToken(jwt);
		usuarioLogadoTO.setUsername(userSpring.getUsername());
		
		List<UnidadeTO> unidades = new ArrayList<>();
		userSpring.getAuthorities().stream().forEach( autho -> {
			Optional<Unidade> unidade = unidadeRepository.findByCdUnidade(autho.getAuthority().replace("ROLE_", ""));
			
			if(unidade.isPresent()) {
				unidades.add(unidadeTOBuilder.build(unidade.get()));
			}
		});
		
		usuarioLogadoTO.setUnidades(unidades);
		return usuarioLogadoTO;
	}

}
