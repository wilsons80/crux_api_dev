package br.com.crux.dao.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.crux.entity.ColaboradoresProjeto;

@Repository
public interface ColaboradoresProjetoRepository extends JpaRepository<ColaboradoresProjeto, Long>{

	@Query(value = "SELECT col FROM ColaboradoresProjeto col"
			+ " inner join Projeto proj on col.projeto = proj"
			+ " inner join Programa pro on proj.programa = pro"
			+ " inner join Iniciativa ini on pro.iniciativa = ini"
			+ " inner join Metas m on ini.meta = m"
			+ " inner join Indicadores i on m.indicadores = i"
			+ " inner join Objetivo o on i.objetivo = o"
			+ " inner join Perspectiva p on o.perspectiva.unidade = p.unidade "
			+ " where p.unidade.idUnidade = ?1")
	public Optional<List<ColaboradoresProjeto>> findByIdUnidade(Long idUnidade);

}
