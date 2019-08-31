package br.com.crux.builder;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.entity.Perspectiva;
import br.com.crux.to.PerspectivaTO;


@Component
public class PerspectivaTOBuilder {
	
	@Autowired
	private UnidadeBuilder unidadeBuilder;
	

	public Perspectiva build(PerspectivaTO to) {
		Perspectiva entity = new Perspectiva();
		
		entity.setIdPerspectiva(to.getIdPerspectiva());
		entity.setNmPerspectiva(to.getNmPerspectiva());
		entity.setDtImplantacao(to.getDtImplantacao());
		entity.setDtTermino(to.getDtTermino());
		entity.setUnidade(unidadeBuilder.build(to.getUnidade()));
				
		return entity;
	}

	
	public PerspectivaTO buildTO(Perspectiva dto) {
		PerspectivaTO to = new PerspectivaTO();
		
		to.setIdPerspectiva(dto.getIdPerspectiva());
		to.setNmPerspectiva(dto.getNmPerspectiva());
		to.setDtImplantacao(dto.getDtImplantacao());
		to.setDtTermino(dto.getDtTermino());
		to.setUnidade(unidadeBuilder.buildTO(dto.getUnidade()));
		
		return to;
	}
	
	
	
	public List<PerspectivaTO> buildAll(List<Perspectiva> dtos){
		return dtos.stream().map(dto -> buildTO(dto)).collect(Collectors.toList());
	}

}
