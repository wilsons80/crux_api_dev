package br.com.crux.resouce;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.crux.dto.UsuariosSistema;
import br.com.crux.security.JwtManager;

@RestController
@RequestMapping(value = "autenticador")
public class AutenticadorService {
	
	@Autowired private AuthenticationManager authManager;
	@Autowired private JwtManager jwtManager;
	
	@GetMapping("/teste")
	public ResponseEntity<String> teste() {
		return ResponseEntity.ok("jwt");
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody UsuariosSistema user) {
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user.getUserName(), user.getSenha());
		Authentication auth = authManager.authenticate(token);
		
		SecurityContextHolder.getContext().setAuthentication(auth);
		
		org.springframework.security.core.userdetails.User userSpring =
				(org.springframework.security.core.userdetails.User) auth.getPrincipal();
		
		String email = userSpring.getUsername();
		List<String> roles = userSpring.getAuthorities()
										.stream()
										.map(authority -> authority.getAuthority())
										.collect(Collectors.toList());
		
		String jwt = jwtManager.createToken(email, roles);
		
		return ResponseEntity.ok(jwt);
	}

}
