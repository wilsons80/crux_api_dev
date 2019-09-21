package br.com.crux.cmd;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.AlunoTOBuilder;
import br.com.crux.builder.AtividadesTOBuilder;
import br.com.crux.dao.repository.AtividadesAlunoRepository;
import br.com.crux.entity.AtividadesAluno;
import br.com.crux.exception.NotFoundException;
import br.com.crux.rule.CamposObrigatoriosAtividadesAlunoRule;
import br.com.crux.to.AtividadesAlunoTO;
import br.com.crux.to.UsuarioLogadoTO;

@Component
public class AlterarAtividadesAlunoCmd {

	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;
	
	@Autowired private AtividadesAlunoRepository repository;
	@Autowired private CamposObrigatoriosAtividadesAlunoRule camposObrigatoriosRule;
	
	@Autowired private AlunoTOBuilder alunoTOBuilder;
	@Autowired private AtividadesTOBuilder atividadesTOBuilder;
	
	
	public void alterar(AtividadesAlunoTO to) {
		Optional<AtividadesAluno> entityOptional = repository.findById(to.getId());
		if(!entityOptional.isPresent()) {
			throw new NotFoundException("Atividade do Aluno informada não existe.");
		}
		
		if(Objects.isNull(to.getAluno())) {
			throw new NotFoundException("Aluno não informado.");
		}
		if(Objects.isNull(to.getAtividade())) {
			throw new NotFoundException("Atividade não informada.");
		}
		
		camposObrigatoriosRule.verificar(to.getAluno().getId(), to.getAtividade().getId());
		
		AtividadesAluno entity = entityOptional.get();

		entity.setDescDesligamento(to.getDescDesligamento());
		entity.setDataInicioAtividade(to.getDataInicioAtividade());
		entity.setDataDesvinculacao(to.getDataDesvinculacao());
		//entity.setDataCadastroAtividade(to.getDataCadastroAtividade());
		entity.setDataAlteracaoAtividade(to.getDataAlteracaoAtividade());
		entity.setAluno(alunoTOBuilder.build(to.getAluno()));
		entity.setAtividade(atividadesTOBuilder.build(to.getAtividade()));
		
		UsuarioLogadoTO usuarioLogado = getUsuarioLogadoCmd.getUsuarioLogado();
		entity.setUsuarioAlteracao(usuarioLogado.getIdUsuario());
		
		repository.save(entity);
		
	}
}
