package br.com.crux.dao.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.crux.entity.AvaliacoesAlunos;

@Repository
public interface AvaliacoesAlunosRepository extends JpaRepository<AvaliacoesAlunos, Long>{
	
	
	@Query(value = "SELECT aa FROM AvaliacoesAlunos aa "
			+ " inner join AtividadesAluno ati on ati = aa.atividadesAluno"
			+ " inner join Aluno aluno on aluno = ati.aluno"
			+ " inner join Unidade uni on aluno.unidade = uni"
			+ " where uni.idUnidade = ?1")
	public Optional<List<AvaliacoesAlunos>> findByUnidade(Long idUnidade);

	
}
