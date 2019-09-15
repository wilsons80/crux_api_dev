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

import br.com.crux.cmd.AlterarFuncionarioCmd;
import br.com.crux.cmd.CadastrarFuncionarioCmd;
import br.com.crux.cmd.ExcluirFuncionarioCmd;
import br.com.crux.cmd.GetFuncionarioCmd;
import br.com.crux.to.FuncionarioTO;

@RestController
@RequestMapping(value = "funcionario")
public class FuncionarioService {
	
	@Autowired
	private GetFuncionarioCmd getCmd;
	@Autowired
	private ExcluirFuncionarioCmd  excluirCmd;
	@Autowired
	private AlterarFuncionarioCmd alterarCmd;
	@Autowired
	private CadastrarFuncionarioCmd cadastrarCmd;
	
	
	@GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<FuncionarioTO> getAllPorUnidadeLogada() {
		return getCmd.getAllPorUnidadeLogada();
	}
	
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public FuncionarioTO getById(@PathVariable(name = "id") Long id) {
		return getCmd.getById(id);
	}
	
	@PostMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void cadastrar(@RequestBody FuncionarioTO param) {
		cadastrarCmd.cadastrar(param);
	}
	
	@PutMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void alterar(@RequestBody FuncionarioTO param) {
		alterarCmd.alterar(param);
	}
	
	@DeleteMapping(path = "/{id}")
	public void excluir(@PathVariable(name = "id") Long id) {
		excluirCmd.excluir(id);
	}

}