package br.com.crux.builder;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import br.com.crux.entity.Produto;
import br.com.crux.to.ProdutoTO;

@Component
public class ProdutoTOBuilder {

	public Produto build(ProdutoTO p) {
		Produto retorno = new Produto();

		retorno.setId(p.getId());
		retorno.setNome(p.getNome());
		retorno.setCodigoUnidadeMedida(p.getCodigoUnidadeMedida());
		retorno.setDescricaoUnidadeMedida(p.getDescricaoUnidadeMedida());
		retorno.setNomeProdutoNatafiscal(p.getNomeProdutoNatafiscal());
		retorno.setUsuarioAlteracao(p.getUsuarioAlteracao());

		return retorno;
	}

	public ProdutoTO buildTO(Produto p) {
		ProdutoTO retorno = new ProdutoTO();
		
		retorno.setId(p.getId());
		retorno.setNome(p.getNome());
		retorno.setCodigoUnidadeMedida(p.getCodigoUnidadeMedida());
		retorno.setDescricaoUnidadeMedida(p.getDescricaoUnidadeMedida());
		retorno.setNomeProdutoNatafiscal(p.getNomeProdutoNatafiscal());
		retorno.setUsuarioAlteracao(p.getUsuarioAlteracao());

		return retorno;
	}

	public List<ProdutoTO> buildAll(List<Produto> dtos) {
		return dtos.stream().map(dto -> buildTO(dto)).collect(Collectors.toList());
	}

}
