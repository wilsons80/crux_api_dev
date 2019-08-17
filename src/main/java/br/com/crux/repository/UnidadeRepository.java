package br.com.crux.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.crux.entity.Unidade;

@Repository
public interface UnidadeRepository extends JpaRepository<Unidade, Long>{
	
	public Optional <Unidade>  findByCdUnidade(String cdUnidade);

}
