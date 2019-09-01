package br.com.crux.builder;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import br.com.crux.dao.dto.PerfilAcessoDTO;
import br.com.crux.to.PerfilAcessoTO;


@Component
public class PerfilAcessoTOBuilder {
	
	public PerfilAcessoTO buildTO(PerfilAcessoDTO dto) {
		PerfilAcessoTO to = new PerfilAcessoTO();
		
		to.setIdModulo(dto.getIdModulo());
		to.setNomeModulo(dto.getNomeModulo());
		to.setConsulta(dto.getConsulta());
		to.setAltera(dto.getAltera());
		to.setInsere(dto.getInsere());
		to.setDeleta(dto.getDeleta());
		
		return to;
	}
	
	public List<PerfilAcessoTO> buildAll(List<PerfilAcessoDTO> dtos){
		return dtos.stream().map(dto -> buildTO(dto)).collect(Collectors.toList());
	}

}
