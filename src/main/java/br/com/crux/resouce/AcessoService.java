package br.com.crux.resouce;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.crux.builder.AcessoTOBuilder;
import br.com.crux.cmd.GetAcessoUsuarioCmd;
import br.com.crux.cmd.GetAllAcessoUsuarioPorUnidadeCmd;
import br.com.crux.dto.AcessoDTO;
import br.com.crux.to.AcessoTO;

@RestController
@RequestMapping(value = "acesso")
public class AcessoService {
	
	@Autowired
	private GetAcessoUsuarioCmd getAcessoUsuarioCmd;
	
	@GetMapping(path = "/usuario/{idUsuario}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<AcessoTO> getAllAcessos(@PathVariable ("idUsuario") Long idUsarname,  @RequestParam("idUnidade") Long idUnidade) {
		return getAcessoUsuarioCmd.getAllAcessoUsuarioPorUnidadeCmd(idUsarname, idUnidade);
		
	}

}
