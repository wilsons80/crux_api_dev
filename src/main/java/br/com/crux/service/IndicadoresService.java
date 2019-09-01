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

import br.com.crux.cmd.AlterarIndicadoresCmd;
import br.com.crux.cmd.CadastrarIndicadoresCmd;
import br.com.crux.cmd.ExcluirIndicadoresCmd;
import br.com.crux.cmd.GetIndicadoresCmd;
import br.com.crux.to.IndicadoresTO;

@RestController
@RequestMapping(value = "indicadores")
public class IndicadoresService {
	
	@Autowired
	private GetIndicadoresCmd getIndicadoresCmd;
	@Autowired
	private ExcluirIndicadoresCmd  excluirIndicadoresCmd;
	@Autowired
	private AlterarIndicadoresCmd alterarIndicadoresCmd;
	@Autowired
	private CadastrarIndicadoresCmd cadastrarIndicadoresCmd;
	
	
	@GetMapping(path = "/unidade/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<IndicadoresTO> getAll(@PathVariable(name = "id") Long idUnidade) {
		return getIndicadoresCmd.getAll(idUnidade);
	}
	
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public IndicadoresTO getDepartamentoById(@PathVariable(name = "id") Long idDepartamento) {
		return getIndicadoresCmd.getById(idDepartamento);
	}
	
	@PostMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void cadastrar(@RequestBody IndicadoresTO to) {
		cadastrarIndicadoresCmd.cadastrar(to);
	}
	
	@PutMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void alterar(@RequestBody IndicadoresTO to) {
		alterarIndicadoresCmd.alterar(to);
	}
	
	@DeleteMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void excluir(@PathVariable(name = "id") Long id) {
		excluirIndicadoresCmd.excluir(id);
	}
	

}
