package br.com.crux.builder;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.entity.PessoaFisica;
import br.com.crux.to.PessoaFisicaTO;


@Component
public class PessoaFisicaTOBuilder {
	
	@Autowired
	private CargosTOBuilder cargoTOBuilder;
	

	public PessoaFisica build(PessoaFisicaTO p) {
		PessoaFisica retorno = new PessoaFisica();
		
		
		return retorno;
	}

	
	public PessoaFisicaTO buildTO(PessoaFisica param) {
		PessoaFisicaTO retorno = new PessoaFisicaTO();
		

		
		return retorno;
	}
	
	
	
	public List<PessoaFisicaTO> buildAll(List<PessoaFisica> dtos){
		return dtos.stream().map(dto -> buildTO(dto)).collect(Collectors.toList());
	}

}
