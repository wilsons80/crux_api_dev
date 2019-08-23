package br.com.crux.dao.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.crux.entity.GruposModulo;
import br.com.crux.entity.UsuariosGrupo;
import br.com.crux.entity.UsuariosSistema;

@Repository
public interface UsuariosGrupoRepository extends JpaRepository<UsuariosGrupo, Long> {

	//@Modifying
	//@Query("DELETE FROM UsuariosGrupo WHERE id = ?1")
	//public int deleteByIdUsuarioGrupo(Long idUsuarioGrupo);
	
	
	public Optional<UsuariosGrupo> findByGruposModuloAndUsuariosSistema(GruposModulo grupoModulo, UsuariosSistema usuario);
}
