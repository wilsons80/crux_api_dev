package br.com.crux.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.crux.cmd.GetUnidadeCmd;
import br.com.crux.to.AcessoUnidadeTO;
import br.com.crux.to.UnidadeTO;

@RestController
@RequestMapping(value = "unidade")
public class UnidadeService {

	@Autowired
	private GetUnidadeCmd getUnidadeCmd;

	@GetMapping(path = "/usuario", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<AcessoUnidadeTO> getAllAcessos() {
		return getUnidadeCmd.getUnidadePorUsuario();
	}
	
	@PostMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void cadastrar(@RequestBody UnidadeTO unidade) {
		
	}
	
	@PutMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void alterar(@RequestBody UnidadeTO unidade) {
		
	}
	
	@DeleteMapping(path = "")
	public void alterar(@PathVariable(name = "unidade") Long unidade) {
		
	}
	
	@GetMapping(path = "/{idUnidade}", produces = MediaType.APPLICATION_JSON_VALUE)
	public UnidadeTO getUnidade(@PathVariable(name = "idUnidade") Long unidade) {
		return null;
	}

	@GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<UnidadeTO> getAllUnidade() {
		return null;
	}
	
}
