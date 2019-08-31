package br.com.crux.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.crux.entity.Departamentos;
import br.com.crux.entity.Unidade;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamentos, Long>{
	

	public List<Departamentos> findByUnidade(Unidade unidade);
	
	
}
