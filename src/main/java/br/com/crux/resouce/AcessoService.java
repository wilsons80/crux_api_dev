package br.com.crux.resouce;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.crux.cmd.GetAcessoUsuarioCmd;
import br.com.crux.to.AcessoTO;

@RestController
@RequestMapping(value = "acesso")
public class AcessoService {
	
	@Autowired
	private GetAcessoUsuarioCmd getAcessoUsuarioCmd;
	
	@ResponseBody
	@GetMapping(path = "/usuario", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<AcessoTO> getAllAcessos(Principal principal,  @RequestParam("idUnidade") Long idUnidade) {
		return getAcessoUsuarioCmd.getAllAcessoUsuarioPorUnidadeCmd(principal.getName(), idUnidade);
		
	}

}
