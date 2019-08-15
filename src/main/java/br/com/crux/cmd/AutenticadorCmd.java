package br.com.crux.cmd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import br.com.crux.dto.UsuariosSistema;
import br.com.crux.to.TokenTo;
import br.com.crux.to.UsuarioLogadoTO;

@Component
public class AutenticadorCmd {
	
	@Autowired private AuthenticationManager authManager;
	
	@Autowired private TokenJwtCmd createTokenJwtCmd;

	public UsuarioLogadoTO autenticar(UsuariosSistema user) {

		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user.getUserName(),user.getSenha());
		Authentication auth = authManager.authenticate(token);

		SecurityContextHolder.getContext().setAuthentication(auth);
		User userSpring = (User) auth.getPrincipal();
		String jwt = createTokenJwtCmd.createToken(userSpring.getUsername(), userSpring);
		
		//TODO FAZER O BUILDER DEPOIS.. FIZ ISSO SO PRA ADIANTAR
		UsuarioLogadoTO usuarioLogadoTO = new UsuarioLogadoTO();
		usuarioLogadoTO.setToken(jwt);

		return usuarioLogadoTO;
	}
	
	public TokenTo refreshToken() {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User userSpring = (User) auth.getPrincipal();
		String jwt = createTokenJwtCmd.createToken(userSpring.getUsername(), userSpring);
		
		TokenTo tokenTo = new TokenTo();
		tokenTo.setToken(jwt);

		return tokenTo;
	}	

}
