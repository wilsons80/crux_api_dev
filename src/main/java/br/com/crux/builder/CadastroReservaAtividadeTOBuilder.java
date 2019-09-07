package br.com.crux.builder;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.entity.CadastroReservaAtividade;
import br.com.crux.to.CadastroReservaAtividadeTO;

@Component
public class CadastroReservaAtividadeTOBuilder {

	@Autowired private AtividadeTOBuilder atividadeBuilder;
	@Autowired private PessoaFisicaTOBuilder pessoaFisicaBuilder;

	
	public CadastroReservaAtividade build(CadastroReservaAtividadeTO p) {
		CadastroReservaAtividade retorno = new CadastroReservaAtividade();

		retorno.setId(p.getId());
		retorno.setDescricaoCadastroReserva(p.getDescricaoCadastroReserva());
		retorno.setDescricaoCancelamentoCadastro(p.getDescricaoCancelamentoCadastro());
		retorno.setDataCadastroReserva(p.getDataCadastroReserva());
		retorno.setDataCancelamentoCadastro(p.getDataCancelamentoCadastro());
		retorno.setDataCadastroAtividade(p.getDataCadastroAtividade());
		retorno.setDtAlteracaoAtividade(p.getDtAlteracaoAtividade());
		
		retorno.setAtividade(atividadeBuilder.build(p.getAtividade()));
		retorno.setPessoasFisica(pessoaFisicaBuilder.build(p.getPessoasFisica()));
		
		retorno.setUsuarioCadastro(p.getUsuarioCadastro());
		retorno.setUsuarioUltimaAlteracao(p.getUsuarioUltimaAlteracao());
		retorno.setUsuarioAlteracao(p.getUsuarioAlteracao());

		return retorno;
	}

	public CadastroReservaAtividadeTO buildTO(CadastroReservaAtividade p) {
		CadastroReservaAtividadeTO retorno = new CadastroReservaAtividadeTO();
		
		retorno.setId(p.getId());
		retorno.setDescricaoCadastroReserva(p.getDescricaoCadastroReserva());
		retorno.setDescricaoCancelamentoCadastro(p.getDescricaoCancelamentoCadastro());
		retorno.setDataCadastroReserva(p.getDataCadastroReserva());
		retorno.setDataCancelamentoCadastro(p.getDataCancelamentoCadastro());
		retorno.setDataCadastroAtividade(p.getDataCadastroAtividade());
		retorno.setDtAlteracaoAtividade(p.getDtAlteracaoAtividade());
		
		retorno.setAtividade(atividadeBuilder.buildTO(p.getAtividade()));
		retorno.setPessoasFisica(pessoaFisicaBuilder.buildTO(p.getPessoasFisica()));
		
		retorno.setUsuarioCadastro(p.getUsuarioCadastro());
		retorno.setUsuarioUltimaAlteracao(p.getUsuarioUltimaAlteracao());
		retorno.setUsuarioAlteracao(p.getUsuarioAlteracao());

		return retorno;
	}

	public List<CadastroReservaAtividadeTO> buildAll(List<CadastroReservaAtividade> dtos) {
		return dtos.stream().map(dto -> buildTO(dto)).collect(Collectors.toList());
	}

}
