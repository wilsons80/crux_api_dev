package br.com.crux.cmd;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.PessoaFisicaTOBuilder;
import br.com.crux.builder.QuestionariosTOBuilder;
import br.com.crux.dao.repository.TalentosPFRepository;
import br.com.crux.entity.TalentosPf;
import br.com.crux.exception.NotFoundException;
import br.com.crux.rule.CamposObrigatoriosTalentosPFRule;
import br.com.crux.to.TalentosPfTO;
import br.com.crux.to.UsuarioLogadoTO;

@Component
public class AlterarTalentosPFCmd {

	@Autowired private TalentosPFRepository repository;
	
	@Autowired private PessoaFisicaTOBuilder pessoaFisicaTOBuilder;
	@Autowired private QuestionariosTOBuilder questionarioTOBuilder;
	
	@Autowired private CamposObrigatoriosTalentosPFRule camposObrigatoriosCargosRule;
	
	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;
	
	
	public void alterar(TalentosPfTO to) {
		Optional<TalentosPf> entityOptional = repository.findById(to.getId());
		if(!entityOptional.isPresent()) {
			throw new NotFoundException("Talento do Funcionario informado não existe.");
		}
		
		if(Objects.isNull(to.getPessoasFisica())) {
			throw new NotFoundException("Pessoa Física não informada.");
		}
		
		if(Objects.isNull(to.getQuestionario())) {
			throw new NotFoundException("Questinário não informado.");
		}
		
		camposObrigatoriosCargosRule.verificar(to.getRespostaTalento(), to.getPessoasFisica().getId(), to.getQuestionario().getId());
		
		TalentosPf entity = entityOptional.get();
		
		entity.setRespostaTalento(to.getRespostaTalento());
		entity.setDataRespostaTalento(to.getDataRespostaTalento());
		entity.setNrNotaCompetencia(to.getNrNotaCompetencia());
		entity.setObservacao(to.getObservacao());
		entity.setPessoasFisica(pessoaFisicaTOBuilder.build(to.getPessoasFisica()));
		entity.setQuestionario(questionarioTOBuilder.build(to.getQuestionario()));
		
		UsuarioLogadoTO usuarioLogado = getUsuarioLogadoCmd.getUsuarioLogado();
		entity.setUsuariosAlteracao(usuarioLogado.getIdUsuario());
		
		repository.save(entity);
		
	}
}
