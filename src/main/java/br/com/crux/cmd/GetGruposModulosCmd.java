package br.com.crux.cmd;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.GrupoModuloTOBuilder;
import br.com.crux.dao.repository.GrupoModuloRepository;
import br.com.crux.entity.GruposModulo;
import br.com.crux.exception.ParametroNaoInformadoException;
import br.com.crux.to.GrupoModuloTO;

@Component
public class GetGruposModulosCmd {

	@Autowired private GrupoModuloRepository grupoModuloRepository;
	@Autowired private GrupoModuloTOBuilder grupoModuloTOBuilder;
	
	public List<GrupoModuloTO> getGrupoModulo(Long idUnidade, Long idModulo) {
		if(Objects.isNull(idUnidade)) {
			throw new ParametroNaoInformadoException("A unidade não foi informada.");
		}
		if(Objects.isNull(idModulo)) {
			throw new ParametroNaoInformadoException("O módulo não foi informado.");
		}
		
		List<GruposModulo> grupos = grupoModuloRepository.findByUnidadeAndModulo(idUnidade, idModulo);
		return grupoModuloTOBuilder.buildAll(grupos);
	}
}
