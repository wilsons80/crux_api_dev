package br.com.crux.cmd;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.dao.repository.GrupoModuloRepository;
import br.com.crux.dao.repository.UsuarioSistemaRepository;
import br.com.crux.dao.repository.UsuariosGrupoRepository;
import br.com.crux.entity.GruposModulo;
import br.com.crux.entity.UsuariosGrupo;
import br.com.crux.entity.UsuariosSistema;
import br.com.crux.exception.ParametroNaoInformadoException;

@Component
public class ExcluirGrupoModuloCmd {

	@Autowired private GrupoModuloRepository repository;
	@Autowired private UsuariosGrupoRepository usuariosGrupoRepository;
	@Autowired private UsuarioSistemaRepository usuarioSistemaRepository;
	
	
	public void excluir(Long idGrupoModulo, Long idUsuario) {
		if(Objects.isNull(idGrupoModulo)) {
			throw new ParametroNaoInformadoException("Erro ao excluir, parâmetro ausente.");
		}
		
		Optional<GruposModulo> grupoModulo = repository.findById(idGrupoModulo);
		Optional<UsuariosSistema> usuarioSistema = usuarioSistemaRepository.findById(idUsuario);
		
		
		Optional<UsuariosGrupo> usuariosGruposOptional = usuariosGrupoRepository.findByGruposModuloAndUsuariosSistema(grupoModulo.get(), usuarioSistema.get());
		if(usuariosGruposOptional.isPresent()) {
			usuariosGrupoRepository.delete(usuariosGruposOptional.get());
		}
		
		repository.deleteById(idGrupoModulo);
	}
}
