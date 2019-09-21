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

import br.com.crux.cmd.AlterarVulnerabilidadesFamiliarCmd;
import br.com.crux.cmd.CadastrarVulnerabilidadesFamiliarCmd;
import br.com.crux.cmd.ExcluirVulnerabilidadesFamiliarCmd;
import br.com.crux.cmd.GetVulnerabilidadesFamiliarCmd;
import br.com.crux.to.VulnerabilidadesFamiliarTO;

@RestController
@RequestMapping(value = "vulnerabilidadesfamiliar")
public class VulnerabilidadesFamiliarService {
	
	@Autowired
	private GetVulnerabilidadesFamiliarCmd getCmd;
	@Autowired
	private ExcluirVulnerabilidadesFamiliarCmd  excluirCmd;
	@Autowired
	private AlterarVulnerabilidadesFamiliarCmd alterarCmd;
	@Autowired
	private CadastrarVulnerabilidadesFamiliarCmd cadastrarCmd;
	
	
	@GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<VulnerabilidadesFamiliarTO> getAll() {
		return getCmd.getAll();
	}
	
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public VulnerabilidadesFamiliarTO getById(@PathVariable(name = "id") Long id) {
		return getCmd.getById(id);
	}
	
	@PostMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void cadastrar(@RequestBody VulnerabilidadesFamiliarTO param) {
		cadastrarCmd.cadastrar(param);
	}
	
	@PutMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void alterar(@RequestBody VulnerabilidadesFamiliarTO param) {
		alterarCmd.alterar(param);
	}
	
	@DeleteMapping(path = "/{id}")
	public void excluir(@PathVariable(name = "id") Long id) {
		excluirCmd.excluir(id);
	}

}
