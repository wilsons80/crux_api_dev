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

import br.com.crux.cmd.AlterarGrupoModuloCmd;
import br.com.crux.cmd.CadastrarGrupoModuloCmd;
import br.com.crux.cmd.ExcluirIndicadoresCmd;
import br.com.crux.cmd.GetGruposModulosCmd;
import br.com.crux.to.GrupoModuloTO;

@RestController
@RequestMapping(value = "grupomodulo")
public class GrupoModuloService {

	@Autowired
	private GetGruposModulosCmd getCmd;
	@Autowired
	private ExcluirIndicadoresCmd  excluirCmd;
	@Autowired
	private AlterarGrupoModuloCmd alterarCmd;
	@Autowired
	private CadastrarGrupoModuloCmd cadastrarCmd;
	
	
	@GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<GrupoModuloTO> getAll() {
		return getCmd.getAllUnidadeLogada();
	}
	
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public GrupoModuloTO getById(@PathVariable(name = "id") Long idDepartamento) {
		return getCmd.getTOById(idDepartamento);
	}
	
	@PostMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void cadastrar(@RequestBody GrupoModuloTO to) {
		cadastrarCmd.cadastrar(to);
	}
	
	@PutMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void alterar(@RequestBody GrupoModuloTO to) {
		alterarCmd.alterar(to);
	}
	
	@DeleteMapping(path = "/{id}")
	public void excluir(@PathVariable(name = "id") Long id) {
		excluirCmd.excluir(id);
	}

}
