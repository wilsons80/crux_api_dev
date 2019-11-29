package br.com.crux.cmd;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.UnidadeTOBuilder;
import br.com.crux.dao.repository.UnidadeRepository;
import br.com.crux.entity.Unidade;
import br.com.crux.to.UnidadeTO;

@Component
public class GetProjetosUnidadeCmd {

	@Autowired
	UnidadeRepository unidadeRepository;
	@Autowired
	UnidadeTOBuilder unidadeTOBuilder;

	public List<UnidadeTO> getUnidadesTOByIdProjeto(Long idProjeto) {
		List<Unidade> unidadesPorProjeto = unidadeRepository.getUnidadeByProjeto(idProjeto)
				.orElse(new ArrayList<Unidade>());

		return unidadeTOBuilder.buildAllTO(unidadesPorProjeto);

	}

}
