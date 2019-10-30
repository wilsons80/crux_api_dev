package br.com.crux.dao.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.crux.entity.ColaboradoresAtividade;

@Repository
public interface ColaboradoresAtividadeRepository extends JpaRepository<ColaboradoresAtividade, Long> {

	@Query(value = "SELECT ca FROM ColaboradoresAtividade ca " 
					+ " inner join Atividades a on ca.atividade = a" 
					+ " where a.id = ?1")
	public Optional<List<ColaboradoresAtividade>> getPorAtividade(Long id);
}
