package br.com.crux.dao.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.crux.entity.Dependentes;

@Repository
public interface DependentesRepository extends JpaRepository<Dependentes, Long>{
	
	@Query("select d from Dependentes d "
			+ " inner join Funcionario f on f.id = d.funcionario.id "
			+ " where f.id = ?1")
	Optional<List<Dependentes>> findAllByFuncionario(Long idFuncionario);
	
}
