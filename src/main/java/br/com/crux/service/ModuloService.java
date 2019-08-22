package br.com.crux.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.crux.cmd.GetModulosPorUnidadeCmd;
import br.com.crux.to.ModuloTO;

@RestController
@RequestMapping(value = "modulo")
public class ModuloService {
	
	@Autowired private GetModulosPorUnidadeCmd getModulosPorUnidadeCmd; 
	
	@GetMapping(path = "/{id}")
	public List<ModuloTO> getModulosPorUnidade(@PathVariable(name = "id") Long idUnidade) {
		return getModulosPorUnidadeCmd.getModulosPorUnidade(idUnidade);
	}

}
