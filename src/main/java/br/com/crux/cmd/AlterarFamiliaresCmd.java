package br.com.crux.cmd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.FamiliaresTOBuilder;
import br.com.crux.dao.repository.FamiliaresRepository;
import br.com.crux.entity.Familiares;
import br.com.crux.exception.NotFoundException;
import br.com.crux.rule.CamposObrigatoriosFamiliaresRule;
import br.com.crux.to.FamiliaresTO;

@Component
public class AlterarFamiliaresCmd {

	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;
	@Autowired private FamiliaresRepository repository;
	@Autowired private CamposObrigatoriosFamiliaresRule camposObrigatoriosRule;
	@Autowired private FamiliaresTOBuilder familiaresTOBuilder;
	@Autowired private AlterarPessoaFisicaCmd alterarPessoaFisicaCmd;
	@Autowired private AlterarResponsaveisAlunoCmd alterarResponsaveisAlunoCmd;
	
	public FamiliaresTO alterar(FamiliaresTO to) {
		camposObrigatoriosRule.verificar(to);
		
		Familiares familiar = repository.findById(to.getId()).orElseThrow(() -> new NotFoundException("Familiar informado não existe."));
		
		to.setUsuarioAlteracao(getUsuarioLogadoCmd.getUsuarioLogado().getIdUsuario());
		familiar = familiaresTOBuilder.build(to);
		
		familiar.setPessoasFisica(alterarPessoaFisicaCmd.alterar(to.getPessoasFisica()));
		alterarResponsaveisAlunoCmd.alterar(to.getResponsaveis(), to);
		
		Familiares familiarSalvo = repository.save(familiar);
		return familiaresTOBuilder.buildTO(familiarSalvo);
	}
	
}
