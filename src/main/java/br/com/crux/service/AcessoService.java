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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.crux.cmd.AlterarAcessoUsuarioCmd;
import br.com.crux.cmd.CadastrarAcessoUsuarioCmd;
import br.com.crux.cmd.ExcluirAcessoUsuarioCmd;
import br.com.crux.cmd.GetPerfilAcessoCmd;
import br.com.crux.to.CadastroAcessoTO;
import br.com.crux.to.PerfilAcessoTO;
import br.com.crux.to.PerfilAcessoUsuarioTO;

@RestController
@RequestMapping(value = "acesso")
public class AcessoService {
	
	@Autowired
	private ExcluirAcessoUsuarioCmd excluirAcessoUsuarioCmd;
	@Autowired
	private CadastrarAcessoUsuarioCmd cadastrarAcessoUsuarioCmd;
	@Autowired
	private AlterarAcessoUsuarioCmd alterarAcessoUsuarioCmd;
	@Autowired
	private GetPerfilAcessoCmd getPerfilAcessoCmd;

	@PostMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void cadastrar(@RequestBody CadastroAcessoTO acesso) {
		cadastrarAcessoUsuarioCmd.cadastrar(acesso);
	}
	
	@PutMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void alterar(@RequestBody CadastroAcessoTO acesso) {
		alterarAcessoUsuarioCmd.alterar(acesso);
	}
	
	@DeleteMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void excluir(@PathVariable(name = "id") Long idUsuarioGrupo) {
		excluirAcessoUsuarioCmd.excluir(idUsuarioGrupo);
	}
	
	//Usado na tela de cadastro de acesso para um usuário específico
	@GetMapping(path = "/perfil/unidade/{idUnidade}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PerfilAcessoUsuarioTO> getPerfilAcessoDoUsuario(@PathVariable(name = "idUnidade") Long idUnidade, 
			                                                    @RequestParam(name = "usuario", required = false) Long idUsuario, 
			                                                    @RequestParam(name = "modulo", required = false) Long idModulo) {
		return getPerfilAcessoCmd.getPerfilAcessoDoUsuario(idUnidade, idUsuario, idModulo);
	}
	

	//Retorna os acesso do módulo acessado no menu
	@GetMapping(path = "/unidade/{idUnidade}/modulo/{idModulo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PerfilAcessoTO> getPerfilAcesso(@PathVariable(name = "idUnidade") Long idUnidade, 
			                                          @PathVariable(name = "modulo") Long idModulo) {
		return getPerfilAcessoCmd.getPerfilAcesso(idUnidade, idModulo);
	}

}
