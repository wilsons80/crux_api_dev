package br.com.crux.cmd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.dao.repository.QuestionariosRepository;
import br.com.crux.entity.Questionario;
import br.com.crux.rule.CamposObrigatoriosQuestionariosRule;
import br.com.crux.to.QuestionariosTO;
import br.com.crux.to.UsuarioLogadoTO;

@Component
public class CadastrarQuestionariosCmd {


	@Autowired private QuestionariosRepository repository;
	
	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;
	@Autowired private CamposObrigatoriosQuestionariosRule camposObrigatoriosRule;

	
	public void cadastrar(QuestionariosTO to) {
		camposObrigatoriosRule.verificar(to.getDescricao());
		
		Questionario entity = new Questionario();

		entity.setDescricao(to.getDescricao());
		entity.setTipoQuestionario(to.getTipoQuestionario());
		entity.setDataInicio(to.getDataInicio());
		entity.setDataFim(to.getDataFim());
		
		UsuarioLogadoTO usuarioLogado = getUsuarioLogadoCmd.getUsuarioLogado();
		entity.setUsuarioAlteracao(usuarioLogado.getIdUsuario());
		
		repository.save(entity);
		
	}
}
