package br.com.crux.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.crux.entity.GruposModulo;

@Repository
public interface GrupoModuloRepository extends JpaRepository<GruposModulo, Long>{
	
	@Query(" SELECT grupo "
			+ " FROM GruposModulo grupo "
			+ " inner join Modulo modulo on grupo.modulo.idModulo = modulo.idModulo"
			+ " inner join Unidade unidade on unidade.idUnidade = grupo.unidade.idUnidade"
			+ "  where unidade.idUnidade     = ?1 "
			+ "    and modulo.idModulo       = ?2 ")
	public List<GruposModulo> findByUnidadeAndModulo(Long idUnidade, Long idModulo);

}
