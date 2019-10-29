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

import br.com.crux.cmd.AlterarAvaliacoesAlunosCmd;
import br.com.crux.cmd.CadastrarAvaliacoesAlunosCmd;
import br.com.crux.cmd.ExcluirAvaliacoesAlunosCmd;
import br.com.crux.cmd.GetAvaliacoesAlunosCmd;
import br.com.crux.to.AvaliacoesAlunosTO;

@RestController
@RequestMapping(value = "avaliacaoaluno")
public class AvaliacoesAlunosService {

	@Autowired private GetAvaliacoesAlunosCmd getCmd;
	@Autowired private ExcluirAvaliacoesAlunosCmd excluirCmd;
	@Autowired private AlterarAvaliacoesAlunosCmd alterarCmd;
	@Autowired private CadastrarAvaliacoesAlunosCmd cadastrarCmd;

	@GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<AvaliacoesAlunosTO> getAll() {
		return getCmd.getAll();
	}

	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public AvaliacoesAlunosTO getById(@PathVariable(name = "id") Long id) {
		return getCmd.getById(id);
	}

	@PostMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void cadastrar(@RequestBody AvaliacoesAlunosTO param) {
		cadastrarCmd.cadastrar(param);
	}

	@PutMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void alterar(@RequestBody AvaliacoesAlunosTO param) {
		alterarCmd.alterar(param);
	}
	
	@PutMapping(path = "/atividade/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void alterarAll(@PathVariable(name = "id") Long idAtividade,
			               @RequestBody List<AvaliacoesAlunosTO> param) {
		alterarCmd.alterarAll(param, idAtividade);
	}

	@DeleteMapping(path = "/{id}")
	public void excluir(@PathVariable(name = "id") Long id) {
		excluirCmd.excluir(id);
	}

}
