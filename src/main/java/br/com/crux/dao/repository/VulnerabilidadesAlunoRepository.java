package br.com.crux.dao.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.crux.entity.VulnerabilidadesAluno;

@Repository
public interface VulnerabilidadesAlunoRepository extends JpaRepository<VulnerabilidadesAluno, Long>{
	
	
	@Query(value = "SELECT v FROM VulnerabilidadesAluno v "
			+ " inner join Aluno a on a = v.aluno"
			+ " inner join Unidade uni on a.unidade = uni"
			+ " where uni.idUnidade = ?1")
	public Optional<List<VulnerabilidadesAluno>> findByUnidade(Long idUnidade);

	
}