package br.com.crux.dao.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.crux.entity.GruposModulo;
import br.com.crux.entity.UsuariosGrupo;
import br.com.crux.entity.UsuariosSistema;

@Repository
public interface UsuariosGrupoRepository extends JpaRepository<UsuariosGrupo, Long> {

	public Optional<UsuariosGrupo> findByGruposModuloAndUsuariosSistema(GruposModulo grupoModulo, UsuariosSistema usuario);
	
	@Query(value = "SELECT ug FROM UsuariosGrupo ug "
			+ "inner join GruposModulo gm on ug.gruposModulo = gm "
			+ "inner join Modulo m on gm.modulo = m"
			+ " where m.idModulo = ?1")
	public Optional<UsuariosGrupo> getPorModulo(Long idModulo);
	
	
	@Query(value = "SELECT ug FROM UsuariosGrupo ug "
			+ " inner join UsuariosSistema us on us = ug.usuariosSistema"
			+ " inner join GruposModulo gm on gm = ug.gruposModulo"
			+ " inner join Modulo m on m = gm.modulo"
			+ "   where us.idUsuario  = ?1"
			+ "    and m.idModulo    = ?2")
	public Optional<List<UsuariosGrupo>> getPermissoes(Long idUsuario, Long idModulo);
	
	
	
}
