package br.com.crux.cmd;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.AlunoTOBuilder;
import br.com.crux.builder.DiagnosticosTOBuilder;
import br.com.crux.builder.SolucoesTOBuilder;
import br.com.crux.dao.repository.AlunoRepository;
import br.com.crux.dao.repository.AtendimentosRepository;
import br.com.crux.dao.repository.DiagnosticosRepository;
import br.com.crux.dao.repository.SolucoesRepository;
import br.com.crux.entity.Aluno;
import br.com.crux.entity.Atendimentos;
import br.com.crux.entity.Diagnosticos;
import br.com.crux.entity.Solucoes;
import br.com.crux.exception.NotFoundException;
import br.com.crux.rule.CamposObrigatoriosAtendimentosRule;
import br.com.crux.to.AtendimentosTO;
import br.com.crux.to.UsuarioLogadoTO;

@Component
public class AlterarAtendimentosCmd {

	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;

	@Autowired private AtendimentosRepository repository;
	@Autowired private CamposObrigatoriosAtendimentosRule camposObrigatoriosRule;

	@Autowired private AlunoRepository alunoRepository;
	@Autowired private AlunoTOBuilder alunoBuilder;
	
	@Autowired private SolucoesRepository solucoesRepository;
	@Autowired private SolucoesTOBuilder solucoesBuilder;
	
	@Autowired private DiagnosticosRepository diagnosticosRepository;
	@Autowired private DiagnosticosTOBuilder diagnosticoBuilder;

	
	public void alterar(AtendimentosTO to) {
		Optional<Atendimentos> entityOptional = repository.findById(to.getId());
		if(!entityOptional.isPresent()) {
			throw new NotFoundException("Atendimento informado não existe.");
		}
		
		if(Objects.isNull(to.getAluno())) {
			throw new NotFoundException("Aluno não informado.");
		}
		if(Objects.isNull(to.getSolucoe())) {
			throw new NotFoundException("Solução não informada.");
		}
		if(Objects.isNull(to.getDiagnostico())) {
			throw new NotFoundException("Diagnóstico não informado.");
		}
		
		camposObrigatoriosRule.verificar(to.getDataAtendimento(), to.getSolucoe().getId(), to.getAluno().getId(), to.getDiagnostico().getId());
		
		Optional<Aluno> alunoOptional = alunoRepository.findById(to.getAluno().getId());
		if(!alunoOptional.isPresent()) {
			throw new NotFoundException("Aluno informado não existe.");
		}

		Optional<Solucoes> solucaoOptional = solucoesRepository.findById(to.getAluno().getId());
		if(!solucaoOptional.isPresent()) {
			throw new NotFoundException("Solução informada não existe.");
		}
		
		Optional<Diagnosticos> diagnosticoOptional = diagnosticosRepository.findById(to.getAluno().getId());
		if(!diagnosticoOptional.isPresent()) {
			throw new NotFoundException("Diagnostico informado não existe.");
		}
		
		Atendimentos entity = entityOptional.get();

		entity.setDescDiagnostico(to.getDescDiagnostico());
		entity.setDescSolucao(to.getDescSolucao());
		entity.setDataAtendimento(to.getDataAtendimento());
		entity.setAluno(alunoBuilder.build(to.getAluno()));
		entity.setDiagnostico(diagnosticoBuilder.build(to.getDiagnostico()));
		entity.setSolucoe(solucoesBuilder.build(to.getSolucoe()));
		
		UsuarioLogadoTO usuarioLogado = getUsuarioLogadoCmd.getUsuarioLogado();
		entity.setUsuarioAlteracao(usuarioLogado.getIdUsuario());
		
		repository.save(entity);
		
	}
}
