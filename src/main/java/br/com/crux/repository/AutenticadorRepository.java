package br.com.crux.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.crux.entity.UsuariosSistema;


@Repository
public interface AutenticadorRepository extends JpaRepository<UsuariosSistema, Long>{
	
	public Optional<UsuariosSistema> findByUsername(String userName);

}
