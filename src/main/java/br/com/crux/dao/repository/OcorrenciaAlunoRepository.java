package br.com.crux.dao.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.crux.entity.OcorrenciaAluno;

@Repository
public interface OcorrenciaAlunoRepository extends JpaRepository<OcorrenciaAluno, Long>{
	
	@Query("select oa from OcorrenciaAluno oa "
			+ " inner join Aluno a on a.id = ao.aluno.id"
			+ " inner join Unidade u on u.idUnidade = a.unidade.idUnidade"
			+ " where u.idUnidade = ?1")
	Optional<List<OcorrenciaAluno>> findAllByUnidade(Long idUnidade);


}
