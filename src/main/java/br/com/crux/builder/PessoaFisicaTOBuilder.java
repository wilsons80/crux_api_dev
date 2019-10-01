package br.com.crux.builder;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.entity.PessoaFisica;
import br.com.crux.to.PessoaFisicaTO;


@Component
public class PessoaFisicaTOBuilder {
	
	@Autowired
	private GrausInstrucaoTOBuilder grausInstrucaoTOBuilder;
	@Autowired
	private CondicoesMoradiaTOBuilder condicoesMoradiaTOBuilder;
	

	public PessoaFisica build(PessoaFisicaTO p) {
		PessoaFisica retorno = new PessoaFisica();

		retorno.setId(p.getId());
		retorno.setNome(p.getNome());
		retorno.setOrgaoCi(p.getOrgaoCi());
		retorno.setClassificadorMotivoNaoTrab(p.getClassificadorMotivoNaoTrab());
		retorno.setDescricaoAlunoAtendidoOrgaoRede(p.getDescricaoAlunoAtendidoOrgaoRede());
		retorno.setDescricaoFamiliaAtendidoOrgaoRede(p.getDescricaoFamiliaAtendidoOrgaoRede());
		retorno.setBairro(p.getBairro());
		retorno.setCidadeNaturalidade(p.getCidadeNaturalidade());
		retorno.setCondicaoMoradia(p.getCondicaoMoradia());
		retorno.setCor(p.getCor());
		retorno.setCursoEscola(p.getCursoEscola());
		retorno.setEmail(p.getEmail());
		retorno.setEndereco(p.getEndereco());
		retorno.setEscola(p.getEscola());
		retorno.setEscolaridade(p.getEscolaridade());
		retorno.setEstadoCivil(p.getEstadoCivil());
		retorno.setFormaIngressoEntidade(p.getFormaIngressoEntidade());
		retorno.setMedicamentosControlados(p.getMedicamentosControlados());
		retorno.setMotivoNaoTrab(p.getMotivoNaoTrab());
		retorno.setNivelEscolaridade(p.getNivelEscolaridade());
		retorno.setOutrosBenSoc(p.getOutrosBenSoc());
		retorno.setPeriodoEscola(p.getPeriodoEscola());
		retorno.setPontoReferencia(p.getPontoReferencia());
		retorno.setProblemaSaude(p.getProblemaSaude());
		retorno.setProfissao(p.getProfissao());
		retorno.setRedeApSocRelev(p.getRedeApSocRelev());
		retorno.setRedeApoioSocial(p.getRedeApoioSocial());
		retorno.setRedeApoioSocial1(p.getRedeApoioSocial1());
		retorno.setRegiaoEscola(p.getRegiaoEscola());
		retorno.setSerieEscola(p.getSerieEscola());
		retorno.setSexo(p.getSexo());
		retorno.setSituacaoTrabalho(p.getSituacaoTrabalho());
		retorno.setTipoEscola(p.getTipoEscola());
		retorno.setTurno(p.getTurno());
		retorno.setDataNascimento(p.getDataNascimento());
		retorno.setNomeEmpresaTrabalho(p.getNomeEmpresaTrabalho());
		retorno.setNomeMae(p.getNomeMae());
		retorno.setNomePai(p.getNomePai());
		retorno.setCep(p.getCep());
		retorno.setIdentidade(p.getIdentidade());
		retorno.setCpf(p.getCpf());
		retorno.setCts(p.getCts());
		retorno.setCelular(p.getCelular());
		retorno.setNis(p.getNis());
		retorno.setSerieCtps(p.getSerieCtps());
		retorno.setSessaoTitulo(p.getSessaoTitulo());
		retorno.setTelefoneComercial(p.getTelefoneComercial());
		retorno.setTelefoneResidencial(p.getTelefoneResidencial());
		retorno.setTituloEleitor(p.getTituloEleitor());
		retorno.setZonaTitulo(p.getZonaTitulo());
		retorno.setUfCi(p.getUfCi());
		retorno.setUfEndereco(p.getUfEndereco());
		retorno.setUfNascimento(p.getUfNascimento());
		retorno.setStatusAtendidoOrgaoRede(p.getStatusAtendidoOrgaoRede());
		
		retorno.setAutorizaEmail(p.getAutorizaEmail().equals("true") ? "S" :"N");
		
		retorno.setBeneficiarioBolsaFamilia(p.getBeneficiarioBolsaFamilia());
		retorno.setObservacoes(p.getObservacoes());
		retorno.setValorAluguel(p.getValorAluguel());
		retorno.setValorBolsaFamilia(p.getValorBolsaFamilia());
		retorno.setValorOutrosBenerficiosSoc(p.getValorOutrosBenerficiosSoc());
		retorno.setValorRenda(p.getValorRenda());
		retorno.setIdArquivo(p.getIdArquivo());
		
		Optional.ofNullable(p.getCondicoesMoradia()).ifPresent(cm -> {
			retorno.setCondicoesMoradia(condicoesMoradiaTOBuilder.build(cm));
		});
		
		
		Optional.ofNullable(p.getGrausInstrucao()).ifPresent(gi -> {
			retorno.setGrausInstrucao(grausInstrucaoTOBuilder.build(gi));
		});
		
		retorno.setUsuarioAlteracao(p.getUsuarioAlteracao());
		
		
		return retorno;
	}

	
	public PessoaFisicaTO buildTO(PessoaFisica p) {
		PessoaFisicaTO retorno = new PessoaFisicaTO();
		
		retorno.setId(p.getId());
		retorno.setNome(p.getNome());
		retorno.setOrgaoCi(p.getOrgaoCi());
		retorno.setClassificadorMotivoNaoTrab(p.getClassificadorMotivoNaoTrab());
		retorno.setDescricaoAlunoAtendidoOrgaoRede(p.getDescricaoAlunoAtendidoOrgaoRede());
		retorno.setDescricaoFamiliaAtendidoOrgaoRede(p.getDescricaoFamiliaAtendidoOrgaoRede());
		retorno.setBairro(p.getBairro());
		retorno.setCidadeNaturalidade(p.getCidadeNaturalidade());
		retorno.setCondicaoMoradia(p.getCondicaoMoradia());
		retorno.setCor(p.getCor());
		retorno.setCursoEscola(p.getCursoEscola());
		retorno.setEmail(p.getEmail());
		retorno.setEndereco(p.getEndereco());
		retorno.setEscola(p.getEscola());
		retorno.setEscolaridade(p.getEscolaridade());
		retorno.setEstadoCivil(p.getEstadoCivil());
		retorno.setFormaIngressoEntidade(p.getFormaIngressoEntidade());
		retorno.setMedicamentosControlados(p.getMedicamentosControlados());
		retorno.setMotivoNaoTrab(p.getMotivoNaoTrab());
		retorno.setNivelEscolaridade(p.getNivelEscolaridade());
		retorno.setOutrosBenSoc(p.getOutrosBenSoc());
		retorno.setPeriodoEscola(p.getPeriodoEscola());
		retorno.setPontoReferencia(p.getPontoReferencia());
		retorno.setProblemaSaude(p.getProblemaSaude());
		retorno.setProfissao(p.getProfissao());
		retorno.setRedeApSocRelev(p.getRedeApSocRelev());
		retorno.setRedeApoioSocial(p.getRedeApoioSocial());
		retorno.setRedeApoioSocial1(p.getRedeApoioSocial1());
		retorno.setRegiaoEscola(p.getRegiaoEscola());
		retorno.setSerieEscola(p.getSerieEscola());
		retorno.setSexo(p.getSexo());
		retorno.setSituacaoTrabalho(p.getSituacaoTrabalho());
		retorno.setTipoEscola(p.getTipoEscola());
		retorno.setTurno(p.getTurno());
		retorno.setDataNascimento(p.getDataNascimento());
		retorno.setNomeEmpresaTrabalho(p.getNomeEmpresaTrabalho());
		retorno.setNomeMae(p.getNomeMae());
		retorno.setNomePai(p.getNomePai());
		retorno.setCep(p.getCep());
		retorno.setIdentidade(p.getIdentidade());
		retorno.setCpf(p.getCpf());
		retorno.setCts(p.getCts());
		retorno.setCelular(p.getCelular());
		retorno.setNis(p.getNis());
		retorno.setSerieCtps(p.getSerieCtps());
		retorno.setSessaoTitulo(p.getSessaoTitulo());
		retorno.setTelefoneComercial(p.getTelefoneComercial());
		retorno.setTelefoneResidencial(p.getTelefoneResidencial());
		retorno.setTituloEleitor(p.getTituloEleitor());
		retorno.setZonaTitulo(p.getZonaTitulo());
		retorno.setUfCi(p.getUfCi());
		retorno.setUfEndereco(p.getUfEndereco());
		retorno.setUfNascimento(p.getUfNascimento());
		retorno.setStatusAtendidoOrgaoRede(p.getStatusAtendidoOrgaoRede());
		retorno.setAutorizaEmail(p.getAutorizaEmail());
		retorno.setBeneficiarioBolsaFamilia(p.getBeneficiarioBolsaFamilia());
		retorno.setObservacoes(p.getObservacoes());
		retorno.setValorAluguel(p.getValorAluguel());
		retorno.setValorBolsaFamilia(p.getValorBolsaFamilia());
		retorno.setValorOutrosBenerficiosSoc(p.getValorOutrosBenerficiosSoc());
		retorno.setValorRenda(p.getValorRenda());
		retorno.setIdArquivo(p.getIdArquivo());
		
		Optional.ofNullable(p.getCondicoesMoradia()).ifPresent(cm -> {
			retorno.setCondicoesMoradia(condicoesMoradiaTOBuilder.buildTO(cm));
		});
		
		
		Optional.ofNullable(p.getGrausInstrucao()).ifPresent(gi -> {
			retorno.setGrausInstrucao(grausInstrucaoTOBuilder.buildTO(gi));
		});
		
		
		retorno.setUsuarioAlteracao(p.getUsuarioAlteracao());
		
		return retorno;
	}
	
	
	
	public List<PessoaFisicaTO> buildAll(List<PessoaFisica> dtos){
		return dtos.stream().map(dto -> buildTO(dto)).collect(Collectors.toList());
	}

}
