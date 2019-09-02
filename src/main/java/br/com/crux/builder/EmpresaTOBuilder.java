package br.com.crux.builder;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.entity.Empresa;
import br.com.crux.to.EmpresaTO;


@Component
public class EmpresaTOBuilder {
	
	@Autowired
	private CargosTOBuilder cargoTOBuilder;
	

	public Empresa build(EmpresaTO p) {
		Empresa retorno = new Empresa();
		
		
		return retorno;
	}

	
	public EmpresaTO buildTO(Empresa param) {
		EmpresaTO retorno = new EmpresaTO();
		

		
		return retorno;
	}
	
	
	
	public List<EmpresaTO> buildAll(List<Empresa> dtos){
		return dtos.stream().map(dto -> buildTO(dto)).collect(Collectors.toList());
	}

}
