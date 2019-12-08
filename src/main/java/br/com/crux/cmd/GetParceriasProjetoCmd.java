package br.com.crux.cmd;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.ParceriasProjetoTOBuilder;
import br.com.crux.dao.repository.ParceriasProjetoRepository;
import br.com.crux.entity.ParceriasProjeto;
import br.com.crux.entity.Projeto;
import br.com.crux.to.ParceriasProjetoTO;

@Component
public class GetParceriasProjetoCmd {

	@Autowired private ParceriasProjetoRepository repository;
	@Autowired private ParceriasProjetoTOBuilder toBuilder;

	public List<ParceriasProjetoTO> getColaboradoresProjetoTOByProjeto(Projeto projeto) {
		Optional<List<ParceriasProjeto>> lista = repository.findByProjeto(projeto);

		if (lista.isPresent()) {
			return toBuilder.buildAll(lista.get());
		}

		return Collections.emptyList();

	}
	
	public ParceriasProjeto get(Long id) {

		return repository.findById(id).orElse(null);
	}

}
