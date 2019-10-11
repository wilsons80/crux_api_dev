package br.com.crux.builder;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import br.com.crux.dao.dto.UsuarioUnidadeDTO;
import br.com.crux.entity.Unidade;
import br.com.crux.entity.UsuariosSistema;
import br.com.crux.entity.UsuariosUnidade;
import br.com.crux.to.UsuarioUnidadeTO;

@Component
public class UsuarioUnidadeTOBuilder {

	public UsuarioUnidadeTO buildTO(UsuarioUnidadeDTO dto) {
		UsuarioUnidadeTO to = new UsuarioUnidadeTO();
		to.setIdUsuario(dto.getIdUsuario());
		to.setIdPessoaFisica(dto.getIdPessoaFisica());
		to.setEmail(dto.getEmail());
		to.setNomeCompleto(dto.getNomeCompleto());

		return to;
	}

	public UsuariosUnidade build(UsuariosSistema usuariosSistema, Unidade unidade) {
		UsuariosUnidade entity = new UsuariosUnidade();
		entity.setUnidade(unidade);
		entity.setUsuariosSistema(usuariosSistema);
		return entity;
	}

	public List<UsuarioUnidadeTO> buildAll(List<UsuarioUnidadeDTO> dtos) {
		return dtos.stream().map(dto -> buildTO(dto)).collect(Collectors.toList());
	}

}
