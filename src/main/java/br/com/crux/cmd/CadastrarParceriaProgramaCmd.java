package br.com.crux.cmd;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.ParceriasProgramaTOBuilder;
import br.com.crux.dao.repository.ParceriasProgramaRepository;
import br.com.crux.entity.ParceriasPrograma;
import br.com.crux.entity.Programa;
import br.com.crux.to.ParceriasProgramaTO;

@Component
public class CadastrarParceriaProgramaCmd {

	@Autowired ParceriasProgramaRepository parceriasProgramaRepository;
	@Autowired ParceriasProgramaTOBuilder parceriasProgramaTOBuilder;

	public ParceriasPrograma cadastrar(Programa programa, ParceriasProgramaTO parceriaPrograma) {
		ParceriasPrograma parceriasPrograma = parceriasProgramaTOBuilder.build(programa, parceriaPrograma);
		return parceriasProgramaRepository.save(parceriasPrograma);
	}

	public List<ParceriasPrograma> cadastrarLista(Programa programa, List<ParceriasProgramaTO> parceriasPrograma) {
		return parceriasPrograma.stream().map(parceriaPrograma -> cadastrar(programa, parceriaPrograma)).collect(Collectors.toList());

	}

}
