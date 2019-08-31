package br.com.crux.builder;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.entity.Departamentos;
import br.com.crux.to.DepartamentoTO;


@Component
public class DepartamentoTOBuilder {
	
	@Autowired
	private UnidadeBuilder unidadeBuilder;
	

	public Departamentos build(DepartamentoTO to) {
		Departamentos entity = new Departamentos();
		entity.setIdDepartamento(to.getIdDepartamento());
		entity.setCdUnidadeDepartamento(to.getCdUnidadeDepartamento());
		entity.setDsEnderecoDepartamento(to.getDsEnderecoDepartamento());
		entity.setNmDepartamento(to.getNmDepartamento());
		entity.setNrTelefoneDepartamento(to.getNrTelefoneDepartamento());
		entity.setUnidade(unidadeBuilder.build(to.getUnidade()));
		if(Objects.nonNull(to.getDepartamentoSuperior())) {
			entity.setDepartamentosSuperior(buildDepartamentoSuperior(to.getDepartamentoSuperior()));
		}
		
		return entity;
	}

	
	public DepartamentoTO buildTO(Departamentos dto) {
		DepartamentoTO to = new DepartamentoTO();
		to.setIdDepartamento(dto.getIdDepartamento());
		to.setCdUnidadeDepartamento(dto.getCdUnidadeDepartamento());
		to.setDsEnderecoDepartamento(dto.getDsEnderecoDepartamento());
		to.setNmDepartamento(dto.getNmDepartamento());
		to.setNrTelefoneDepartamento(dto.getNrTelefoneDepartamento());
		to.setUnidade(unidadeBuilder.buildTO(dto.getUnidade()));
		
		if(Objects.nonNull(dto.getDepartamentosSuperior())) {
			to.setDepartamentoSuperior(buildTODepartamentoSuperior(dto.getDepartamentosSuperior()));
		}
		
		return to;
	}
	
	private DepartamentoTO buildTODepartamentoSuperior(Departamentos dto) {
		DepartamentoTO to = new DepartamentoTO();
		to.setIdDepartamento(dto.getIdDepartamento());
		to.setCdUnidadeDepartamento(dto.getCdUnidadeDepartamento());
		to.setDsEnderecoDepartamento(dto.getDsEnderecoDepartamento());
		to.setNmDepartamento(dto.getNmDepartamento());
		to.setNrTelefoneDepartamento(dto.getNrTelefoneDepartamento());
		to.setUnidade(unidadeBuilder.buildTO(dto.getUnidade()));
		return to;
	}
	
	private Departamentos buildDepartamentoSuperior(DepartamentoTO dto) {
		Departamentos entity = new Departamentos();
		entity.setIdDepartamento(dto.getIdDepartamento());
		entity.setCdUnidadeDepartamento(dto.getCdUnidadeDepartamento());
		entity.setDsEnderecoDepartamento(dto.getDsEnderecoDepartamento());
		entity.setNmDepartamento(dto.getNmDepartamento());
		entity.setNrTelefoneDepartamento(dto.getNrTelefoneDepartamento());
		entity.setUnidade(unidadeBuilder.build(dto.getUnidade()));
		return entity;
	}
	
	
	public List<DepartamentoTO> buildAll(List<Departamentos> dtos){
		return dtos.stream().map(dto -> buildTO(dto)).collect(Collectors.toList());
	}

}
