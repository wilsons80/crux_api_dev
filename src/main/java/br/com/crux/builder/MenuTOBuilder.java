package br.com.crux.builder;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import br.com.crux.dao.dto.MenuDTO;
import br.com.crux.to.MenuTO;


@Component
public class MenuTOBuilder {
	
	
	public MenuTO buildTO(MenuDTO dto) {
		MenuTO to = new MenuTO();
		
		to.setIdModuloPai(dto.getIdModuloPai());
		to.setNomeModuloPai(dto.getNomeModuloPai());
		to.setIdModuloFilho(dto.getIdModuloFilho());
		to.setNomeModuloFilho(dto.getNomeModuloFilho());
		to.setNivel(dto.getNivel());
		
		return to;
	}
	
	public List<MenuTO> buildAll(List<MenuDTO> dtos){
		return dtos.stream().map(dto -> buildTO(dto)).collect(Collectors.toList());
	}

}
