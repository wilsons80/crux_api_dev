package br.com.crux.resouce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.crux.cmd.AutenticadorCmd;
import br.com.crux.to.TokenTo;
import br.com.crux.to.UsuarioLogadoTO;
import br.com.crux.to.UsuarioTO;

@RestController
@RequestMapping(value = "autenticador")
public class AutenticadorService {

	@Autowired
	private AutenticadorCmd autenticadorLoginCmd;

	@GetMapping("/public/teste")
	public ResponseEntity<String> teste() {
		return ResponseEntity.ok("jwt");
	}

	@PostMapping(path = "/public/login", produces = MediaType.APPLICATION_JSON_VALUE)
	public UsuarioLogadoTO login(@RequestBody UsuarioTO user) {
		return autenticadorLoginCmd.autenticar(user);
	}
	
	
	@GetMapping(path = "/refresh-token", produces = MediaType.APPLICATION_JSON_VALUE)
	public TokenTo refreshToken() {
		return autenticadorLoginCmd.refreshToken();
	}

}
