package br.com.crux.cmd;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.AlunoTOBuilder;
import br.com.crux.builder.FamiliaresTOBuilder;
import br.com.crux.dao.repository.AlunoRepository;
import br.com.crux.dao.repository.FamiliaresRepository;
import br.com.crux.dao.repository.ResponsaveisAlunoRepository;
import br.com.crux.entity.Aluno;
import br.com.crux.entity.Familiares;
import br.com.crux.entity.ResponsaveisAluno;
import br.com.crux.exception.NotFoundException;
import br.com.crux.rule.CamposObrigatoriosResponsaveisAlunoRule;
import br.com.crux.to.ResponsaveisAlunoTO;
import br.com.crux.to.UsuarioLogadoTO;

@Component
public class AlterarResponsaveisAlunoCmd {

	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;
	
	@Autowired private ResponsaveisAlunoRepository repository;
	@Autowired private CamposObrigatoriosResponsaveisAlunoRule camposObrigatoriosRule;

	@Autowired private AlunoRepository alunoRepository;
	@Autowired private AlunoTOBuilder alunoBuilder;
	@Autowired private FamiliaresRepository familiarRepository;
	@Autowired private FamiliaresTOBuilder familiarBuilder;
	
	
	
	public void alterar(ResponsaveisAlunoTO to) {
		Optional<ResponsaveisAluno> entityOptional = repository.findById(to.getId());
		if(!entityOptional.isPresent()) {
			throw new NotFoundException("Responsavel do Aluno informada não existe.");
		}
		
		if(Objects.isNull(to.getAluno())) {
			throw new NotFoundException("Aluno não informado.");
		}
		if(Objects.isNull(to.getFamiliar())) {
			throw new NotFoundException("Familiar não informado.");
		}
		
		camposObrigatoriosRule.verificar(to.getAluno().getId(), to.getFamiliar().getId());
		
		Optional<Aluno> alunoOptional = alunoRepository.findById(to.getAluno().getId());
		if(!alunoOptional.isPresent()) {
			throw new NotFoundException("Aluno informado não existe.");
		}
		Optional<Familiares> familarOptional = familiarRepository.findById(to.getFamiliar().getId());
		if(!familarOptional.isPresent()) {
			throw new NotFoundException("Familiar do aluno informado não existe.");
		}
		
		ResponsaveisAluno entity = entityOptional.get();

		entity.setDescDesligamento(to.getDescDesligamento());
		entity.setDescGrauParentesco(to.getDescGrauParentesco());
		entity.setDataDesvinculacao(to.getDataDesvinculacao());
		entity.setDataVinculacao(to.getDataVinculacao());
		entity.setMesmoEnderResponsavel(to.getMesmoEnderResponsavel());
		entity.setTipoResponsavel(to.getTipoResponsavel());
		entity.setAluno(alunoBuilder.build(to.getAluno()));
		entity.setFamiliar(familiarBuilder.build(to.getFamiliar()));

		UsuarioLogadoTO usuarioLogado = getUsuarioLogadoCmd.getUsuarioLogado();
		entity.setUsuarioAlteracao(usuarioLogado.getIdUsuario());
		
		repository.save(entity);
		
	}
}
