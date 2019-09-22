package br.com.crux.cmd;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.AtendimentosTOBuilder;
import br.com.crux.builder.FamiliaresTOBuilder;
import br.com.crux.builder.FuncionarioTOBuilder;
import br.com.crux.dao.repository.AtendimentosRepository;
import br.com.crux.dao.repository.FuncionarioRepository;
import br.com.crux.dao.repository.ParticipantesAtendimentosRepository;
import br.com.crux.entity.Atendimentos;
import br.com.crux.entity.Funcionario;
import br.com.crux.entity.ParticipantesAtendimentos;
import br.com.crux.exception.NotFoundException;
import br.com.crux.rule.CamposObrigatoriosParticipantesAtendimentosRule;
import br.com.crux.to.ParticipantesAtendimentosTO;
import br.com.crux.to.UsuarioLogadoTO;

@Component
public class AlterarParticipantesAtendimentosCmd {

	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;

	@Autowired private ParticipantesAtendimentosRepository repository;
	@Autowired private CamposObrigatoriosParticipantesAtendimentosRule camposObrigatoriosRule;

	@Autowired private AtendimentosRepository atendimentoRepository;
	@Autowired private AtendimentosTOBuilder atendimentoBuilder;
	
	@Autowired private FamiliaresTOBuilder familiarBuilder;
	
	@Autowired private FuncionarioRepository funcionarioRepository;
	@Autowired private FuncionarioTOBuilder funcionarioBuilder;
	
	
	public void alterar(ParticipantesAtendimentosTO to) {
		Optional<ParticipantesAtendimentos> entityOptional = repository.findById(to.getId());
		if(!entityOptional.isPresent()) {
			throw new NotFoundException("Participante atendimento informado não existe.");
		}
		
		if(Objects.isNull(to.getAtendimento())) {
			throw new NotFoundException("Atendimento não informado.");
		}
		if(Objects.isNull(to.getFuncionario())) {
			throw new NotFoundException("Funcionário não informado.");
		}
		
		camposObrigatoriosRule.verificar(to.getAtendimento().getId(), to.getFuncionario().getId());
		
		Optional<Atendimentos> atendimentoOptional = atendimentoRepository.findById(to.getAtendimento().getId());
		if(!atendimentoOptional.isPresent()) {
			throw new NotFoundException("Atendimento informado não existe.");
		}
		Optional<Funcionario> funcionarioOptional = funcionarioRepository.findById(to.getAtendimento().getId());
		if(!funcionarioOptional.isPresent()) {
			throw new NotFoundException("Funcionario informado não existe.");
		}
		
		ParticipantesAtendimentos entity = entityOptional.get();

		entity.setFamiliar(familiarBuilder.build(to.getFamiliar()));
		entity.setFuncionario(funcionarioBuilder.build(to.getFuncionario()));
		entity.setAtendimento(atendimentoBuilder.build(to.getAtendimento()));
		
		UsuarioLogadoTO usuarioLogado = getUsuarioLogadoCmd.getUsuarioLogado();
		entity.setUsuarioAlteracao(usuarioLogado.getIdUsuario());
		
		repository.save(entity);
		
	}
}
