package br.com.crux.cmd;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.ColaboradoresProgramaTOBuilder;
import br.com.crux.dao.repository.ColaboradoresProgramaRepository;
import br.com.crux.entity.ColaboradoresPrograma;
import br.com.crux.exception.NotFoundException;
import br.com.crux.to.ColaboradoresProgramaTO;

@Component
public class GetColaboradoresProgramaCmd {

	@Autowired private ColaboradoresProgramaRepository repository;
	@Autowired private ColaboradoresProgramaTOBuilder toBuilder;

	public ColaboradoresProgramaTO getById(Long id) {
		ColaboradoresPrograma entity = repository.findById(id).orElseThrow(() -> new NotFoundException("Colaborador do Programa não encontrado."));
		return toBuilder.buildTO(entity);
	}

	public List<ColaboradoresProgramaTO> getPorPrograma(Long id) {
		List<ColaboradoresPrograma> lista = repository.getPorPrograma(id).orElseThrow(() -> new NotFoundException("Colaborador do Programa não encontrado."));
		return toBuilder.buildAll(lista);
	}

}
