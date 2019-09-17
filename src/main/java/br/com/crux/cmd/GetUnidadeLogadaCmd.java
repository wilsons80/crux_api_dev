package br.com.crux.cmd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.exception.NotFoundException;
import br.com.crux.to.AcessoUnidadeTO;

@Component
public class GetUnidadeLogadaCmd {
	
	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd; 

	public AcessoUnidadeTO get() {
		AcessoUnidadeTO unidadeLogada = getUsuarioLogadoCmd.getUsuarioLogado().getUnidadeLogada();
		
		if(unidadeLogada == null) {
			throw new NotFoundException("Não é possível recuperar a unidade logada.");
		}
		
		return unidadeLogada;
	}

}
