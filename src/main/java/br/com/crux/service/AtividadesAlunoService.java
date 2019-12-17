package br.com.crux.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.crux.cmd.ExcluirAtividadesAlunoCmd;
import br.com.crux.cmd.GetAtividadesAlunoCmd;
import br.com.crux.to.AtividadesAlunoTO;

@RestController
@RequestMapping(value = "atividadesaluno")
public class AtividadesAlunoService {

	@Autowired private GetAtividadesAlunoCmd getCmd;
	@Autowired private ExcluirAtividadesAlunoCmd excluirCmd;

	
	@GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<AtividadesAlunoTO> getAll() {
		return getCmd.getAllFilter(null, null, null);
	}
		
	@GetMapping(path = "/matriculado/atividade/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<AtividadesAlunoTO> getAllAlunosMatriculadosNaAtividade(@PathVariable(name = "id") Long idAtividade) {
		return getCmd.getAllAlunosMatriculadosNaAtividade(idAtividade);
	}
	
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public AtividadesAlunoTO getById(@PathVariable(name = "id") Long id) {
		return getCmd.getTOById(id);
	}
	
	@GetMapping(path = "/aluno/{idAluno}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<AtividadesAlunoTO> getByAluno(@PathVariable(name = "idAluno") Long idAluno) {
		return getCmd.getByAluno(idAluno);
	}
	
	@GetMapping(path = "/atividade/{idAtividade}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<AtividadesAlunoTO> getByAtividade(@PathVariable(name = "idAtividade") Long idAtividade) {
		return getCmd.getByAtividade(idAtividade);
	}
	
	@GetMapping(path = "/aluno/{idAluno}/atividade/{idAtividade}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<AtividadesAlunoTO> getByAlunoEAtividade(@PathVariable(name = "idAluno") Long idAluno, 
			                                            @PathVariable(name = "idAtividade") Long idAtividade) {
		return getCmd.getByAlunoEAtividade(idAluno, idAtividade);
	}

	@GetMapping(path = "/aluno/{idAluno}/atividade/{idAtividade}/data/{data}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<AtividadesAlunoTO> getByAlunoEAtividade(@PathVariable(name = "idAluno") Long idAluno, 
			                                            @PathVariable(name = "idAtividade") Long idAtividade,
			                                            @PathVariable(name = "data") Long data) {
		return getCmd.getByAlunoEAtividadeEPeriodo(idAluno, idAtividade, data);
	}
		
	@DeleteMapping(path = "/{id}")
	public void excluir(@PathVariable(name = "id") Long id) {
		excluirCmd.excluir(id);
	}

}
