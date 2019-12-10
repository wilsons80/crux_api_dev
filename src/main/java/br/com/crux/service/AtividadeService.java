package br.com.crux.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.crux.cmd.GetAtividadeCmd;
import br.com.crux.to.AtividadesTO;

@RestController
@RequestMapping(value = "atividade")
public class AtividadeService {

	@Autowired private GetAtividadeCmd getCmd;

	@GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<AtividadesTO> getAll() {
		return getCmd.getAllUnidadeLogada();
	}
	
	@GetMapping(path = "/vigente-e-passadas", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<AtividadesTO> getAllVigentesAndPassadas() {
		return getCmd.getAllVigentesAndPassadas();	
	}

	@GetMapping(path = "/vigente-e-futuras", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<AtividadesTO> getAllVigentesAndFuturas() {
		return getCmd.getAllVigentesAndFuturas();	
	}
	
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public AtividadesTO getById(@PathVariable(name = "id") Long id) {
		return getCmd.getTOById(id);
	}


}
