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

import br.com.crux.cmd.AlterarProdutosAtividadeCmd;
import br.com.crux.cmd.CadastrarProdutosAtividadeCmd;
import br.com.crux.cmd.ExcluirProdutosAtividadeCmd;
import br.com.crux.cmd.GetProdutosAtividadeCmd;
import br.com.crux.to.ProdutosAtividadeTO;

@RestController
@RequestMapping(value = "produtosatividade")
public class ProdutosAtividadeService {
	
	@Autowired
	private GetProdutosAtividadeCmd getCmd;
	@Autowired
	private ExcluirProdutosAtividadeCmd  excluirCmd;
	@Autowired
	private AlterarProdutosAtividadeCmd alterarCmd;
	@Autowired
	private CadastrarProdutosAtividadeCmd cadastrarCmd;
	
	
	@GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ProdutosAtividadeTO> getAll() {
		return getCmd.getAll();
	}
	
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ProdutosAtividadeTO getById(@PathVariable(name = "id") Long id) {
		return getCmd.getTOById(id);
	}

	@GetMapping(path = "/atividade/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ProdutosAtividadeTO> getPorAtividade(@PathVariable(name = "id") Long id) {
		return getCmd.getPorAtividade(id);
	}
	
	@PostMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void cadastrar(@RequestBody ProdutosAtividadeTO param) {
		cadastrarCmd.cadastrar(param);
	}
	
	@PutMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void alterar(@RequestBody ProdutosAtividadeTO param) {
		alterarCmd.alterar(param);
	}
	
	@DeleteMapping(path = "/{id}")
	public void excluir(@PathVariable(name = "id") Long id) {
		excluirCmd.excluir(id);
	}

}
