package br.com.crux.resouce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.crux.cmd.AutenticadorCmd;
import br.com.crux.to.UsuarioLogadoTO;
import br.com.crux.to.UsuarioTO;

@RestController
@RequestMapping(value = "autenticador")
public class AutenticadorService {

	@Autowired
	private AutenticadorCmd autenticadorLoginCmd;

	@PostMapping(path = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
	public UsuarioLogadoTO login(@RequestBody UsuarioTO user) {
		return autenticadorLoginCmd.autenticar(user);
	}
	
	@PostMapping(path = "/trocar-senha")
	public void trocarSenha(@RequestBody String senha) {
		autenticadorLoginCmd.trocarSenha(senha);
	}

}
