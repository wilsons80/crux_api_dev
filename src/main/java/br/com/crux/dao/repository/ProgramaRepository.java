package br.com.crux.dao.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.crux.entity.Programa;

@Repository
public interface ProgramaRepository extends JpaRepository<Programa, Long>{

	@Query(value = "SELECT p FROM Programa p"
			+ " inner join Unidade u on p.unidade = u "
			+ " where u.idUnidade = ?1")
	public Optional<List<Programa>> findByIdUnidade(Long idUnidade);

}
