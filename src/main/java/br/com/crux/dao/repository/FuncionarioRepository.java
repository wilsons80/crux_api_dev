package br.com.crux.dao.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.crux.entity.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{

	@Query(value = "SELECT f FROM Funcionario f inner join Unidade u on f.unidade = u"
			+ " where u.idUnidade = ?1")
	public Optional<List<Funcionario>> findAllByIdUnidade(Long idUnidade);

}
