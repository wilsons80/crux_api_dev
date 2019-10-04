package br.com.crux.builder;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.entity.UsuariosSistema;
import br.com.crux.to.UsuariosSistemaTO;


@Component
public class UsuariosSistemaTOBuilder {
	
	@Autowired private PessoaFisicaTOBuilder pessoaFisicaTOBuilder;
	

	public UsuariosSistema build(UsuariosSistemaTO p) {
		UsuariosSistema retorno = new UsuariosSistema();

		retorno.setIdUsuario(p.getIdUsuario());
		retorno.setUsername(p.getNomeUsuario());
		retorno.setDescFimVigenciaUsuario(p.getDescFimVigenciaUsuario());
		retorno.setSenha(p.getSenhaUsuario());
		retorno.setDataFimVigencia(p.getDataFimVigencia());
		retorno.setDataInicioVigencia(p.getDataInicioVigencia());
		retorno.setDataUltimoAcesso(p.getDataUltimoAcesso());
		retorno.setQtdAcessoNegado(p.getQtdAcessoNegado());
		retorno.setStAtivo(p.getStAtivo());
		retorno.setStTrocaSenha(p.getStTrocaSenha());
		retorno.setPessoaFisica(pessoaFisicaTOBuilder.build(p.getPessoaFisica()));
		retorno.setUsuarioAlteracao(p.getUsuarioAlteracao());

		return retorno;
	}

	public UsuariosSistemaTO buildTO(UsuariosSistema p) {
		UsuariosSistemaTO retorno = new UsuariosSistemaTO();
		
		retorno.setIdUsuario(p.getIdUsuario());
		retorno.setNomeUsuario(p.getUsername());
		retorno.setDescFimVigenciaUsuario(p.getDescFimVigenciaUsuario());
		retorno.setSenhaUsuario(p.getSenha());
		retorno.setDataFimVigencia(p.getDataFimVigencia());
		retorno.setDataInicioVigencia(p.getDataInicioVigencia());
		retorno.setDataUltimoAcesso(p.getDataUltimoAcesso());
		retorno.setQtdAcessoNegado(p.getQtdAcessoNegado());
		retorno.setStAtivo(p.getStAtivo());
		retorno.setStTrocaSenha(p.getStTrocaSenha());
		retorno.setPessoaFisica(pessoaFisicaTOBuilder.buildTO(p.getPessoaFisica()));
		retorno.setUsuarioAlteracao(p.getUsuarioAlteracao());

		return retorno;
	}

	public List<UsuariosSistemaTO> buildAll(List<UsuariosSistema> dtos) {
		return dtos.stream().map(dto -> buildTO(dto)).collect(Collectors.toList());
	}
	
}
