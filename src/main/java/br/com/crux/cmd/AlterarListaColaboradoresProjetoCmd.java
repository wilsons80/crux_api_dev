package br.com.crux.cmd;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BiPredicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.ColaboradoresProjetoTOBuilder;
import br.com.crux.dao.repository.ColaboradoresProjetoRepository;
import br.com.crux.entity.ColaboradoresProjeto;
import br.com.crux.entity.Projeto;
import br.com.crux.rule.CamposObrigatoriosColaboradoresProjetoRule;
import br.com.crux.to.ColaboradoresProjetoTO;

@Component
public class AlterarListaColaboradoresProjetoCmd {

	@Autowired private CamposObrigatoriosColaboradoresProjetoRule camposObrigatoriosColaboradoresProjetoRule;
	@Autowired private ColaboradoresProjetoTOBuilder colaboradoresProjetoTOBuilder;
	@Autowired private ColaboradoresProjetoRepository colaboradoresProjetoRepository;

	public void alterarAll(List<ColaboradoresProjetoTO> listaAtualizadaDeColaboradores, Projeto projeto) {

		// Lista Colaboradores do Projeto.
		List<ColaboradoresProjeto> listaColaboradoresProjeto = colaboradoresProjetoRepository.findByProjeto(projeto).orElse(new ArrayList<ColaboradoresProjeto>());

		BiPredicate<ColaboradoresProjeto, List<ColaboradoresProjetoTO>> contemNaLista = (colaboradorProjeto, listaNova) -> 
		listaNova.stream().anyMatch(novoColaborador -> Objects.nonNull(novoColaborador) && colaboradorProjeto.getId().equals(novoColaborador.getId()));

		//Remove do banco todos os itens que não contem na lista
		listaColaboradoresProjeto.removeIf(colaborador -> {
			if (!contemNaLista.test(colaborador, listaAtualizadaDeColaboradores)) {
				colaboradoresProjetoRepository.delete(colaborador);
				return true;
			}
			return false;
		});


		//Verificar por novas unidades cadastradas
		for (ColaboradoresProjetoTO colaborador : listaAtualizadaDeColaboradores) {
			Optional<ColaboradoresProjeto> findAny = listaColaboradoresProjeto.stream().filter(cp -> cp.getId() == colaborador.getId()).findAny();
			
			if(!findAny.isPresent()) {
				alterar(projeto,colaborador);
			}
		}

	}

	private void alterar(Projeto projeto ,ColaboradoresProjetoTO colaborador) {
		camposObrigatoriosColaboradoresProjetoRule.verificar(colaborador);
		ColaboradoresProjeto entity = colaboradoresProjetoTOBuilder.build(projeto, colaborador);
		colaboradoresProjetoRepository.save(entity);
	}

}
