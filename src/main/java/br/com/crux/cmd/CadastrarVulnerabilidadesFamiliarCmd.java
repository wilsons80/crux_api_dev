package br.com.crux.cmd;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.FamiliaresTOBuilder;
import br.com.crux.builder.SituacoesVulnerabilidadeTOBuilder;
import br.com.crux.builder.SolucoesTOBuilder;
import br.com.crux.dao.repository.VulnerabilidadesFamiliarRepository;
import br.com.crux.entity.VulnerabilidadesFamiliar;
import br.com.crux.exception.NotFoundException;
import br.com.crux.rule.CamposObrigatoriosVulnerabilidadesFamiliarRule;
import br.com.crux.to.UsuarioLogadoTO;
import br.com.crux.to.VulnerabilidadesFamiliarTO;

@Component
public class CadastrarVulnerabilidadesFamiliarCmd {

	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;
	
	@Autowired private VulnerabilidadesFamiliarRepository repository;
	@Autowired private CamposObrigatoriosVulnerabilidadesFamiliarRule camposObrigatoriosRule;
	
	@Autowired private SituacoesVulnerabilidadeTOBuilder situacoesVulnerabilidadeTOBuilder;
	@Autowired private SolucoesTOBuilder solucoesTOBuilder;
	@Autowired private FamiliaresTOBuilder familiaresTOBuilder;
	
	
	public void cadastrar(VulnerabilidadesFamiliarTO to) {
		if(Objects.isNull(to.getSituacoesVulnerabilidade())) {
			throw new NotFoundException("Vulnerabilidade não informada.");
		}
		if(Objects.isNull(to.getSolucoe())) {
			throw new NotFoundException("Solução não informada.");
		}
		if(Objects.isNull(to.getFamiliar())) {
			throw new NotFoundException("Familiar não informado.");
		}
		
		camposObrigatoriosRule.verificar(to.getDataIdentificacao(), to.getSituacoesVulnerabilidade().getId(), to.getSolucoe().getId(), to.getFamiliar().getId());
		
		VulnerabilidadesFamiliar entity = new VulnerabilidadesFamiliar();

		entity.setDataIdentificacao(to.getDataIdentificacao());
		entity.setDataSolucao(to.getDataSolucao());
		
		entity.setSituacoesVulnerabilidade(situacoesVulnerabilidadeTOBuilder.build(to.getSituacoesVulnerabilidade()));
		entity.setSolucoe(solucoesTOBuilder.build(to.getSolucoe()));
		entity.setFamiliar(familiaresTOBuilder.build(to.getFamiliar()));
		
		UsuarioLogadoTO usuarioLogado = getUsuarioLogadoCmd.getUsuarioLogado();
		entity.setUsuarioAlteracao(usuarioLogado.getIdUsuario());
		
		repository.save(entity);
		
	}
}
