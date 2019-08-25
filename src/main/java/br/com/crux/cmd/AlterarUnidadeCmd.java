package br.com.crux.cmd;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.UnidadeBuilder;
import br.com.crux.dao.repository.UnidadeRepository;
import br.com.crux.entity.Unidade;
import br.com.crux.entity.UsuariosSistema;
import br.com.crux.exception.NotFoundException;
import br.com.crux.rule.ValidarCadastroUnidadeRule;
import br.com.crux.to.UnidadeTO;

@Component
public class AlterarUnidadeCmd {

	@Autowired
	private UnidadeRepository unidadeRepository;
	@Autowired
	private GetUsuarioLogadoCmd getUsuarioLogadoCmd;
	@Autowired
	private ValidarCadastroUnidadeRule validarCadastroUnidadeRule;
	@Autowired
	private UnidadeBuilder cadastroUnidadeBuilder;
	@Autowired
	private GetUnidadeCmd getUnidadeCmd;
	
	
	public void alterar(UnidadeTO to) {
		validarCadastroUnidadeRule.validar(to.getNomeUnidade(), to.getNomeUnidade());
		
		Optional<UnidadeTO> unidadeApagar = getUnidadeCmd.getUnidadeUsuarioLogadoComAcesso(to.getIdUnidade());
		if(!unidadeApagar.isPresent()) {
			throw new NotFoundException("Usuário não tem permissão para alterar essa unidade.");
		}
		
		UsuariosSistema usuarioLogado = getUsuarioLogadoCmd.getUsuarioLogado();
		to.setUsuarioAlteracao(usuarioLogado.getIdUsuario());
		
		Unidade unidade = cadastroUnidadeBuilder.build(to);
		unidadeRepository.save(unidade);
	}
}
