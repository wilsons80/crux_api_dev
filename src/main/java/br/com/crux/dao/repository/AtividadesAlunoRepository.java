package br.com.crux.dao.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.crux.entity.AtividadesAluno;

@Repository
public interface AtividadesAlunoRepository extends JpaRepository<AtividadesAluno, Long>{
	
	
	@Query(value = "SELECT ati FROM AtividadesAluno ati "
			+ " inner join Aluno aluno on aluno = ati.aluno"
			+ " inner join Unidade uni on aluno.unidade = uni"
			+ " where uni.idUnidade = ?1")
	public Optional<List<AtividadesAluno>> findByUnidade(Long idUnidade);

	
}
