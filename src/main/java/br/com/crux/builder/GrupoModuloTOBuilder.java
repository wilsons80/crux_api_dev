package br.com.crux.builder;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import br.com.crux.entity.GruposModulo;
import br.com.crux.to.GrupoModuloTO;


@Component
public class GrupoModuloTOBuilder {
	
	
	public GrupoModuloTO buildTO(GruposModulo dto) {
		GrupoModuloTO to = new GrupoModuloTO();
		
		to.setIdGrupo(dto.getIdGrupoModulo());
		to.setDescricao(dto.getTxDescricaoGrupo());
		to.setNome(dto.getNmGrupo());
		
		return to;
	}
	
	public List<GrupoModuloTO> buildAll(List<GruposModulo> dtos){
		return dtos.stream().map(dto -> buildTO(dto)).collect(Collectors.toList());
	}

}
