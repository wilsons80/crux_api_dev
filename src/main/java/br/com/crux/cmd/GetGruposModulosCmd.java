package br.com.crux.cmd;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.dao.repository.GrupoModuloRepository;
import br.com.crux.entity.GruposModulo;
import br.com.crux.exception.GruposModuloDuplicadoException;

@Component
public class GetGruposModulosCmd {

	@Autowired private GrupoModuloRepository grupoModuloRepository;
	
	
	public GruposModulo getGrupoModulo(Long idUnidade, Long idModulo, Long idPerfilAcesso) {
		List<GruposModulo> grupo = grupoModuloRepository.findByUnidadeAndModuloAndPerfilAcesso(
				                                                    idUnidade, 
				                                                    idModulo, 
				                                                    idPerfilAcesso);
		if(Objects.nonNull(grupo) && grupo.size() > 1) {
			throw new GruposModuloDuplicadoException("Há grupo modulo duplicado para essa unidade/modulo.");
		}

		return grupo.size() == 1 ? grupo.get(0) : null;
	}
}
