package br.com.crux.cmd;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import br.com.crux.to.LoginTO;
import br.com.crux.to.TrocaSenhaTO;
import br.com.crux.to.UsuarioLogadoHolder;
import br.com.crux.to.UsuarioLogadoTO;

@Component
public class AutenticadorCmd {
	
	@Autowired private AuthenticationManager authManager;
	@Autowired private TrocarSenhaCmd trocarSenhaCmd;
	@Autowired private SaveUsuarioLogadoCmd saveUsuarioLogadoCmd;
	@Autowired private UsuarioLogadoHolder usuarioLogadoHolder;
	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;    
	@Autowired private TokenJwtCmd createTokenJwtCmd;
	
	
	public UsuarioLogadoTO autenticar(LoginTO user) {
		UsernamePasswordAuthenticationToken userAuth = new UsernamePasswordAuthenticationToken(user.getUserName(),user.getSenha());
		Authentication auth = authManager.authenticate(userAuth);
		SecurityContextHolder.getContext().setAuthentication(auth);

		saveUsuarioLogadoCmd.save(auth);
		UsuarioLogadoTO usuarioLogadoTO = usuarioLogadoHolder.getUsuarioLogadoTO();
		
		System.out.println("Data:" + new Date());
		System.out.println("autenticar: " + usuarioLogadoTO);
		return usuarioLogadoTO;
	}


	public UsuarioLogadoTO refreshToken() {
		Authentication auth = getUsuarioLogadoCmd.get();
		String tokenJwt = createTokenJwtCmd.createToken(auth.getName(), auth.getAuthorities());
		saveUsuarioLogadoCmd.save(auth);
		
		UsuarioLogadoTO usuarioLogadoTO = usuarioLogadoHolder.getUsuarioLogadoTO();
		usuarioLogadoTO.setToken(tokenJwt);

		System.out.println("Data:" + new Date());
		System.out.println("refreshToken: " + usuarioLogadoTO);
		return usuarioLogadoTO;
	}
	
	
	public void trocarSenha(TrocaSenhaTO trocaSenhaTO) {
		trocarSenhaCmd.trocarSenha(trocaSenhaTO);
	}

}
