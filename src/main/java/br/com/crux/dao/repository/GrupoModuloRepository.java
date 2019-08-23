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
			+ " inner join PerfisAcesso perfil on perfil.idPerfilAcesso = grupo.perfisAcesso.idPerfilAcesso"
			+ "  where unidade.idUnidade = ?1 "
			+ "    and modulo.idModulo = ?2 "
			+ "    and perfil.idPerfilAcesso = ?3")
	public List<GruposModulo> findByUnidadeAndModuloAndPerfilAcesso(Long idUnidade, Long idModulo, Long idPerfilAcesso);

}
