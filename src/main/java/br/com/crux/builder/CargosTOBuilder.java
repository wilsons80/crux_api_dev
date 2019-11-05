package br.com.crux.builder;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import br.com.crux.entity.Cargo;
import br.com.crux.enums.TipoCargo;
import br.com.crux.to.CargoTO;


@Component
public class CargosTOBuilder {
	
	public Cargo build(CargoTO param) {
		Cargo retorno = new Cargo();
		
		retorno.setId(param.getId());
		retorno.setCodigo(param.getCodigo());
		retorno.setNome(param.getNome());
		retorno.setTipoCargo(TipoCargo.getPorTipo(param.getTipoCargo()));
		retorno.setUsuarioAlteracao(param.getUsuarioAlteracao());
		
		return retorno;
	}

	
	public CargoTO buildTO(Cargo param) {
		CargoTO retorno = new CargoTO();
		

		if(Objects.isNull(param)) {
			return retorno;
		}
		
		retorno.setId(param.getId());
		retorno.setCodigo(param.getCodigo());
		retorno.setNome(param.getNome());
		retorno.setTipoCargo(param.getTipoCargo().getTipo());
		retorno.setUsuarioAlteracao(param.getUsuarioAlteracao());
		
		return retorno;
	}
	
	
	public List<CargoTO> buildAll(List<Cargo> dtos){
		return dtos.stream().map(dto -> buildTO(dto)).collect(Collectors.toList());
	}

}
