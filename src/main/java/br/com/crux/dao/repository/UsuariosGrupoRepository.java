package br.com.crux.dao.repository;

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
}
