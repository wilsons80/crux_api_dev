package br.com.crux.builder;

import org.springframework.stereotype.Component;

import br.com.crux.entity.Unidade;
import br.com.crux.to.UnidadeTO;

@Component
public class UnidadeTOBuilder {
	
	public UnidadeTO build(Unidade unidade) {
		UnidadeTO to = new UnidadeTO();
		to.setId(unidade.getIdUnidade());
		to.setIdentificador(unidade.getCodigoUnidade());
		to.setNome(unidade.getNomeUnidade());
		
		return to;
	}
	

}
