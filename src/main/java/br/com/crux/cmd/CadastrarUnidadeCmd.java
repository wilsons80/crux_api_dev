package br.com.crux.cmd;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.InstituicaoTOBuilder;
import br.com.crux.builder.UnidadeTOBuilder;
import br.com.crux.dao.repository.UnidadeRepository;
import br.com.crux.entity.Unidade;
import br.com.crux.rule.ValidarCadastroUnidadeRule;
import br.com.crux.to.UnidadeTO;

@Component
public class CadastrarUnidadeCmd {

	@Autowired private UnidadeRepository unidadeRepository;
	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;
	@Autowired private ValidarCadastroUnidadeRule validarCadastroUnidadeRule;
	@Autowired private UnidadeTOBuilder unidadeTOBuilder;
	
	@Autowired private CadastrarInstituicaoCmd cadastrarInstituicaoCmd;
	@Autowired private InstituicaoTOBuilder instituicaoTOBuilder;

	public UnidadeTO cadastrar(UnidadeTO to) {
		validarCadastroUnidadeRule.validar(to.getNomeUnidade(), to.getNomeUnidade());

		to.setUsuarioAlteracao(getUsuarioLogadoCmd.getUsuarioLogado().getIdUsuario());
		Unidade unidade = unidadeTOBuilder.build(to);

		if(Objects.nonNull(to.getInstituicao())) {
			unidade.setInstituicao( instituicaoTOBuilder.build(cadastrarInstituicaoCmd.cadastrar(to.getInstituicao())));
		}
		
		Unidade retorno = unidadeRepository.save(unidade);
		
		return unidadeTOBuilder.buildTO(retorno);
	}
}
