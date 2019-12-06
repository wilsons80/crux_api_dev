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

import br.com.crux.cmd.AlterarMateriaisAtividadeCmd;
import br.com.crux.cmd.CadastrarMateriaisAtividadeCmd;
import br.com.crux.cmd.ExcluirMateriaisAtividadeCmd;
import br.com.crux.cmd.GetMateriaisAtividadeCmd;
import br.com.crux.to.MateriaisAtividadeTO;

@RestController
@RequestMapping(value = "materiaisatividade")
public class MateriaisAtividadeService {
	
	@Autowired
	private GetMateriaisAtividadeCmd getCmd;
	@Autowired
	private ExcluirMateriaisAtividadeCmd  excluirCmd;
	@Autowired
	private AlterarMateriaisAtividadeCmd alterarCmd;
	@Autowired
	private CadastrarMateriaisAtividadeCmd cadastrarCmd;
	
	
	@GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<MateriaisAtividadeTO> getAll() {
		return getCmd.getAll();
	}
	
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public MateriaisAtividadeTO getById(@PathVariable(name = "id") Long id) {
		return getCmd.getTOById(id);
	}

	@GetMapping(path = "/atividade/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<MateriaisAtividadeTO> getPorAtividade(@PathVariable(name = "id") Long id) {
		return getCmd.getPorAtividade(id);
	}
	
	@PostMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void cadastrar(@RequestBody MateriaisAtividadeTO param) {
		cadastrarCmd.cadastrar(param);
	}
	
	@PutMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void alterar(@RequestBody MateriaisAtividadeTO param) {
		alterarCmd.alterar(param);
	}
	
	@DeleteMapping(path = "/{id}")
	public void excluir(@PathVariable(name = "id") Long id) {
		excluirCmd.excluir(id);
	}

}
