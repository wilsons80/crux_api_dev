package br.com.crux.cmd;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.MateriaisProjetoTOBuilder;
import br.com.crux.dao.repository.MateriaisProjetoRepository;
import br.com.crux.entity.MateriaisProjeto;
import br.com.crux.entity.Projeto;
import br.com.crux.to.MateriaisProjetoTO;

@Component
public class GetMateriaisProjetoCmd {

	@Autowired private MateriaisProjetoRepository repository;
	@Autowired private MateriaisProjetoTOBuilder toBuilder;

	public List<MateriaisProjetoTO> getComposicaoRhProjetoByProjeto(Projeto projeto) {
		Optional<List<MateriaisProjeto>> lista = repository.findByProjeto(projeto);

		if (lista.isPresent()) {
			return toBuilder.buildAll(lista.get());
		}

		return Collections.emptyList();

	}

}
