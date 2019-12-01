package br.com.crux.builder;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.cmd.GetColaboradoresProjetoCmd;
import br.com.crux.cmd.GetProgramaCmd;
import br.com.crux.cmd.GetProjetosUnidadeCmd;
import br.com.crux.cmd.GetUnidadeCmd;
import br.com.crux.cmd.GetUnidadeLogadaCmd;
import br.com.crux.entity.Programa;
import br.com.crux.entity.Projeto;
import br.com.crux.to.ProjetoTO;

@Component
public class ProjetoTOBuilder {

	@Autowired private ProgramaTOBuilder programaTOBuilder;
	@Autowired private GetProgramaCmd getProgramaCmd;
	@Autowired private GetUnidadeCmd getUnidadeCmd;
	@Autowired private GetUnidadeLogadaCmd getUnidadeLogadaCmd;
	@Autowired private GetProjetosUnidadeCmd getProjetosUnidadeCmd; 
	@Autowired private GetColaboradoresProjetoCmd getColaboradoresProjetoCmd; 
	
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

		Optional.ofNullable(p.getPrograma()).ifPresent(pro -> {
			if (Objects.nonNull(pro.getId())) {
				Programa programa = getProgramaCmd.getById(pro.getId());
				retorno.setPrograma(programa);
			}
		});

		Long idUnidade = getUnidadeLogadaCmd.get().getId();

		retorno.setUnidade(getUnidadeCmd.getById(idUnidade));

		return retorno;
	}

	public ProjetoTO buildTO(Projeto p) {
		ProjetoTO retorno = new ProjetoTO();

		if (Objects.isNull(retorno)) {
			return retorno;
		}

		retorno.setId(p.getId());
		retorno.setNome(p.getNome());
		retorno.setDescricao(p.getDescricao());

		retorno.setDataInicio(p.getDataInicio());
		retorno.setDataFim(p.getDataFim());
		retorno.setUsuarioAlteracao(p.getUsuarioAlteracao());

		retorno.setDataPrevisaoInicio(p.getDataPrevisaoInicio());
		retorno.setDataPrevisaoTermino(p.getDataPrevisaoTermino());
		retorno.setPrograma(programaTOBuilder.buildTO(p.getPrograma()));
		
		retorno.setUnidades(getProjetosUnidadeCmd.getUnidadesTOByIdProjeto(p.getId()));
		retorno.setColaboradoresProjeto((getColaboradoresProjetoCmd.getColaboradoresProjetoTOByProjeto(p)));

		return retorno;
	}

	public List<ProjetoTO> buildAll(List<Projeto> dtos) {
		return dtos.stream().map(dto -> buildTO(dto)).collect(Collectors.toList());
	}
	

}
