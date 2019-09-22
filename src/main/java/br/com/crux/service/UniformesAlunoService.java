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

import br.com.crux.cmd.AlterarUniformesAlunoCmd;
import br.com.crux.cmd.CadastrarUniformesAlunoCmd;
import br.com.crux.cmd.ExcluirUniformesAlunoCmd;
import br.com.crux.cmd.GetUniformesAlunoCmd;
import br.com.crux.to.UniformesAlunoTO;

@RestController
@RequestMapping(value = "uniformesaluno")
public class UniformesAlunoService {
	
	@Autowired
	private GetUniformesAlunoCmd getCmd;
	@Autowired
	private ExcluirUniformesAlunoCmd  excluirCmd;
	@Autowired
	private AlterarUniformesAlunoCmd alterarCmd;
	@Autowired
	private CadastrarUniformesAlunoCmd cadastrarCmd;
	
	
	@GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<UniformesAlunoTO> getAll() {
		return getCmd.getAll();
	}
	
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public UniformesAlunoTO getById(@PathVariable(name = "id") Long id) {
		return getCmd.getById(id);
	}
	
	@PostMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void cadastrar(@RequestBody UniformesAlunoTO param) {
		cadastrarCmd.cadastrar(param);
	}
	
	@PutMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void alterar(@RequestBody UniformesAlunoTO param) {
		alterarCmd.alterar(param);
	}
	
	@DeleteMapping(path = "/{id}")
	public void excluir(@PathVariable(name = "id") Long id) {
		excluirCmd.excluir(id);
	}

}
