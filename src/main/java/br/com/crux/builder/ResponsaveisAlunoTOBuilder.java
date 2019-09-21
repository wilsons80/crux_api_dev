package br.com.crux.builder;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.entity.ResponsaveisAluno;
import br.com.crux.to.ResponsaveisAlunoTO;

@Component
public class ResponsaveisAlunoTOBuilder {

	@Autowired private AlunoTOBuilder alunoBuilder;
	@Autowired private FamiliaresTOBuilder familiaresBuilder;

	public ResponsaveisAluno build(ResponsaveisAlunoTO p) {
		ResponsaveisAluno retorno = new ResponsaveisAluno();

		retorno.setId(p.getId());
		retorno.setDescDesligamento(p.getDescDesligamento());
		retorno.setDescGrauParentesco(p.getDescGrauParentesco());
		retorno.setDataDesvinculacao(p.getDataDesvinculacao());
		retorno.setDataVinculacao(p.getDataVinculacao());
		retorno.setMesmoEnderResponsavel(p.getMesmoEnderResponsavel());
		retorno.setTipoResponsavel(p.getTipoResponsavel());
		retorno.setAluno(alunoBuilder.build(p.getAluno()));
		retorno.setFamiliar(familiaresBuilder.build(p.getFamiliar()));
		retorno.setUsuarioAlteracao(p.getUsuarioAlteracao());

		return retorno;
	}

	public ResponsaveisAlunoTO buildTO(ResponsaveisAluno p) {
		ResponsaveisAlunoTO retorno = new ResponsaveisAlunoTO();
		
		retorno.setId(p.getId());
		retorno.setDescDesligamento(p.getDescDesligamento());
		retorno.setDescGrauParentesco(p.getDescGrauParentesco());
		retorno.setDataDesvinculacao(p.getDataDesvinculacao());
		retorno.setDataVinculacao(p.getDataVinculacao());
		retorno.setMesmoEnderResponsavel(p.getMesmoEnderResponsavel());
		retorno.setTipoResponsavel(p.getTipoResponsavel());
		retorno.setAluno(alunoBuilder.buildTO(p.getAluno()));
		retorno.setFamiliar(familiaresBuilder.buildTO(p.getFamiliar()));
		retorno.setUsuarioAlteracao(p.getUsuarioAlteracao());


		return retorno;
	}

	public List<ResponsaveisAlunoTO> buildAll(List<ResponsaveisAluno> dtos) {
		return dtos.stream().map(dto -> buildTO(dto)).collect(Collectors.toList());
	}

}
