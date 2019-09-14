package br.com.crux.builder;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.entity.TalentosPf;
import br.com.crux.to.TalentosPfTO;

@Component
public class TalentosPFTOBuilder {

	@Autowired private PessoaFisicaTOBuilder pessoaFisicaBuilder;
	@Autowired private QuestionariosTOBuilder questionariosTOBuilder;

	public TalentosPf build(TalentosPfTO p) {
		TalentosPf retorno = new TalentosPf();

		retorno.setId(p.getId());
		retorno.setRespostaTalento(p.getRespostaTalento());
		retorno.setDataRespostaTalento(p.getDataRespostaTalento());
		retorno.setNrNotaCompetencia(p.getNrNotaCompetencia());
		retorno.setObservacao(p.getObservacao());
		retorno.setPessoasFisica(pessoaFisicaBuilder.build(p.getPessoasFisica()));
		retorno.setQuestionario(questionariosTOBuilder.build(p.getQuestionario()));
		retorno.setUsuariosAlteracao(p.getUsuariosAlteracao());

		return retorno;
	}

	public TalentosPfTO buildTO(TalentosPf p) {
		TalentosPfTO retorno = new TalentosPfTO();
		
		retorno.setId(p.getId());
		retorno.setRespostaTalento(p.getRespostaTalento());
		retorno.setDataRespostaTalento(p.getDataRespostaTalento());
		retorno.setNrNotaCompetencia(p.getNrNotaCompetencia());
		retorno.setObservacao(p.getObservacao());
		retorno.setPessoasFisica(pessoaFisicaBuilder.buildTO(p.getPessoasFisica()));
		retorno.setQuestionario(questionariosTOBuilder.buildTO(p.getQuestionario()));
		retorno.setUsuariosAlteracao(p.getUsuariosAlteracao());


		return retorno;
	}

	public List<TalentosPfTO> buildAll(List<TalentosPf> dtos) {
		return dtos.stream().map(dto -> buildTO(dto)).collect(Collectors.toList());
	}

}
