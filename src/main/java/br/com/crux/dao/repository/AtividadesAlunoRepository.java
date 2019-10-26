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

	
	@Query(value = "SELECT ati FROM AtividadesAluno ati "
			+ " inner join Aluno aluno on ati.aluno = aluno"
			+ " inner join Unidade uni on aluno.unidade = uni"
			+ " where aluno.id = ?1 "
			+ " and uni.idUnidade = ?2")
	public Optional<List<AtividadesAluno>> getByAluno(Long idAluno, Long idUnidade);

	@Query(value = "SELECT ati FROM AtividadesAluno ati "
			+ " inner join Atividades atividade on ati.atividade = atividade"
			+ " inner join Unidade uni on atividade.unidade = uni"
			+ " where atividade.id = ?1 "
			+ " and uni.idUnidade = ?2")
	public Optional<List<AtividadesAluno>> getByAtividade(Long idAtividade, Long idUnidade);

	@Query(value = "SELECT ati FROM AtividadesAluno ati "
			+ " inner join Atividades atividade on ati.atividade = atividade"
			+ " inner join Aluno aluno on ati.aluno = aluno"
			+ " inner join Unidade uni on atividade.unidade = uni"
			+ " where aluno.id = ?1 "
			+ " and atividade.id = ?2 "
			+ " and uni.idUnidade = ?3")
	public Optional<List<AtividadesAluno>> getByAlunoEAtividade(Long idAluno, Long idAtividade, Long idUnidade);


}
