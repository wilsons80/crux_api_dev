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

import br.com.crux.cmd.AlterarFrequenciasAlunosCmd;
import br.com.crux.cmd.CadastrarFrequenciasAlunosCmd;
import br.com.crux.cmd.ExcluirFrequenciasAlunosCmd;
import br.com.crux.cmd.GetFrequenciasAlunosCmd;
import br.com.crux.to.FrequenciasAlunosTO;

@RestController
@RequestMapping(value = "frequenciaaluno")
public class FrequenciasAlunosService {

	@Autowired private GetFrequenciasAlunosCmd getCmd;
	@Autowired private ExcluirFrequenciasAlunosCmd excluirCmd;
	@Autowired private AlterarFrequenciasAlunosCmd alterarCmd;
	@Autowired private CadastrarFrequenciasAlunosCmd cadastrarCmd;

	@GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<FrequenciasAlunosTO> getAll() {
		return getCmd.getAll();
	}

	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public FrequenciasAlunosTO getById(@PathVariable(name = "id") Long id) {
		return getCmd.getTOById(id);
	}
	
	@GetMapping(path = "/atividade/{idAtividade}/aluno/{idAluno}", produces = MediaType.APPLICATION_JSON_VALUE)
	public FrequenciasAlunosTO getByAluno(@PathVariable(name = "idAluno") Long idAluno, @PathVariable(name = "idAtividade") Long idAtividade) {
		return getCmd.getPorAlunoAtividadeUnidadeLogada(idAluno,idAtividade);
	}

	@PostMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void cadastrar(@RequestBody FrequenciasAlunosTO param) {
		cadastrarCmd.cadastrar(param);
	}

	@PutMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void alterar(@RequestBody FrequenciasAlunosTO param) {
		alterarCmd.alterar(param);
	}

	@DeleteMapping(path = "/{id}")
	public void excluir(@PathVariable(name = "id") Long id) {
		excluirCmd.excluir(id);
	}

}
