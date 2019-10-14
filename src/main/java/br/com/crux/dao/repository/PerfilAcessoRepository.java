package br.com.crux.dao.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.crux.entity.PerfisAcesso;

@Repository
public interface PerfilAcessoRepository extends JpaRepository<PerfisAcesso, Long>{
	
	@Query(value = "SELECT p FROM PerfisAcesso p "
			+ " where p.consulta = true "
			+ "  and p.deleta = false "
			+ "  and p.insere = false "
			+ "  and p.altera = false ")
	public Optional<PerfisAcesso> getPerfilApenasConsulta();

}
