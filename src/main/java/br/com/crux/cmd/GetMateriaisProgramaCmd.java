package br.com.crux.cmd;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.MateriaisProgramaTOBuilder;
import br.com.crux.dao.repository.MateriaisProgramaRepository;
import br.com.crux.entity.MateriaisPrograma;
import br.com.crux.entity.Programa;
import br.com.crux.to.MateriaisProgramaTO;

@Component
public class GetMateriaisProgramaCmd {

	@Autowired private MateriaisProgramaRepository repository;
	@Autowired private MateriaisProgramaTOBuilder toBuilder;

	public List<MateriaisProgramaTO> getComposicaoRhProgramaByPrograma(Programa param) {
		Optional<List<MateriaisPrograma>> lista = repository.findByPrograma(param);

		if (lista.isPresent()) {
			return toBuilder.buildAll(lista.get());
		}

		return Collections.emptyList();

	}

}
