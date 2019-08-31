package br.com.crux.dao.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.crux.entity.Perspectiva;
import br.com.crux.entity.Unidade;

@Repository
public interface PerspectivaRepository extends JpaRepository<Perspectiva, Long>{

	public Optional<List<Perspectiva>> findByUnidade(Unidade unidade);
	

}
