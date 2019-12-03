package br.com.crux.dao.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.crux.entity.ColaboradoresPrograma;

@Repository
public interface ColaboradoresProgramaRepository extends JpaRepository<ColaboradoresPrograma, Long> {

//	@Query(value = "SELECT col FROM ColaboradoresPrograma col" 
//			+ " inner join Programa pro on col.programa = pro" 
//			+ " inner join Unidade u on pro.unidade = u" 
//			+ " where u.idUnidade = :idUnidade")
//	public Optional<List<ColaboradoresPrograma>> findByIdUnidade(Long idUnidade);

	@Query(value = "SELECT cp FROM ColaboradoresPrograma cp " 
			+ " inner join Programa p on cp.programa = p" 
			+ " where p.id = ?1")
	public Optional<List<ColaboradoresPrograma>> getPorPrograma(Long id);

}
