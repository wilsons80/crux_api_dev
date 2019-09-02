package br.com.crux.dao.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.crux.entity.Programa;

@Repository
public interface ProgramaRepository extends JpaRepository<Programa, Long>{

	@Query(value = "SELECT pro FROM Programa pro"
			+ " inner join Iniciativa ini on pro.iniciativa = ini"
			+ " inner join Metas m on ini.meta = m"
			+ " inner join Indicadore i on m.indicadores = i"
			+ " inner join Objetivo o on i.objetivo = o"
			+ " inner join Perspectiva p on o.perspectiva.unidade = p.unidade "
			+ " where p.unidade.idUnidade = ?1")
	public Optional<List<Programa>> findByIdUnidade(Long idUnidade);

}
