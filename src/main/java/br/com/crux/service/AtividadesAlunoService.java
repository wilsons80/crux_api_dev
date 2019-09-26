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

import br.com.crux.cmd.AlterarAtividadesAlunoCmd;
import br.com.crux.cmd.CadastrarAtividadesAlunoCmd;
import br.com.crux.cmd.ExcluirAtividadesAlunoCmd;
import br.com.crux.cmd.GetAtividadesAlunoCmd;
import br.com.crux.to.AtividadesAlunoTO;

@RestController
@RequestMapping(value = "atividadesaluno")
public class AtividadesAlunoService {
	
	@Autowired
	private GetAtividadesAlunoCmd getCmd;
	@Autowired
	private ExcluirAtividadesAlunoCmd  excluirCmd;
	@Autowired
	private AlterarAtividadesAlunoCmd alterarCmd;
	@Autowired
	private CadastrarAtividadesAlunoCmd cadastrarCmd;
	
	
	@GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<AtividadesAlunoTO> getAll() {
		return getCmd.getAll();
	}
	
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public AtividadesAlunoTO getById(@PathVariable(name = "id") Long id) {
		return getCmd.getById(id);
	}
	
	@PostMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void cadastrar(@RequestBody AtividadesAlunoTO param) {
		cadastrarCmd.cadastrar(param);
	}
	
	@PutMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void alterar(@RequestBody AtividadesAlunoTO param) {
		alterarCmd.alterar(param);
	}
	
	@DeleteMapping(path = "/{id}")
	public void excluir(@PathVariable(name = "id") Long id) {
		excluirCmd.excluir(id);
	}

}