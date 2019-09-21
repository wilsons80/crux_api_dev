package br.com.crux.cmd;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.AlunoTOBuilder;
import br.com.crux.builder.SituacoesVulnerabilidadeTOBuilder;
import br.com.crux.builder.SolucoesTOBuilder;
import br.com.crux.dao.repository.VulnerabilidadesAlunoRepository;
import br.com.crux.entity.VulnerabilidadesAluno;
import br.com.crux.exception.NotFoundException;
import br.com.crux.rule.CamposObrigatoriosVulnerabilidadesAlunoRule;
import br.com.crux.to.UsuarioLogadoTO;
import br.com.crux.to.VulnerabilidadesAlunoTO;

@Component
public class CadastrarVulnerabilidadesAlunoCmd {

	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;
	
	@Autowired private VulnerabilidadesAlunoRepository repository;
	@Autowired private CamposObrigatoriosVulnerabilidadesAlunoRule camposObrigatoriosRule;
	
	@Autowired private SituacoesVulnerabilidadeTOBuilder situacoesVulnerabilidadeTOBuilder;
	@Autowired private SolucoesTOBuilder solucoesTOBuilder;
	@Autowired private AlunoTOBuilder alunoTOBuilder;
	
	
	public void cadastrar(VulnerabilidadesAlunoTO to) {
		if(Objects.isNull(to.getSituacoesVulnerabilidade())) {
			throw new NotFoundException("Vulnerabilidade não informada.");
		}
		if(Objects.isNull(to.getSolucoe())) {
			throw new NotFoundException("Solução não informada.");
		}
		if(Objects.isNull(to.getAluno())) {
			throw new NotFoundException("Aluno não informado.");
		}
		
		camposObrigatoriosRule.verificar(to.getDataIdentificacao(), to.getSituacoesVulnerabilidade().getId(), to.getSolucoe().getId(), to.getAluno().getId());
		
		VulnerabilidadesAluno entity = new VulnerabilidadesAluno();

		entity.setDataIdentificacao(to.getDataIdentificacao());
		entity.setDataSolucao(to.getDataSolucao());
		
		entity.setSituacoesVulnerabilidade(situacoesVulnerabilidadeTOBuilder.build(to.getSituacoesVulnerabilidade()));
		entity.setSolucoe(solucoesTOBuilder.build(to.getSolucoe()));
		entity.setAluno(alunoTOBuilder.build(to.getAluno()));
		
		UsuarioLogadoTO usuarioLogado = getUsuarioLogadoCmd.getUsuarioLogado();
		entity.setUsuarioAlteracao(usuarioLogado.getIdUsuario());
		
		repository.save(entity);
		
	}
}