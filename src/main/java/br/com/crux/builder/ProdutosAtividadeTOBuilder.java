package br.com.crux.builder;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.cmd.GetAtividadeCmd;
import br.com.crux.cmd.GetProdutoCmd;
import br.com.crux.entity.Atividades;
import br.com.crux.entity.Produto;
import br.com.crux.entity.ProdutosAtividade;
import br.com.crux.enums.FormaPagamento;
import br.com.crux.to.ProdutosAtividadeTO;

@Component
public class ProdutosAtividadeTOBuilder {

	@Autowired private AtividadesTOBuilder atividadeBuilder;
	@Autowired private ProdutoTOBuilder produtoBuilder;
	@Autowired private GetAtividadeCmd getAtividadeCmd;
	@Autowired private GetProdutoCmd getProdutoCmd;

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

		Optional.ofNullable(p.getFormaPagamento()).ifPresent(tipo -> {
			retorno.setFormaPagamento(FormaPagamento.getPorTipo(tipo));
		});

		Optional.ofNullable(p.getAtividade()).ifPresent(atividade -> {
			Atividades a = getAtividadeCmd.getById(atividade.getId());
			retorno.setAtividade(a);
		});

		Optional.ofNullable(p.getProduto()).ifPresent(produto -> {
			Produto prod = getProdutoCmd.getById(produto.getId());
			retorno.setProduto(prod);
		});

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

		Optional.ofNullable(p.getFormaPagamento()).ifPresent(formaPagamento -> {
			retorno.setFormaPagamento(formaPagamento.getTipo());
		});

		retorno.setAtividade(atividadeBuilder.buildTO(p.getAtividade()));
		retorno.setProduto(produtoBuilder.buildTO(p.getProduto()));

		retorno.setUsuarioAlteracao(p.getUsuarioAlteracao());

		return retorno;
	}

	public List<ProdutosAtividadeTO> buildAll(List<ProdutosAtividade> dtos) {
		return dtos.stream().map(dto -> buildTO(dto)).collect(Collectors.toList());
	}

}
