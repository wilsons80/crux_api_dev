package br.com.crux.builder;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.entity.ProdutosAtividade;
import br.com.crux.to.ProdutosAtividadeTO;

@Component
public class ProdutosAtividadeTOBuilder {

	@Autowired private AtividadeTOBuilder atividadeBuilder;
	@Autowired private ProdutoTOBuilder produtoBuilder;

	public ProdutosAtividade build(ProdutosAtividadeTO p) {
		ProdutosAtividade retorno = new ProdutosAtividade();

		retorno.setId(p.getId());
		retorno.setDescricao(p.getDescricao());
		retorno.setObservacao(p.getObservacao());
		retorno.setDataAquisicao(p.getDataAquisicao());
		retorno.setValorProduto(p.getValorProduto());
		retorno.setDataVendaProduto(p.getDataVendaProduto());
		retorno.setDescricaoOrigemProduto(p.getDescricaoOrigemProduto());
		retorno.setQtdProduto(p.getQtdProduto());
		retorno.setQtdProdutoVendida(p.getQtdProdutoVendida());
		retorno.setFormaPagamento(p.getFormaPagamento());
		
		retorno.setAtividade(atividadeBuilder.build(p.getAtividade()));
		retorno.setProduto(produtoBuilder.build(p.getProduto()));
		
		retorno.setUsuarioAlteracao(p.getUsuarioAlteracao());

		return retorno;
	}

	public ProdutosAtividadeTO buildTO(ProdutosAtividade p) {
		ProdutosAtividadeTO retorno = new ProdutosAtividadeTO();
		
		retorno.setId(p.getId());
		retorno.setDescricao(p.getDescricao());
		retorno.setObservacao(p.getObservacao());
		retorno.setDataAquisicao(p.getDataAquisicao());
		retorno.setValorProduto(p.getValorProduto());
		retorno.setDataVendaProduto(p.getDataVendaProduto());
		retorno.setDescricaoOrigemProduto(p.getDescricaoOrigemProduto());
		retorno.setQtdProduto(p.getQtdProduto());
		retorno.setQtdProdutoVendida(p.getQtdProdutoVendida());
		retorno.setFormaPagamento(p.getFormaPagamento());
		
		retorno.setAtividade(atividadeBuilder.buildTO(p.getAtividade()));
		retorno.setProduto(produtoBuilder.buildTO(p.getProduto()));
		
		retorno.setUsuarioAlteracao(p.getUsuarioAlteracao());

		return retorno;
	}

	public List<ProdutosAtividadeTO> buildAll(List<ProdutosAtividade> dtos) {
		return dtos.stream().map(dto -> buildTO(dto)).collect(Collectors.toList());
	}

}
