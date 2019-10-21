package br.com.crux.cmd;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.GrupoModuloTOBuilder;
import br.com.crux.dao.repository.GrupoModuloRepository;
import br.com.crux.entity.GruposModulo;
import br.com.crux.exception.NotFoundException;
import br.com.crux.exception.ParametroNaoInformadoException;
import br.com.crux.to.GrupoModuloTO;

@Component
public class GetGruposModulosCmd {

	@Autowired private GrupoModuloRepository grupoModuloRepository;
	@Autowired private GrupoModuloTOBuilder grupoModuloTOBuilder;
	@Autowired private GetUnidadeLogadaCmd getUnidadeLogadaCmd;
	
	public List<GrupoModuloTO> getGrupoModulo(Long idUnidade, Long idModulo) {
		if(Objects.isNull(idUnidade)) {
			throw new ParametroNaoInformadoException("A unidade não foi informada.");
		}
		if(Objects.isNull(idModulo)) {
			throw new ParametroNaoInformadoException("O módulo não foi informado.");
		}
		
		Optional<List<GruposModulo>> grupos = grupoModuloRepository.findByUnidadeAndModulo(idUnidade, idModulo);
		return grupoModuloTOBuilder.buildAll(grupos.get());
	}
	
	
	public List<GrupoModuloTO> getAllUnidadeLogada() {
		Long idUnidade = getUnidadeLogadaCmd.get().getId();
		Optional<List<GruposModulo>> entitys = grupoModuloRepository.findByIdUnidade(idUnidade);
		if(entitys.isPresent()) {
			return grupoModuloTOBuilder.buildAll(entitys.get());
		}
		return new ArrayList<GrupoModuloTO>();
	}
	
	public GrupoModuloTO getTOById(Long id) {
		GruposModulo entity = grupoModuloRepository.findById(id).orElseThrow(() -> new NotFoundException("Grupo módulo não encontrado"));
		return grupoModuloTOBuilder.buildTO(entity);
	}

	public GruposModulo getById(Long id) {
		return grupoModuloRepository.findById(id).orElseGet(null);
		
	}	
	
}
