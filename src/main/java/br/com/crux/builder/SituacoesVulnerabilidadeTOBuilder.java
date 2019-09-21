package br.com.crux.builder;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import br.com.crux.entity.SituacoesVulnerabilidade;
import br.com.crux.to.SituacoesVulnerabilidadeTO;

@Component
public class SituacoesVulnerabilidadeTOBuilder {

	public SituacoesVulnerabilidade build(SituacoesVulnerabilidadeTO p) {
		SituacoesVulnerabilidade retorno = new SituacoesVulnerabilidade();

		retorno.setId(p.getId());
		retorno.setDescricao(p.getDescricao());
		retorno.setUsuarioAlteracao(p.getUsuarioAlteracao());

		return retorno;
	}

	public SituacoesVulnerabilidadeTO buildTO(SituacoesVulnerabilidade p) {
		SituacoesVulnerabilidadeTO retorno = new SituacoesVulnerabilidadeTO();
		
		retorno.setId(p.getId());
		retorno.setDescricao(p.getDescricao());
		retorno.setUsuarioAlteracao(p.getUsuarioAlteracao());

		return retorno;
	}

	public List<SituacoesVulnerabilidadeTO> buildAll(List<SituacoesVulnerabilidade> dtos) {
		return dtos.stream().map(dto -> buildTO(dto)).collect(Collectors.toList());
	}

}
