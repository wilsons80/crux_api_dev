package br.com.crux.builder;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.cmd.GetPlanosAcaoCmd;
import br.com.crux.cmd.GetProjetoCmd;
import br.com.crux.cmd.GetUnidadeCmd;
import br.com.crux.entity.Atividades;
import br.com.crux.entity.PlanosAcao;
import br.com.crux.entity.Projeto;
import br.com.crux.entity.Unidade;
import br.com.crux.to.AtividadesTO;

@Component
public class AtividadesTOBuilder {

	@Autowired private UnidadeTOBuilder unidadeBuilder;
	@Autowired private ProjetoTOBuilder projetoBuilder;
	@Autowired private PlanosAcaoTOBuilder planosAcaoBuilder;
	@Autowired private GetUnidadeCmd getUnidadeCmd;
	@Autowired private GetProjetoCmd getProjetoCmd;
	@Autowired private GetPlanosAcaoCmd getPlanosAcaoCmd;

	public Atividades build(AtividadesTO p) {
		Atividades retorno = new Atividades();

		retorno.setId(p.getId());
		retorno.setDescricao(p.getDescricao());
		retorno.setDescricaoLocalExecucao(p.getDescricaoLocalExecucao());
		retorno.setDataFim(p.getDataFim());
		retorno.setDataInicio(p.getDataInicio());
		retorno.setDataPrevisaoInicio(p.getDataPrevisaoInicio());
		retorno.setDataPrevisaoTermino(p.getDataPrevisaoTermino());
		retorno.setHoraFim(p.getHoraFim());
		retorno.setHoraInicio(p.getHoraInicio());
		retorno.setNumeroAulas(p.getNumeroAulas());
		retorno.setCargaHoraria(p.getCargaHoraria());
		retorno.setMaximoParticipantes(p.getMaximoParticipantes());
		retorno.setPeriodoAtividade(p.getPeriodoAtividade());
		retorno.setHorarioFixo(p.getHorarioFixo());
		retorno.setLocalExecucao(p.getLocalExecucao());

		retorno.setSegunda(p.getSegunda() ? "S" : "N");
		retorno.setTerca(p.getTerca() ? "S" : "N");
		retorno.setQuarta(p.getQuarta() ? "S" : "N");
		retorno.setQuinta(p.getQuinta() ? "S" : "N");
		retorno.setSexta(p.getSexta() ? "S" : "N");
		retorno.setSabado(p.getSabado() ? "S" : "N");
		retorno.setDomingo(p.getDomingo() ? "S" : "N");

		retorno.setObservacoes(p.getObservacoes());
		retorno.setValorCustoAtividade(p.getValorCustoAtividade());

		Optional.ofNullable(p.getUnidade()).ifPresent(u -> {
			Unidade unidade = getUnidadeCmd.getById(u.getIdUnidade());
			retorno.setUnidade(unidade);
		});

		Optional.ofNullable(p.getProjeto()).ifPresent(pj -> {
			Projeto projeto = getProjetoCmd.getById(pj.getId());
			retorno.setProjeto(projeto);
		});

		Optional.ofNullable(p.getPlanosAcao()).ifPresent(pa -> {
			PlanosAcao planos = getPlanosAcaoCmd.getById(pa.getId());
			retorno.setPlanosAcao(planos);
		});

		retorno.setUsuarioAlteracao(p.getUsuarioAlteracao());

		return retorno;
	}

	public AtividadesTO buildTO(Atividades p) {
		AtividadesTO retorno = new AtividadesTO();
		
		if(Objects.isNull(p)) {
			return retorno;
		}
		

		retorno.setId(p.getId());
		retorno.setDescricao(p.getDescricao());
		retorno.setDescricaoLocalExecucao(p.getDescricaoLocalExecucao());
		retorno.setDataFim(p.getDataFim());
		retorno.setDataInicio(p.getDataInicio());
		retorno.setDataPrevisaoInicio(p.getDataPrevisaoInicio());
		retorno.setDataPrevisaoTermino(p.getDataPrevisaoTermino());
		retorno.setHoraFim(p.getHoraFim());
		retorno.setHoraInicio(p.getHoraInicio());
		retorno.setNumeroAulas(p.getNumeroAulas());
		retorno.setCargaHoraria(p.getCargaHoraria());
		retorno.setMaximoParticipantes(p.getMaximoParticipantes());
		retorno.setPeriodoAtividade(p.getPeriodoAtividade());
		retorno.setHorarioFixo(p.getHorarioFixo());
		retorno.setLocalExecucao(p.getLocalExecucao());

		retorno.setSegunda(Objects.nonNull(p.getSegunda()) && p.getSegunda().equalsIgnoreCase("S") ? true : false);
		retorno.setTerca(Objects.nonNull(p.getTerca()) && p.getTerca().equalsIgnoreCase("S") ? true : false);
		retorno.setQuarta(Objects.nonNull(p.getQuarta()) && p.getQuarta().equalsIgnoreCase("S") ? true : false);
		retorno.setQuinta(Objects.nonNull(p.getQuinta()) && p.getQuinta().equalsIgnoreCase("S") ? true : false);
		retorno.setSexta(Objects.nonNull(p.getSexta()) && p.getSexta().equalsIgnoreCase("S") ? true : false);
		retorno.setSabado(Objects.nonNull(p.getSabado()) && p.getSabado().equalsIgnoreCase("S") ? true : false);
		retorno.setDomingo(Objects.nonNull(p.getDomingo()) && p.getDomingo().equalsIgnoreCase("S") ? true : false);

		retorno.setObservacoes(p.getObservacoes());
		retorno.setValorCustoAtividade(p.getValorCustoAtividade());
		retorno.setUnidade(unidadeBuilder.buildTO(p.getUnidade()));
		retorno.setProjeto(projetoBuilder.buildTO(p.getProjeto()));
		retorno.setPlanosAcao(planosAcaoBuilder.buildTO(p.getPlanosAcao()));
		retorno.setUsuarioAlteracao(p.getUsuarioAlteracao());

		return retorno;
	}

	public List<AtividadesTO> buildAll(List<Atividades> dtos) {
		return dtos.stream().map(dto -> buildTO(dto)).collect(Collectors.toList());
	}

}
