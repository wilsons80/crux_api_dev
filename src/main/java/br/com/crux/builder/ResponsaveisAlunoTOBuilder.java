package br.com.crux.builder;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.entity.ResponsaveisAluno;
import br.com.crux.enums.TipoResponsavel;
import br.com.crux.to.FamiliaresTO;
import br.com.crux.to.ResponsaveisAlunoTO;

@Component
public class ResponsaveisAlunoTOBuilder {

	@Autowired private AlunoTOBuilder alunoTOBuilder;
	@Autowired private FamiliaresTOBuilder familiaresTOBuilder;

	
	public ResponsaveisAluno build(ResponsaveisAlunoTO p, FamiliaresTO familiarTO) {
		ResponsaveisAluno retorno = new ResponsaveisAluno();

		retorno.setId(p.getId());
		retorno.setDescDesligamento(p.getDescDesligamento());
		retorno.setDescGrauParentesco(p.getDescGrauParentesco());
		retorno.setDataDesvinculacao(p.getDataDesvinculacao());
		retorno.setDataVinculacao(p.getDataVinculacao());
		retorno.setMesmoEnderResponsavel(p.getMesmoEnderResponsavel());
		retorno.setAluno(alunoTOBuilder.build(familiarTO.getAluno()));
		retorno.setFamiliar(familiaresTOBuilder.build(familiarTO));

		
		if( StringUtils.isNoneEmpty(p.getTipoResponsavel())) {
			TipoResponsavel porTipo = TipoResponsavel.getPorTipo(p.getTipoResponsavel());
			retorno.setTipoResponsavel(porTipo);
		}
		retorno.setUsuarioAlteracao(p.getUsuarioAlteracao());

		return retorno;
	}

	public ResponsaveisAlunoTO buildTO(ResponsaveisAluno p) {
		ResponsaveisAlunoTO retorno = new ResponsaveisAlunoTO();
		
		if (Objects.isNull(p)) {
			return retorno;
		}
		
		retorno.setId(p.getId());
		retorno.setDescDesligamento(p.getDescDesligamento());
		retorno.setDescGrauParentesco(p.getDescGrauParentesco());
		retorno.setDataDesvinculacao(p.getDataDesvinculacao());
		retorno.setDataVinculacao(p.getDataVinculacao());
		retorno.setMesmoEnderResponsavel(p.getMesmoEnderResponsavel());
		retorno.setUsuarioAlteracao(p.getUsuarioAlteracao());
		retorno.setAluno(alunoTOBuilder.buildTO(p.getAluno()));
		retorno.setFamiliar(familiaresTOBuilder.buildResponsavalTO(p.getFamiliar()));
		
		if(Objects.nonNull(p.getTipoResponsavel())) {
			TipoResponsavel porTipo = TipoResponsavel.getPorTipo(p.getTipoResponsavel().getTipo());
			retorno.setTipoResponsavel(porTipo.getTipo());
		}
		
		return retorno;
	}

	public List<ResponsaveisAlunoTO> buildAll(List<ResponsaveisAluno> dtos) {
		return dtos.stream().map(dto -> buildTO(dto)).collect(Collectors.toList());
	}

}
