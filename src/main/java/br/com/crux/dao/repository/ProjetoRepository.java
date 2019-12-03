package br.com.crux.dao.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.crux.entity.Projeto;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Long>{

	@Query(value = "SELECT p FROM Projeto p"
			+ " inner join ProjetosUnidade pu on pu.projeto = p "
			+ " where pu.unidade.idUnidade = :idUnidade")	
	public Optional<List<Projeto>> findByIdUnidade(Long idUnidade);

}
