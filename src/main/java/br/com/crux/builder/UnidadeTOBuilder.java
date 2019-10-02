package br.com.crux.builder;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import br.com.crux.entity.Unidade;
import br.com.crux.enums.TipoUnidade;
import br.com.crux.to.UnidadeTO;

@Component
public class UnidadeTOBuilder {

	public Unidade build(UnidadeTO to) {
		Unidade unidade = new Unidade();

		unidade.setIdUnidade(to.getIdUnidade());
		unidade.setSiglaUnidade(to.getSiglaUnidade());
		unidade.setNomeUnidade(to.getNomeUnidade());
		unidade.setEndereco(to.getEndereco());
		unidade.setTelefone(to.getTelefone());
		unidade.setDescricaoSituacaoImovel(to.getDescricaoSituacaoImovel());
		unidade.setDescricaoEstruturaFisicaImovel(to.getDescricaoEstruturaFisicaImovel());
		unidade.setUsuarioAlteracao(to.getUsuarioAlteracao());
		unidade.setVisao(to.getVisao());
		unidade.setMissao(to.getMissao());
		unidade.setEmail(to.getEmail());
		unidade.setCep(to.getCep());
		unidade.setBairro(to.getBairro());
		unidade.setUf(to.getUf());
		unidade.setCelular(to.getCelular());
		unidade.setTipoUnidade(to.getTipoUnidade().getTipo());
		unidade.setClassificacaoSituacaoImovel(to.getClassificacaoSituacaoImovel());

		unidade.setNomeFantasia(to.getNomeFantasia());
		unidade.setCnpj(to.getCnpj());
		unidade.setInscricaoEstadual(to.getInscricaoEstadual());
		unidade.setInscricaoMunicipal(to.getInscricaoMunicipal());
		unidade.setHomePage(to.getHomePage());
		unidade.setCidade(to.getCidade());

		//unidade.setArquivo(to.getArquivo());

		return unidade;
	}

	public UnidadeTO buildTO(Unidade to) {
		UnidadeTO unidade = new UnidadeTO();

		if (Objects.isNull(to)) {
			return unidade;
		}

		unidade.setIdUnidade(to.getIdUnidade());
		unidade.setSiglaUnidade(to.getSiglaUnidade());
		unidade.setNomeUnidade(to.getNomeUnidade());
		unidade.setEndereco(to.getEndereco());
		unidade.setTelefone(to.getTelefone());
		unidade.setDescricaoSituacaoImovel(to.getDescricaoSituacaoImovel());
		unidade.setDescricaoEstruturaFisicaImovel(to.getDescricaoEstruturaFisicaImovel());
		unidade.setUsuarioAlteracao(to.getUsuarioAlteracao());
		unidade.setVisao(to.getVisao());
		unidade.setMissao(to.getMissao());
		unidade.setEmail(to.getEmail());
		unidade.setCep(to.getCep());
		unidade.setBairro(to.getBairro());
		unidade.setUf(to.getUf());
		unidade.setCelular(to.getCelular());
		unidade.setTipoUnidade(TipoUnidade.getPorTipo(to.getTipoUnidade()));
		unidade.setClassificacaoSituacaoImovel(to.getClassificacaoSituacaoImovel());

		unidade.setNomeFantasia(to.getNomeFantasia());
		unidade.setCnpj(to.getCnpj());
		unidade.setInscricaoEstadual(to.getInscricaoEstadual());
		unidade.setInscricaoMunicipal(to.getInscricaoMunicipal());
		unidade.setHomePage(to.getHomePage());
		unidade.setCidade(to.getCidade());

		//unidade.setArquivo(to.getArquivo());

		return unidade;
	}

	public List<UnidadeTO> buildAllTO(List<Unidade> dtos) {
		return dtos.stream().map(dto -> buildTO(dto)).collect(Collectors.toList());
	}

}
