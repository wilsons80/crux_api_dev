package br.com.crux.builder;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.cmd.GetEmpresaCmd;
import br.com.crux.cmd.GetUsuarioLogadoCmd;
import br.com.crux.entity.Empresa;
import br.com.crux.entity.ParceriasProjeto;
import br.com.crux.entity.Projeto;
import br.com.crux.to.ComposicaoRhProjetoTO;
import br.com.crux.to.ParceriasProjetoTO;

@Component
public class ComposicaoRhProjetoTOBuilder {

	@Autowired GetUsuarioLogadoCmd getUsuarioLogadoCmd;
	@Autowired GetEmpresaCmd empresaCmd;
	@Autowired EmpresaTOBuilder empresaTOBuilder;
	@Autowired ProjetoTOBuilder projetoTOBuilder;

	public ParceriasProjeto build(Projeto projeto, ComposicaoRhProjetoTO composicaoRhProjetoTO) {

//		ParceriasProjeto parceriasProjeto = new ParceriasProjeto();
//
//		BeanUtils.copyProperties(composicaoRhProjetoTO, parceriasProjeto, "projeto", "empresa");
//
//		parceriasProjeto.setProjeto(projeto);
//		
//		if(Objects.nonNull(composicaoRhProjetoTO.getEmpresa()) && Objects.nonNull(composicaoRhProjetoTO.getEmpresa().getId())) {
//			Empresa e = empresaCmd.getById(composicaoRhProjetoTO.getEmpresa().getId());
//			parceriasProjeto.setEmpresa(e);
//		}
//
//		parceriasProjeto.setUsuarioAlteracao(getUsuarioLogadoCmd.getUsuarioLogado().getIdUsuario());

		return null;
	}

	public ParceriasProjetoTO buildTO(ParceriasProjeto parceriaProjeto) {

		ParceriasProjetoTO to = new ParceriasProjetoTO();

		BeanUtils.copyProperties(parceriaProjeto, to, "projeto", "empresa");
		
		to.setEmpresa(empresaTOBuilder.buildTO(parceriaProjeto.getEmpresa()));

		return to;
	}

	public List<ParceriasProjetoTO> buildAll(List<ParceriasProjeto> lista) {

		return lista.stream().map(this::buildTO).collect(Collectors.toList());
	}

}
