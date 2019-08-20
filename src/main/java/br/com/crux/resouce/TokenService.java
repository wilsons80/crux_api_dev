package br.com.crux.resouce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.crux.cmd.AutenticadorCmd;
import br.com.crux.to.UsuarioLogadoTO;

@RestController
@RequestMapping(value = "token")
public class TokenService {
	
	@Autowired
	private AutenticadorCmd autenticadorLoginCmd;
	
	@RequestMapping(value = "/refresh-token", method = RequestMethod.GET)
	@ResponseBody
	public UsuarioLogadoTO getUsuarioLogado(Authentication authentication) {
		return autenticadorLoginCmd.refreshToken(authentication);
	}

	
	/*
	@RequestMapping(value = "/username", method = RequestMethod.GET)
	@ResponseBody
	public String currentUserName(Principal principal) {
		return principal.getName();
	}
    */
	
	

}
