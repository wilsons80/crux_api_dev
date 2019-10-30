package br.com.crux.cmd;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.ColaboradoresAtividadeTOBuilder;
import br.com.crux.dao.repository.ColaboradoresAtividadeRepository;
import br.com.crux.entity.ColaboradoresAtividade;
import br.com.crux.to.ColaboradoresAtividadeTO;

@Component
public class GetColaboradoresAtividadeCmd {

		@Autowired private ColaboradoresAtividadeRepository repository;
		@Autowired private ColaboradoresAtividadeTOBuilder toBuilder;

	public List<ColaboradoresAtividadeTO> getPorAtividade(Long id) {
				List<ColaboradoresAtividade> lista = repository.getPorAtividade(id).orElse(Collections.emptyList());
				return toBuilder.buildAll(lista);

	}

}
