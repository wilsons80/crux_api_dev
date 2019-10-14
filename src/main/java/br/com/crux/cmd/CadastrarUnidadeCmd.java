package br.com.crux.cmd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.UnidadeTOBuilder;
import br.com.crux.dao.repository.UnidadeRepository;
import br.com.crux.entity.Unidade;
import br.com.crux.rule.ValidarCadastroUnidadeRule;
import br.com.crux.to.UnidadeTO;
import br.com.crux.to.UsuarioLogadoTO;

@Component
public class CadastrarUnidadeCmd {

	@Autowired private UnidadeRepository unidadeRepository;
	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;
	@Autowired private ValidarCadastroUnidadeRule validarCadastroUnidadeRule;
	@Autowired private UnidadeTOBuilder unidadeTOBuilder;

	public UnidadeTO cadastrar(UnidadeTO to) {
		validarCadastroUnidadeRule.validar(to.getNomeUnidade(), to.getNomeUnidade());

		UsuarioLogadoTO usuarioLogado = getUsuarioLogadoCmd.getUsuarioLogado();
		to.setUsuarioAlteracao(usuarioLogado.getIdUsuario());
		Unidade unidade = unidadeTOBuilder.build(to);

		Unidade retorno = unidadeRepository.save(unidade);
		
		return unidadeTOBuilder.buildTO(retorno);
	}
}
