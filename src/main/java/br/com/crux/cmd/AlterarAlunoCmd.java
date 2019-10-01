package br.com.crux.cmd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.AlunoTOBuilder;
import br.com.crux.dao.repository.AlunoRepository;
import br.com.crux.entity.Aluno;
import br.com.crux.exception.NotFoundException;
import br.com.crux.rule.CamposObrigatoriosAlunoRule;
import br.com.crux.to.AlunoTO;

@Component
public class AlterarAlunoCmd {

	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;
	@Autowired private AlunoRepository repository;
	@Autowired private CamposObrigatoriosAlunoRule camposObrigatoriosRule;
	@Autowired private AlunoTOBuilder alunoTOBuilder;
	
	@Autowired private AlterarPessoaFisicaCmd alterarPessoaFisicaCmd;
	
	public AlunoTO alterar(AlunoTO to) {
		camposObrigatoriosRule.verificar(to);
		Aluno aluno = repository.findById(to.getId()).orElseThrow((() -> new NotFoundException("Aluno informado não existe.")));
		
		to.setUsuarioAlteracao(getUsuarioLogadoCmd.getUsuarioLogado().getIdUsuario());
		aluno = alunoTOBuilder.build(to);
		aluno.setPessoasFisica(alterarPessoaFisicaCmd.alterar(to.getPessoaFisica()));
		
	    Aluno alunoSalvo = repository.save(aluno);
		return alunoTOBuilder.buildTO(alunoSalvo);
	}
}
