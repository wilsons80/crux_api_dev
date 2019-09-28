package br.com.crux.cmd;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.AlunoTOBuilder;
import br.com.crux.builder.EntidadesSociaisTOBuilder;
import br.com.crux.dao.repository.EncaminhaAlunosRepository;
import br.com.crux.entity.EncaminhaAlunos;
import br.com.crux.exception.NotFoundException;
import br.com.crux.rule.CamposObrigatoriosEncaminhaAlunosRule;
import br.com.crux.to.EncaminhaAlunosTO;
import br.com.crux.to.UsuarioLogadoTO;

@Component
public class CadastrarEncaminhaAlunosCmd {

	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;
	
	@Autowired private EncaminhaAlunosRepository repository;
	@Autowired private CamposObrigatoriosEncaminhaAlunosRule camposObrigatoriosRule;
	
	@Autowired private AlunoTOBuilder alunoTOBuilder;
	@Autowired private EntidadesSociaisTOBuilder entidadesSociaisTOBuilder;
	
	
	public void cadastrar(EncaminhaAlunosTO to) {
		if(Objects.isNull(to.getAluno())) {
			throw new NotFoundException("Aluno não informado.");
		}
		if(Objects.isNull(to.getEntidadesSociais())) {
			throw new NotFoundException("Entidade social não informada.");
		}
		
		camposObrigatoriosRule.verificar(to.getEntidadesSociais().getId(), to.getAluno().getId());
		
		EncaminhaAlunos entity = new EncaminhaAlunos();
		
		entity.setDataEncaminhaAluno(to.getDataEncaminhaAluno());
		entity.setDescricao(to.getDescricao());
		entity.setEntidadesSociai(entidadesSociaisTOBuilder.build(to.getEntidadesSociais()));
		entity.setAluno(alunoTOBuilder.build(to.getAluno()));
		
		UsuarioLogadoTO usuarioLogado = getUsuarioLogadoCmd.getUsuarioLogado();
		entity.setUsuarioAlteracao(usuarioLogado.getIdUsuario());
		
		repository.save(entity);

		
	}
}
