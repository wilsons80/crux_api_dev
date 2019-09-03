package br.com.crux.dao.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.crux.entity.Projeto;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Long>{

	@Query(value = "SELECT proj FROM Projeto proj"
			+ " inner join Programa prog on proj.programa = prog"
			+ " inner join Iniciativa ini on prog.iniciativa = ini"
			+ " inner join Metas m on ini.meta = m"
			+ " inner join Indicadores i on m.indicadores = i"
			+ " inner join Objetivo o on i.objetivo = o"
			+ " inner join Perspectiva p on o.perspectiva.unidade = p.unidade "
			+ " where p.unidade.idUnidade = ?1")
	public Optional<List<Projeto>> findByIdUnidade(Long idUnidade);

}
