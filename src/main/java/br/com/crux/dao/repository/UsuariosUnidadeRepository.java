package br.com.crux.dao.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.crux.entity.UsuariosSistema;
import br.com.crux.entity.UsuariosUnidade;

@Repository
public interface UsuariosUnidadeRepository extends JpaRepository<UsuariosUnidade, Long> {

	public Optional<List<UsuariosUnidade>> findByUsuariosSistema(UsuariosSistema usuario);

	public void deleteByUsuariosSistema(UsuariosSistema usuariosSistema);

}
