package br.com.crux.cmd;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.AtividadesTOBuilder;
import br.com.crux.builder.ProdutoTOBuilder;
import br.com.crux.dao.repository.AtividadeRepository;
import br.com.crux.dao.repository.ProdutoRepository;
import br.com.crux.dao.repository.ProdutosAtividadeRepository;
import br.com.crux.entity.Atividades;
import br.com.crux.entity.Produto;
import br.com.crux.entity.ProdutosAtividade;
import br.com.crux.exception.NotFoundException;
import br.com.crux.rule.CamposObrigatoriosProdutosAtividadeRule;
import br.com.crux.to.ProdutosAtividadeTO;
import br.com.crux.to.UsuarioLogadoTO;

@Component
public class CadastrarProdutosAtividadeCmd {


	@Autowired private ProdutosAtividadeRepository repository;
	
	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;
	@Autowired private AtividadeRepository atividadeRepository;
	@Autowired private ProdutoRepository produtoRepository;
	
	@Autowired private AtividadesTOBuilder atividadeBuilder;
	@Autowired private ProdutoTOBuilder produtoBuilder;
	
	@Autowired private CamposObrigatoriosProdutosAtividadeRule camposObrigatoriosRule;
	
	
	public void cadastrar(ProdutosAtividadeTO to) {
		
		if(Objects.isNull(to.getAtividade())) {
			throw new NotFoundException("Atividade não informada.");
		}
		if(Objects.isNull(to.getProduto())) {
			throw new NotFoundException("Produto não informado.");
		}
		
		camposObrigatoriosRule.verificar(to.getDescricao(), to.getAtividade().getId(), to.getProduto().getId());

		
		Optional<Produto> produtoOptional = produtoRepository.findById(to.getProduto().getId());
		if(!produtoOptional.isPresent()) {
			throw new NotFoundException("Produto informado não existe.");
		}

		Optional<Atividades> atividadeOptional = atividadeRepository.findById(to.getAtividade().getId());
		if(!atividadeOptional.isPresent()) {
			throw new NotFoundException("Atividade informado não existe.");
		}		
				
		ProdutosAtividade entity = new ProdutosAtividade();

		entity.setDescricao(to.getDescricao());
		entity.setObservacao(to.getObservacao());
		entity.setDataAquisicao(to.getDataAquisicao());
		entity.setValorProduto(to.getValorProduto());
		entity.setDataVendaProduto(to.getDataVendaProduto());
		entity.setDescricaoOrigemProduto(to.getDescricaoOrigemProduto());
		entity.setQtdProduto(to.getQtdProduto());
		entity.setQtdProdutoVendida(to.getQtdProdutoVendida());
		entity.setFormaPagamento(to.getFormaPagamento());
		
		entity.setAtividade(atividadeBuilder.build(to.getAtividade()));
		entity.setProduto(produtoBuilder.build(to.getProduto()));
		
		UsuarioLogadoTO usuarioLogado = getUsuarioLogadoCmd.getUsuarioLogado();
		entity.setUsuarioAlteracao(usuarioLogado.getIdUsuario());
		
		repository.save(entity);
		
	}
}
