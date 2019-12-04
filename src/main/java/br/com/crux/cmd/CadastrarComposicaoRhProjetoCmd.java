package br.com.crux.cmd;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.ComposicaoRhProjetoTOBuilder;
import br.com.crux.builder.ParceriasProjetoTOBuilder;
import br.com.crux.dao.repository.ComposicaoRhProjetoRepository;
import br.com.crux.dao.repository.ParceriasProjetoRepository;
import br.com.crux.entity.ParceriasProjeto;
import br.com.crux.entity.Projeto;
import br.com.crux.to.ComposicaoRhProjetoTO;
import br.com.crux.to.ParceriasProjetoTO;

@Component
public class CadastrarComposicaoRhProjetoCmd {

	@Autowired ComposicaoRhProjetoRepository composicaoRhProjetoRepository;
	@Autowired ComposicaoRhProjetoTOBuilder composicaoRhProjetoTOBuilder;

//	public ParceriasProjeto cadastrar(Projeto projeto, ComposicaoRhProjetoTO composicaoRhProjetoTO) {
//		ParceriasProjeto parceriasProjeto = composicaoRhProjetoTOBuilder.build(projeto, composicaoRhProjetoTO);
//		return composicaoRhProjetoRepository.save(parceriasProjeto);
//	}
//
//	public List<ParceriasProjeto> cadastrarLista(Projeto projeto, List<ParceriasProjetoTO> parceriasProjeto) {
//		return parceriasProjeto.stream().map(parceriaProjeto -> cadastrar(projeto, parceriaProjeto)).collect(Collectors.toList());
//
//	}

}
