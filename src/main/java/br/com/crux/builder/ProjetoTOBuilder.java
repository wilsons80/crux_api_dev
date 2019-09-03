package br.com.crux.builder;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.entity.Projeto;
import br.com.crux.to.ProjetoTO;


@Component
public class ProjetoTOBuilder {
	
	@Autowired private IniciativaTOBuilder iniciativaTOBuilder;
	@Autowired private ProgramaTOBuilder programaTOBuilder;

	public Projeto build(ProjetoTO p) {
		Projeto retorno = new Projeto();
		
		retorno.setId(p.getId());
		retorno.setNome(p.getNome());
		retorno.setDescricao(p.getDescricao());
		
		retorno.setDataInicio(p.getDataInicio());
		retorno.setDataFim(p.getDataFim());
		retorno.setUsuarioAlteracao(p.getUsuarioAlteracao());
		
		retorno.setDataPrevisaoInicio(p.getDataPrevisaoInicio());
		retorno.setDataPrevisaoTermino(p.getDataPrevisaoTermino());
		
		retorno.setIniciativa(iniciativaTOBuilder.build(p.getIniciativa()));
		retorno.setPrograma(programaTOBuilder.build(p.getPrograma()));
		
		return retorno;
	}

	
	public ProjetoTO buildTO(Projeto p) {
		ProjetoTO retorno = new ProjetoTO();
		
		retorno.setId(p.getId());
		retorno.setNome(p.getNome());
		retorno.setDescricao(p.getDescricao());
		
		retorno.setDataInicio(p.getDataInicio());
		retorno.setDataFim(p.getDataFim());
		retorno.setUsuarioAlteracao(p.getUsuarioAlteracao());
		
		retorno.setDataPrevisaoInicio(p.getDataPrevisaoInicio());
		retorno.setDataPrevisaoTermino(p.getDataPrevisaoTermino());
		
		retorno.setIniciativa(iniciativaTOBuilder.buildTO(p.getIniciativa()));
		retorno.setPrograma(programaTOBuilder.buildTO(p.getPrograma()));

		
		return retorno;
	}
	
	
	
	public List<ProjetoTO> buildAll(List<Projeto> dtos){
		return dtos.stream().map(dto -> buildTO(dto)).collect(Collectors.toList());
	}

}
