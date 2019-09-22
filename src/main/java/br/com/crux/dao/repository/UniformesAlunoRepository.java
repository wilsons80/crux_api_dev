package br.com.crux.dao.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.crux.entity.UniformesAluno;

@Repository
public interface UniformesAlunoRepository extends JpaRepository<UniformesAluno, Long>{
	
	
	@Query(value = "SELECT u FROM UniformesAluno u "
			+ " inner join AtividadesAluno ati on ati = u.atividadesAluno"
			+ " inner join Aluno aluno on aluno = ati.aluno"
			+ " inner join Unidade uni on aluno.unidade = uni"
			+ " where uni.idUnidade = ?1")
	public Optional<List<UniformesAluno>> findByUnidade(Long idUnidade);

	
}
