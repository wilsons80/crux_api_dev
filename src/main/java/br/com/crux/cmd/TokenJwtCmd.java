package br.com.crux.cmd;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import br.com.crux.security.JwtManager;

@Component
public class TokenJwtCmd {
	
	@Autowired private JwtManager jwtManager;
	
	public String createToken( String username, User userSpring ) {
		String email = username;
		List<String> roles = userSpring.getAuthorities().stream()
				                                        .map(authority -> authority.getAuthority())
				                                        .collect(Collectors.toList());

		        
		String jwt = jwtManager.createToken(email, roles);
		
		return jwt;
	}
	
	public String refreshToken(String token) {
		return token;
	}

}
