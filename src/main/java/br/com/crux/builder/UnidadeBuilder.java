package br.com.crux.builder;

import org.springframework.stereotype.Component;

import br.com.crux.entity.Unidade;
import br.com.crux.enums.ClassificadorSituacaoImovel;
import br.com.crux.enums.TipoUnidade;
import br.com.crux.to.UnidadeTO;


@Component
public class UnidadeBuilder {
	
	public Unidade build(UnidadeTO to) {
		Unidade unidade = new Unidade();

		unidade.setIdUnidade(to.getIdUnidade());
		unidade.setSiglaUnidade(to.getSiglaUnidade());
		unidade.setNomeUnidade(to.getNomeUnidade());
		unidade.setEndereco(to.getEndereco());
		unidade.setTelefone(to.getTelefone());
		unidade.setDescricaoSituacaoImovel(to.getDescricaoSituacaoImovel());
		unidade.setDescricaoEstruturaFisicaImovel(to.getDescricaoEstruturaFisicaImovel());
		unidade.setUsuarioAlteracao(to.getUsuarioAlteracao());
		unidade.setVisao(to.getVisao());
		unidade.setMissao(to.getMissao());
		unidade.setEmail(to.getEmail());
		unidade.setCep(to.getCep());
		unidade.setBairro(to.getBairro());
		unidade.setUf(to.getUf());
		unidade.setCelular(to.getCelular());
		unidade.setTipoUnidade(to.getTipoUnidade().getTipo());
		unidade.setClassificacaoSituacaoImovel(to.getClassificacaoSituacaoImovel().getTipo());
		
		//unidade.setArquivo(to.getArquivo());

		return unidade;
	}

	public UnidadeTO buildTO(Unidade to) {
		UnidadeTO unidade = new UnidadeTO();

		unidade.setIdUnidade(to.getIdUnidade());
		unidade.setSiglaUnidade(to.getSiglaUnidade());
		unidade.setNomeUnidade(to.getNomeUnidade());
		unidade.setEndereco(to.getEndereco());
		unidade.setTelefone(to.getTelefone());
		unidade.setDescricaoSituacaoImovel(to.getDescricaoSituacaoImovel());
		unidade.setDescricaoEstruturaFisicaImovel(to.getDescricaoEstruturaFisicaImovel());
		unidade.setUsuarioAlteracao(to.getUsuarioAlteracao());
		unidade.setVisao(to.getVisao());
		unidade.setMissao(to.getMissao());
		unidade.setEmail(to.getEmail());
		unidade.setCep(to.getCep());
		unidade.setBairro(to.getBairro());
		unidade.setUf(to.getUf());
		unidade.setCelular(to.getCelular());
		unidade.setTipoUnidade(TipoUnidade.getPorTipo(to.getTipoUnidade()));
		unidade.setClassificacaoSituacaoImovel(ClassificadorSituacaoImovel.getPorTipo(to.getClassificacaoSituacaoImovel()));
		
		//unidade.setArquivo(to.getArquivo());

		return unidade;
	}

}