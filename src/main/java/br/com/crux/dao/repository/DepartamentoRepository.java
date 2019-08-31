package br.com.crux.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.crux.entity.Departamentos;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamentos, Long>{
	

	public List<Departamentos> findByIdUnidade(Long idUnidade);
	
	
}
