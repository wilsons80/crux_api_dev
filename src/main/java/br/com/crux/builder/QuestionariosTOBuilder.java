package br.com.crux.builder;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import br.com.crux.entity.Questionario;
import br.com.crux.to.QuestionariosTO;

@Component
public class QuestionariosTOBuilder {

	public Questionario build(QuestionariosTO p) {
		Questionario retorno = new Questionario();

		retorno.setId(p.getId());
		retorno.setDescricao(p.getDescricao());
		retorno.setDataInicio(p.getDataInicio());
		retorno.setDataFim(p.getDataFim());
		retorno.setTipoQuestionario(p.getTipoQuestionario());
		
		retorno.setUsuarioAlteracao(p.getUsuarioAlteracao());

		return retorno;
	}

	public QuestionariosTO buildTO(Questionario p) {
		QuestionariosTO retorno = new QuestionariosTO();
		
		retorno.setId(p.getId());
		retorno.setDescricao(p.getDescricao());
		retorno.setDataInicio(p.getDataInicio());
		retorno.setDataFim(p.getDataFim());
		retorno.setTipoQuestionario(p.getTipoQuestionario());
		
		retorno.setUsuarioAlteracao(p.getUsuarioAlteracao());

		return retorno;
	}

	public List<QuestionariosTO> buildAll(List<Questionario> dtos) {
		return dtos.stream().map(dto -> buildTO(dto)).collect(Collectors.toList());
	}

}
