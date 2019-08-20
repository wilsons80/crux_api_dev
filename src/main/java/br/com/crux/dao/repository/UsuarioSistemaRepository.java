package br.com.crux.dao.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.crux.entity.UsuariosSistema;

@Repository
public interface UsuarioSistemaRepository extends JpaRepository<UsuariosSistema, Long>{
	
	
	public Optional<UsuariosSistema> findByUsername(String username);

}
