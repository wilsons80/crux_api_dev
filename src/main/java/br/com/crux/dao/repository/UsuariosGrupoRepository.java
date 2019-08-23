package br.com.crux.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.crux.entity.UsuariosGrupo;

@Repository
public interface UsuariosGrupoRepository extends JpaRepository<UsuariosGrupo, Long> {

	//@Modifying
	//@Query("DELETE FROM UsuariosGrupo WHERE id = ?1")
	//public int deleteByIdUsuarioGrupo(Long idUsuarioGrupo);
}
