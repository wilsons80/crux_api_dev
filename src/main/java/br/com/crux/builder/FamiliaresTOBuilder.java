package br.com.crux.builder;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.entity.Familiares;
import br.com.crux.to.FamiliaresTO;

@Component
public class FamiliaresTOBuilder {

	@Autowired private  AlunoTOBuilder alunoBuilder;
	@Autowired private  PessoaFisicaTOBuilder pessoaFisicaBuilder;

	public Familiares build(FamiliaresTO p) {
		Familiares retorno = new Familiares();

		retorno.setId(p.getId());
		retorno.setDescGrauParentesco(p.getDescGrauParentesco());
		retorno.setSituacaoParentesco(p.getSituacaoParentesco());
		retorno.setDescOutrasInformacoes(p.getDescOutrasInformacoes());
		retorno.setDescDesligamento(p.getDescDesligamento());
		retorno.setPessoasFisica(pessoaFisicaBuilder.build(p.getPessoasFisica()));
		retorno.setAluno(alunoBuilder.build(p.getAluno()));
		retorno.setUsuarioAlteracao(p.getUsuariosSistema());
		retorno.setDataCadastro(p.getDataCadastro());
		retorno.setDataDesligamento(p.getDataDesligamento());
		
		return retorno;
	}

	public FamiliaresTO buildTO(Familiares p) {
		FamiliaresTO retorno = new FamiliaresTO();
		
		retorno.setId(p.getId());
		retorno.setDescGrauParentesco(p.getDescGrauParentesco());
		retorno.setSituacaoParentesco(p.getSituacaoParentesco());
		retorno.setDescOutrasInformacoes(p.getDescOutrasInformacoes());
		retorno.setDescDesligamento(p.getDescDesligamento());
		retorno.setPessoasFisica(pessoaFisicaBuilder.buildTO(p.getPessoasFisica()));
		retorno.setAluno(alunoBuilder.buildTO(p.getAluno()));
		retorno.setUsuariosSistema(p.getUsuarioAlteracao());
		retorno.setDataCadastro(p.getDataCadastro());
		retorno.setDataDesligamento(p.getDataDesligamento());

		return retorno;
	}

	public List<FamiliaresTO> buildAll(List<Familiares> dtos) {
		return dtos.stream().map(dto -> buildTO(dto)).collect(Collectors.toList());
	}

}
