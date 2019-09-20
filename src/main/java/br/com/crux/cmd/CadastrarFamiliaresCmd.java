package br.com.crux.cmd;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.AlunoTOBuilder;
import br.com.crux.builder.PessoaFisicaTOBuilder;
import br.com.crux.dao.repository.AlunoRepository;
import br.com.crux.dao.repository.FamiliaresRepository;
import br.com.crux.dao.repository.PessoaFisicaRepository;
import br.com.crux.entity.Aluno;
import br.com.crux.entity.Familiares;
import br.com.crux.entity.PessoaFisica;
import br.com.crux.exception.NotFoundException;
import br.com.crux.rule.CamposObrigatoriosFamiliaresRule;
import br.com.crux.to.FamiliaresTO;
import br.com.crux.to.UsuarioLogadoTO;

@Component
public class CadastrarFamiliaresCmd {

	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;
	
	@Autowired private FamiliaresRepository repository;
	@Autowired private CamposObrigatoriosFamiliaresRule camposObrigatoriosRule;

	@Autowired private PessoaFisicaRepository pessoaFisicaRepository;
	@Autowired private PessoaFisicaTOBuilder pessoaFisicaBuilder;
	@Autowired private AlunoRepository alunoRepository;
	@Autowired private AlunoTOBuilder alunoBuilder;
	
	
	public void cadastrar(FamiliaresTO to) {
		
		if(Objects.isNull(to.getPessoasFisica())) {
			throw new NotFoundException("Pessoa Física não informada.");
		}
		if(Objects.isNull(to.getAluno())) {
			throw new NotFoundException("Aluno não informado.");
		}
		
		camposObrigatoriosRule.verificar(to.getDataCadastro(), to.getPessoasFisica().getId(), to.getAluno().getId());
		
		Optional<PessoaFisica> pessoaFisicaOptional = pessoaFisicaRepository.findById(to.getPessoasFisica().getId());
		if(!pessoaFisicaOptional.isPresent()) {
			throw new NotFoundException("Pessoa Fisica informada não existe.");
		}
		
		Optional<Aluno> alunoOptional = alunoRepository.findById(to.getAluno().getId());
		if(!alunoOptional.isPresent()) {
			throw new NotFoundException("Aluno informado não existe.");
		}		
		
		Familiares entity = new Familiares();

		entity.setDescGrauParentesco(to.getDescGrauParentesco());
		entity.setSituacaoParentesco(to.getSituacaoParentesco());
		entity.setDescOutrasInformacoes(to.getDescOutrasInformacoes());
		entity.setDescDesligamento(to.getDescDesligamento());
		entity.setPessoasFisica(pessoaFisicaBuilder.build(to.getPessoasFisica()));
		entity.setAluno(alunoBuilder.build(to.getAluno()));
		entity.setDataCadastro(to.getDataCadastro());
		entity.setDataDesligamento(to.getDataDesligamento());
		
		UsuarioLogadoTO usuarioLogado = getUsuarioLogadoCmd.getUsuarioLogado();
		entity.setUsuarioAlteracao(usuarioLogado.getIdUsuario());
		
		repository.save(entity);
		
	}
}
