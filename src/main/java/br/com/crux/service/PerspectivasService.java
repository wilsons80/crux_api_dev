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

import br.com.crux.cmd.AlterarDepartamentoCmd;
import br.com.crux.cmd.CadastrarDepartamentoCmd;
import br.com.crux.cmd.ExcluirPerspectivaCmd;
import br.com.crux.cmd.GetPerspectivasCmd;
import br.com.crux.to.DepartamentoTO;
import br.com.crux.to.PerspectivaTO;

@RestController
@RequestMapping(value = "perspectiva")
public class PerspectivasService {
	
	@Autowired
	private GetPerspectivasCmd getPerspectivasCmd;
	@Autowired
	private ExcluirPerspectivaCmd  excluirPerspectivaCmd;
	@Autowired
	private AlterarDepartamentoCmd alterarDepartamentoCmd;
	@Autowired
	private CadastrarDepartamentoCmd cadastrarDepartamentoCmd;
	
	
	@GetMapping(path = "/unidade/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PerspectivaTO> getAll(@PathVariable(name = "id") Long idUnidade) {
		return getPerspectivasCmd.getAll(idUnidade);
	}
	
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public PerspectivaTO getDepartamentoById(@PathVariable(name = "id") Long idDepartamento) {
		return getPerspectivasCmd.getById(idDepartamento);
	}
	
	/*
	@PostMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void cadastrar(@RequestBody DepartamentoTO departamento) {
		cadastrarDepartamentoCmd.cadastrar(departamento);
	}
	
	@PutMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void alterar(@RequestBody DepartamentoTO departamento) {
		alterarDepartamentoCmd.alterar(departamento);
	}
	*/
	
	@DeleteMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void excluir(@PathVariable(name = "id") Long id) {
		excluirPerspectivaCmd.excluir(id);
	}
	
	
	
	
	

}
