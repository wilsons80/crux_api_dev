package br.com.crux.resouce;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.crux.cmd.GetUnidadeCmd;
import br.com.crux.to.UnidadeTO;

@RestController
@RequestMapping(value = "unidade")
public class UnidadeService {

	@Autowired
	private GetUnidadeCmd getUnidadeCmd;

	@ResponseBody
	@GetMapping(path = "/usuario", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<UnidadeTO> getAllAcessos(Principal principal) {

		return getUnidadeCmd.getUnidadePorUsuario(principal.getName());
	}
	
}
