package br.com.crux.dao.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.crux.entity.Atividade;

@Repository
public interface AtividadeRepository extends JpaRepository<Atividade, Long>{
	
	
	@Query(value = "SELECT ati FROM Atividade ati"
			+ " inner join Unidade uni on ati.unidade = uni"
			+ " where uni.idUnidade = ?1")
	public Optional<List<Atividade>> findByIdUnidade(Long idUnidade);

	
	@Query(value = "SELECT ati FROM Atividade ati"
			+ " inner join Unidade uni on ati.unidade = uni"
			+ " where uni.idUnidade = ?1")
	public Optional<List<Atividade>> findAllUnidadeDoPrograma(Long idUnidade);
	
}
