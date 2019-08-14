package br.com.crux.cmd;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import br.com.crux.dto.UsuariosSistema;
import br.com.crux.security.JwtManager;
import br.com.crux.to.UsuarioLogadoTO;

@Component
public class AutenticadorLoginCmd {
	
	@Autowired private AuthenticationManager authManager;
	@Autowired private JwtManager jwtManager;

	public UsuarioLogadoTO autenticar(UsuariosSistema user) {

		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user.getUserName(),
				user.getSenha());
		Authentication auth = authManager.authenticate(token);

		SecurityContextHolder.getContext().setAuthentication(auth);

		org.springframework.security.core.userdetails.User userSpring = (org.springframework.security.core.userdetails.User) auth
				.getPrincipal();

		String email = userSpring.getUsername();
		List<String> roles = userSpring.getAuthorities().stream().map(authority -> authority.getAuthority())
				.collect(Collectors.toList());

		String jwt = jwtManager.createToken(email, roles);
		
		//TODO FAZER O BUILDER DEPOIS.. FIZ ISSO SO PRA ADIANTAR
		UsuarioLogadoTO usuarioLogadoTO = new UsuarioLogadoTO();
		usuarioLogadoTO.setToken(jwt);

		return usuarioLogadoTO;
	}

}
