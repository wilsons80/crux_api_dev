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

import br.com.crux.cmd.AlterarResponsaveisAlunoCmd;
import br.com.crux.cmd.CadastrarResponsaveisAlunoCmd;
import br.com.crux.cmd.ExcluirResponsaveisAlunoCmd;
import br.com.crux.cmd.GetResponsaveisAlunoCmd;
import br.com.crux.to.ResponsaveisAlunoTO;

@RestController
@RequestMapping(value = "responsaveisaluno")
public class ResponsaveisAlunoService {
	
	@Autowired
	private GetResponsaveisAlunoCmd getCmd;
	@Autowired
	private ExcluirResponsaveisAlunoCmd  excluirCmd;
	@Autowired
	private AlterarResponsaveisAlunoCmd alterarCmd;
	@Autowired
	private CadastrarResponsaveisAlunoCmd cadastrarCmd;
	
	
	@GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ResponsaveisAlunoTO> getAll() {
		return getCmd.getAll();
	}
	
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponsaveisAlunoTO getById(@PathVariable(name = "id") Long id) {
		return getCmd.getById(id);
	}
	
	@PostMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void cadastrar(@RequestBody ResponsaveisAlunoTO param) {
		cadastrarCmd.cadastrar(param);
	}
	
	@PutMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void alterar(@RequestBody ResponsaveisAlunoTO param) {
		alterarCmd.alterar(param);
	}
	
	@DeleteMapping(path = "/{id}")
	public void excluir(@PathVariable(name = "id") Long id) {
		excluirCmd.excluir(id);
	}

}
