package br.com.crux.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.crux.cmd.GetGruposModulosCmd;
import br.com.crux.cmd.GetModulosPorUnidadeCmd;
import br.com.crux.to.GrupoModuloTO;
import br.com.crux.to.ModuloTO;

@RestController
@RequestMapping(value = "modulo")
public class ModuloService {
	
	@Autowired private GetModulosPorUnidadeCmd getModulosPorUnidadeCmd; 
	@Autowired private GetGruposModulosCmd getGruposModulosCmd; 
	
	
	@GetMapping(path = "/unidade/{idUnidade}")
	public List<ModuloTO> getModulosPorUnidade(@PathVariable(name = "idUnidade") Long idUnidade) {
		return getModulosPorUnidadeCmd.getModulosPorUnidade(idUnidade);
	}

	@GetMapping(path = "/{idModulo}/unidade/{idUnidade}")
	public List<GrupoModuloTO> getGrupoModulo(@PathVariable(name = "idUnidade") Long idUnidade, 
			                                  @PathVariable(name = "idModulo") Long idModulo) {
		return getGruposModulosCmd.getGrupoModulo(idUnidade, idModulo);
	}
	
}
