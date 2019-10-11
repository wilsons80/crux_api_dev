package br.com.crux.cmd;

import java.time.LocalDateTime;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.AlunoTOBuilder;
import br.com.crux.builder.UnidadeTOBuilder;
import br.com.crux.dao.repository.AlunoRepository;
import br.com.crux.entity.Aluno;
import br.com.crux.entity.Unidade;
import br.com.crux.exception.NotFoundException;
import br.com.crux.rule.CamposObrigatoriosAlunoRule;
import br.com.crux.to.AlunoTO;

@Component
public class CadastrarAlunoCmd {

	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;
	@Autowired private AlunoRepository repository;
	@Autowired private CamposObrigatoriosAlunoRule camposObrigatoriosRule;
	@Autowired private AlunoTOBuilder alunoTOBuilder;
	@Autowired private CadastrarPessoaFisicaCmd cadastrarPessoaFisicaCmd;
	
	@Autowired private GetUnidadeCmd getUnidadeCmd;
	@Autowired private UnidadeTOBuilder unidadeTOBuilder;
	
	public AlunoTO cadastrar(AlunoTO to) {
		camposObrigatoriosRule.verificar(to);
		
		Unidade unidade = getUnidadeCmd.getById(to.getUnidade().getIdUnidade());
		if(Objects.isNull(unidade)) {
			throw new NotFoundException("Unidade informada não existe");
		}
		to.setUnidade(unidadeTOBuilder.buildTO(unidade));
		
		to.setDataCadastro(LocalDateTime.now());
		to.setUsuarioAlteracao(getUsuarioLogadoCmd.getUsuarioLogado().getIdUsuario());
		Aluno entity = alunoTOBuilder.build(to);
		
		entity.setPessoasFisica(cadastrarPessoaFisicaCmd.cadastrar(to.getPessoaFisica()));
		
		Aluno aluno = repository.save(entity);
		return alunoTOBuilder.buildTO(aluno);
	}
}
