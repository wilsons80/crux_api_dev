package br.com.crux.dao.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.crux.entity.Objetivo;
import br.com.crux.entity.Unidade;

@Repository
public interface ObjetivoRepository extends JpaRepository<Objetivo, Long>{

	public Optional<List<Objetivo>> findByUnidade(Unidade unidade);

}
