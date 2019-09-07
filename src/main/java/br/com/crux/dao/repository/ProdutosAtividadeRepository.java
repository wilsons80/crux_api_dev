package br.com.crux.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.crux.entity.ProdutosAtividade;

@Repository
public interface ProdutosAtividadeRepository extends JpaRepository<ProdutosAtividade, Long>{
	

	
}
