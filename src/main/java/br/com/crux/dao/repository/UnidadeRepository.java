package br.com.crux.dao.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.crux.entity.Unidade;

@Repository
public interface UnidadeRepository extends JpaRepository<Unidade, Long>{
	
	public Optional<Unidade> findBySiglaUnidade(String cdUnidade);

	@Query(value = "SELECT u "
			     + "  FROM Unidade u inner join UsuariosUnidade uu on uu.unidade = u "
			     + " where uu.usuariosSistema.idUsuario = ?1")
	public Optional<List<Unidade>> findAllUnidadesDoUsuarioLogado(Long idUsuarioLogado);
}
