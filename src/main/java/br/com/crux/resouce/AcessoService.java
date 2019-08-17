package br.com.crux.resouce;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.crux.builder.AcessoTOBuilder;
import br.com.crux.cmd.GetAllAcessoUsuarioPorUnidadeCmd;
import br.com.crux.dto.AcessoDTO;
import br.com.crux.to.AcessoTO;

@RestController
@RequestMapping(value = "acesso")
public class AcessoService {

	@Autowired
	private GetAllAcessoUsuarioPorUnidadeCmd getAllAcessoUsuarioPorUnidadeCmd;
	
	@Autowired
	private AcessoTOBuilder acessoTOBuilder;

	
	
	@GetMapping(path = "/usuario/{idUsuario}/{idUnidade}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<AcessoTO> getAllAcessos(@PathParam ("idUsuario") Long idUsarname,
			@PathParam("idUnidade") Long idUnidade) {

		
		List<AcessoDTO> dto = getAllAcessoUsuarioPorUnidadeCmd.getAcesso(idUsarname, idUnidade);
		return acessoTOBuilder.buildAll(dto);

	}

}
