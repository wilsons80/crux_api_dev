package br.com.crux.cmd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.PessoaFisicaTOBuilder;
import br.com.crux.dao.repository.PessoaFisicaRepository;
import br.com.crux.entity.PessoaFisica;
import br.com.crux.exception.NotFoundException;
import br.com.crux.rule.CamposObrigatoriosPessoaFisicaRule;
import br.com.crux.to.PessoaFisicaTO;

@Component
public class AlterarPessoaFisicaCmd {

	@Autowired
	private PessoaFisicaRepository repository;
	@Autowired
	private CamposObrigatoriosPessoaFisicaRule camposObrigatoriosPessoaFisicaRule;
	@Autowired
	private PessoaFisicaTOBuilder pessoaFisicaTOBuilder;

	public PessoaFisica alterar(PessoaFisicaTO to) {
		PessoaFisica pessoaFisica = repository.findById(to.getId())
				.orElseThrow(() -> new NotFoundException("Pessoa Física não encontrada."));
		camposObrigatoriosPessoaFisicaRule.verificar(to.getNome(), to.getCpf(), to.getEndereco(), to.getCelular());
		pessoaFisica = pessoaFisicaTOBuilder.build(to);
		return repository.save(pessoaFisica);
	}
}
