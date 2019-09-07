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

import br.com.crux.cmd.AlterarAtividadeCmd;
import br.com.crux.cmd.CadastrarAtividadeCmd;
import br.com.crux.cmd.ExcluirAtividadeCmd;
import br.com.crux.cmd.GetAtividadeCmd;
import br.com.crux.to.AtividadeTO;

@RestController
@RequestMapping(value = "atividade")
public class AtividadeService {
	
	@Autowired
	private GetAtividadeCmd getCmd;
	@Autowired
	private ExcluirAtividadeCmd  excluirCmd;
	@Autowired
	private AlterarAtividadeCmd alterarCmd;
	@Autowired
	private CadastrarAtividadeCmd cadastrarCmd;
	
	
	@GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<AtividadeTO> getAll() {
		return getCmd.getAll();
	}
	
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public AtividadeTO getById(@PathVariable(name = "id") Long id) {
		return getCmd.getById(id);
	}
	
	@PostMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void cadastrar(@RequestBody AtividadeTO param) {
		cadastrarCmd.cadastrar(param);
	}
	
	@PutMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void alterar(@RequestBody AtividadeTO param) {
		alterarCmd.alterar(param);
	}
	
	@DeleteMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void excluir(@PathVariable(name = "id") Long id) {
		excluirCmd.excluir(id);
	}
	
	
	
	
	

}
