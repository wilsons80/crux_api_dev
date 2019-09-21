package br.com.crux.dao.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.crux.entity.EncaminhaAlunos;

@Repository
public interface EncaminhaAlunosRepository extends JpaRepository<EncaminhaAlunos, Long>{
	
	
	@Query(value = "SELECT e FROM EncaminhaAlunos e "
			+ " inner join Aluno a on a = e.aluno"
			+ " inner join Unidade uni on e.unidade = uni"
			+ " where uni.idUnidade = ?1")
	public Optional<List<EncaminhaAlunos>> findByUnidade(Long idUnidade);

	
}
