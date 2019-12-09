package br.com.crux.cmd;

import java.util.List;
import java.util.Objects;
import java.util.function.BiPredicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.dao.repository.ColaboradoresProjetoRepository;
import br.com.crux.entity.ColaboradoresProjeto;
import br.com.crux.to.ColaboradoresProjetoTO;

@Component
public class RemoverColaboradoresProjetoCasoNecessarioCmd {

	@Autowired
	private ColaboradoresProjetoRepository colaboradoresProjetoRepository;
	
	public void remover(List<ColaboradoresProjeto> listaColaboradoresProjeto,List<ColaboradoresProjetoTO> listaAtualizadaDeColaboradores) {
		
		BiPredicate<ColaboradoresProjeto, List<ColaboradoresProjetoTO>> contemNaLista = (colaboradorProjeto, listaNova) -> listaNova.stream().anyMatch(novoColaborador -> Objects.nonNull(novoColaborador) && colaboradorProjeto.getId().equals(novoColaborador.getId()));

		//Remove do banco todos os itens que não contem na lista
		listaColaboradoresProjeto.removeIf(colaborador -> {
			if (!contemNaLista.test(colaborador, listaAtualizadaDeColaboradores)) {
				colaboradoresProjetoRepository.delete(colaborador);
				return true;
			}
			return false;
		});
	}
}
