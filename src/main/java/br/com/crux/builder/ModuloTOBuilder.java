package br.com.crux.builder;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import br.com.crux.dao.dto.ModuloDTO;
import br.com.crux.to.ModuloTO;


@Component
public class ModuloTOBuilder {
	
	
	public ModuloTO buildTO(ModuloDTO dto) {
		ModuloTO to = new ModuloTO();
		to.setIdModulo(dto.getIdModulo());
		to.setDescricao(dto.getDescricao());
		to.setNome(dto.getNome());
		
		return to;
	}
	
	public List<ModuloTO> buildAll(List<ModuloDTO> dtos){
		return dtos.stream().map(dto -> buildTO(dto)).collect(Collectors.toList());
	}

}
