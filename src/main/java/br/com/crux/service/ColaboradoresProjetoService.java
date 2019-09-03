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
import br.com.crux.cmd.CadastrarColaboradoresProjetoCmd;
import br.com.crux.cmd.ExcluirColaboradoresProjetoCmd;
import br.com.crux.cmd.GetColaboradoresProjetoCmd;
import br.com.crux.to.ColaboradoresProjetoTO;

@RestController
@RequestMapping(value = "colaboradoresprojeto")
public class ColaboradoresProjetoService {
	
	@Autowired
	private GetColaboradoresProjetoCmd getCmd;
	@Autowired
	private ExcluirColaboradoresProjetoCmd  excluirCmd;
	@Autowired
	private AlterarColaboradoresProgramaCmd alterarCmd;
	@Autowired
	private CadastrarColaboradoresProjetoCmd cadastrarCmd;
	
	
	@GetMapping(path = "/unidade/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ColaboradoresProjetoTO> getAll(@PathVariable(name = "id") Long idUnidade) {
		return getCmd.getAll(idUnidade);
	}
	
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ColaboradoresProjetoTO getById(@PathVariable(name = "id") Long id) {
		return getCmd.getById(id);
	}
	
	@PostMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void cadastrar(@RequestBody ColaboradoresProjetoTO to) {
		cadastrarCmd.cadastrar(to);
	}
	
	@PutMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void alterar(@RequestBody ColaboradoresProjetoTO to) {
		alterarCmd.alterar(to);
	}
	
	@DeleteMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void excluir(@PathVariable(name = "id") Long id) {
		excluirCmd.excluir(id);
	}
	

}
