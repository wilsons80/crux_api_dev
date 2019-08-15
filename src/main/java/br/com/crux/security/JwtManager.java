package br.com.crux.security;

import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.crux.constantes.SecurityContantes;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtManager {

	public String createToken(String email, List<String> roles) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MINUTE, SecurityContantes.JWT_EXP_MINUTOS);
		
		String jwt = Jwts.builder()
						 .setSubject(email)
						 .setExpiration(calendar.getTime())
						 .claim(SecurityContantes.JWT_ROLE_KEY, roles)
						 .signWith(SignatureAlgorithm.HS512, SecurityContantes.API_KEY.getBytes())
						 .compact();
		
		return jwt;
	}
	
	public Claims parseToken(String jwt) throws JwtException {
		Claims claims = Jwts.parser()
							.setSigningKey(SecurityContantes.API_KEY.getBytes())
							.parseClaimsJws(jwt)
							.getBody();
		
		
		return claims;
	}
	
}
