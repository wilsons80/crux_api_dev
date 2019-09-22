package br.com.crux.cmd;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.AlunoTOBuilder;
import br.com.crux.dao.repository.AlunoRepository;
import br.com.crux.dao.repository.AlunosTrabalhandoRepository;
import br.com.crux.entity.Aluno;
import br.com.crux.entity.AlunosTrabalhando;
import br.com.crux.exception.NotFoundException;
import br.com.crux.rule.CamposObrigatoriosAlunosTrabalhandoRule;
import br.com.crux.to.AlunosTrabalhandoTO;
import br.com.crux.to.UsuarioLogadoTO;

@Component
public class CadastrarAlunosTrabalhandoCmd {

	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;

	@Autowired private AlunosTrabalhandoRepository repository;
	@Autowired private CamposObrigatoriosAlunosTrabalhandoRule camposObrigatoriosRule;

	@Autowired private AlunoRepository alunoRepository;
	@Autowired private AlunoTOBuilder alunoBuilder;
	
	
	public void cadastrar(AlunosTrabalhandoTO to) {
		
		if(Objects.isNull(to.getAluno())) {
			throw new NotFoundException("Aluno não informado.");
		}
		
		camposObrigatoriosRule.verificar(to.getAluno().getId());
		
		Optional<Aluno> alunoOptional = alunoRepository.findById(to.getAluno().getId());
		if(!alunoOptional.isPresent()) {
			throw new NotFoundException("Aluno informado não existe.");
		}
		
		AlunosTrabalhando entity = new AlunosTrabalhando();

		entity.setDescTipoEmpreendimento(to.getDescTipoEmpreendimento());
		entity.setNomeEmpreendimento(to.getNomeEmpreendimento());
		entity.setDataFimAlunoTrabalhando(to.getDataFimAlunoTrabalhando());
		entity.setDataInicioAlunoTrabalhando(to.getDataInicioAlunoTrabalhando());
		entity.setAluno(alunoBuilder.build(to.getAluno()));
		
		UsuarioLogadoTO usuarioLogado = getUsuarioLogadoCmd.getUsuarioLogado();
		entity.setUsuarioAlteracao(usuarioLogado.getIdUsuario());
		
		repository.save(entity);

		
	}
}
