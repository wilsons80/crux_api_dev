package br.com.crux.dao.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.crux.entity.GruposModulo;
import br.com.crux.entity.Unidade;

@Repository
public interface GrupoModuloRepository extends JpaRepository<GruposModulo, Long>{
	
	
	public Optional<List<GruposModulo>> findByUnidade(Unidade unidade);

	
	@Query(" SELECT grupo "
			+ " FROM GruposModulo grupo "
			+ " inner join Modulo modulo on grupo.modulo.idModulo = modulo.idModulo"
			+ " inner join Unidade unidade on unidade.idUnidade = grupo.unidade.idUnidade"
			+ "  where unidade.idUnidade     = ?1 "
			+ "    and modulo.idModulo       = ?2 ")
	public List<GruposModulo> findByUnidadeAndModulo(Long idUnidade, Long idModulo);

	@Query("SELECT gm FROM GruposModulo gm "
			+ " inner join Modulo modulo on modulo = gm.modulo "
			+ " inner join PerfisAcesso pa on pa = gm.perfisAcesso "
			+ " inner join Unidade u on u = gm.unidade"
			+ " where u.idUnidade = ?3 "
			+ "   and modulo.idModulo = ?1 "
			+ "   and pa.idPerfilAcesso = ?2")
	public Optional<GruposModulo> findByIdModuloAndIdPerfilAcessoAndIdUnidade(Long idModulo, Long idPerfilAcesso, Long idUnidade);
}
