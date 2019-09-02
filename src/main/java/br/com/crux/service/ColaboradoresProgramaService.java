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

import br.com.crux.cmd.AlterarColaboradoresProgramaCmd;
import br.com.crux.cmd.CadastrarColaboradoresProgramaCmd;
import br.com.crux.cmd.ExcluirColaboradoresProgramaCmd;
import br.com.crux.cmd.GetColaboradoresProgramaCmd;
import br.com.crux.to.ColaboradoresProgramaTO;

@RestController
@RequestMapping(value = "colaboradoresprograma")
public class ColaboradoresProgramaService {
	
	@Autowired
	private GetColaboradoresProgramaCmd getCmd;
	@Autowired
	private ExcluirColaboradoresProgramaCmd  excluirCmd;
	@Autowired
	private AlterarColaboradoresProgramaCmd alterarCmd;
	@Autowired
	private CadastrarColaboradoresProgramaCmd cadastrarCmd;
	
	
	@GetMapping(path = "/unidade/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ColaboradoresProgramaTO> getAll(@PathVariable(name = "id") Long idUnidade) {
		return getCmd.getAll(idUnidade);
	}
	
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ColaboradoresProgramaTO getById(@PathVariable(name = "id") Long id) {
		return getCmd.getById(id);
	}
	
	@PostMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void cadastrar(@RequestBody ColaboradoresProgramaTO to) {
		cadastrarCmd.cadastrar(to);
	}
	
	@PutMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void alterar(@RequestBody ColaboradoresProgramaTO to) {
		alterarCmd.alterar(to);
	}
	
	@DeleteMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void excluir(@PathVariable(name = "id") Long id) {
		excluirCmd.excluir(id);
	}
	

}
