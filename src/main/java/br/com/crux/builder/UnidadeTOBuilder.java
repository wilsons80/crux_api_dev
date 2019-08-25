package br.com.crux.builder;

import org.springframework.stereotype.Component;

import br.com.crux.entity.Unidade;
import br.com.crux.to.AcessoUnidadeTO;

@Component
public class UnidadeTOBuilder {
	
	public AcessoUnidadeTO build(Unidade unidade) {
		AcessoUnidadeTO to = new AcessoUnidadeTO();
		to.setId(unidade.getIdUnidade());
		to.setIdentificador(unidade.getCodigoUnidade());
		to.setNome(unidade.getNomeUnidade());
		
		return to;
	}
	

}
