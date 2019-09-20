package br.com.crux.cmd;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.PessoaFisicaTOBuilder;
import br.com.crux.builder.UnidadeTOBuilder;
import br.com.crux.dao.repository.AlunoRepository;
import br.com.crux.dao.repository.PessoaFisicaRepository;
import br.com.crux.dao.repository.UnidadeRepository;
import br.com.crux.entity.Aluno;
import br.com.crux.entity.PessoaFisica;
import br.com.crux.entity.Unidade;
import br.com.crux.exception.NotFoundException;
import br.com.crux.rule.CamposObrigatoriosAlunoRule;
import br.com.crux.to.AlunoTO;
import br.com.crux.to.UsuarioLogadoTO;

@Component
public class AlterarAlunoCmd {

	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;
	@Autowired private AlunoRepository repository;
	@Autowired private CamposObrigatoriosAlunoRule camposObrigatoriosRule;
	
	@Autowired private UnidadeRepository unidadeRepository;
	@Autowired private UnidadeTOBuilder unidadeBuilder;
	@Autowired private PessoaFisicaRepository pessoaFisicaRepository;
	@Autowired private PessoaFisicaTOBuilder pessoaFisicaBuilder;
	
	
	public void alterar(AlunoTO to) {
		Optional<Aluno> entityOptional = repository.findById(to.getId());
		if(!entityOptional.isPresent()) {
			throw new NotFoundException("Aluno informado não existe.");
		}
		
		if(Objects.isNull(to.getUnidade())) {
			throw new NotFoundException("Unidade não informada.");
		}
		if(Objects.isNull(to.getPessoaFisica())) {
			throw new NotFoundException("Pessoa Fisica não informada.");
		}
		
		camposObrigatoriosRule.verificar(to.getDataCadastro(), to.getMatriculaAluno(), to.getUnidade().getIdUnidade(), to.getPessoaFisica().getId());
		
		Optional<Unidade> unidadeOptional = unidadeRepository.findById(to.getUnidade().getIdUnidade());
		if(!unidadeOptional.isPresent()) {
			throw new NotFoundException("Unidade informada não existe.");
		}

		Optional<PessoaFisica> pessoaFisicaOptional = pessoaFisicaRepository.findById(to.getPessoaFisica().getId());
		if(!pessoaFisicaOptional.isPresent()) {
			throw new NotFoundException("Pessoa Fisica informada não existe.");
		}
		
		
		Aluno entity = entityOptional.get();

		entity.setDescProblemaSaude(to.getDescProblemaSaude());
		entity.setDescMedicamentosControlados(to.getDescMedicamentosControlados());
		entity.setDescOutrasInformacoes(to.getDescOutrasInformacoes());
		entity.setDescFormaIngressoEntidade(to.getDescFormaIngressoEntidade());
		entity.setAtendidoOrgaoRede(to.getAtendidoOrgaoRede());
		entity.setDataEntrada(to.getDataEntrada());
		entity.setObservacoes(to.getObservacoes());
		entity.setDataDesligamento(to.getDataDesligamento());
		entity.setDescDesligamento(to.getDescDesligamento());
		entity.setPessoasFisica(pessoaFisicaBuilder.build(to.getPessoaFisica()));
		entity.setUnidade(unidadeBuilder.build(to.getUnidade()));
		entity.setDataCadastro(to.getDataCadastro()); 
		entity.setDataAlteracaoCadastro(to.getDataAlteracaoCadastro());
		entity.setMoraPais(to.getMoraPais());
		entity.setPaisCasados(to.getPaisCasados());
		entity.setMatriculadoEscPub(to.getMatriculadoEscPub());
		entity.setDescBuscaEscola(to.getDescBuscaEscola());
		entity.setPublicoPrioritario(to.getPublicoPrioritario());
		entity.setMatriculaAluno(to.getMatriculaAluno());
		
		UsuarioLogadoTO usuarioLogado = getUsuarioLogadoCmd.getUsuarioLogado();
		entity.setUsuarioAlteracao(usuarioLogado.getIdUsuario());
		
		repository.save(entity);
		
	}
}
