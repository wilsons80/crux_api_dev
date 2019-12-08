package br.com.crux.cmd;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BiPredicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.ColaboradoresProgramaTOBuilder;
import br.com.crux.dao.repository.ColaboradoresProgramaRepository;
import br.com.crux.entity.ColaboradoresPrograma;
import br.com.crux.entity.Programa;
import br.com.crux.to.ColaboradoresProgramaTO;

@Component
public class AlterarListaColaboradoresProgramaCmd {

	//	@Autowired private CamposObrigatoriosColaboradoresProgramaRule camposObrigatoriosColaboradoresProgramaRule;
	@Autowired private ColaboradoresProgramaTOBuilder colaboradoresProgramaTOBuilder;
	@Autowired private ColaboradoresProgramaRepository colaboradoresProgramaRepository;

	public void alterarAll(List<ColaboradoresProgramaTO> list, Programa programa) {

		// Lista Colaboradores do Projeto.
		List<ColaboradoresPrograma> listaColaboradoresPrograma = colaboradoresProgramaRepository.findByPrograma(programa).orElse(new ArrayList<ColaboradoresPrograma>());

		BiPredicate<ColaboradoresPrograma, List<ColaboradoresProgramaTO>> contemNaLista = (colaboradorProjeto, listaNova) -> listaNova.stream().anyMatch(novoColaborador -> Objects.nonNull(novoColaborador) && colaboradorProjeto.getId().equals(novoColaborador.getId()));

		//Remove do banco todos os itens que não contem na lista
		listaColaboradoresPrograma.removeIf(colaborador -> {
			if (!contemNaLista.test(colaborador, list)) {
				colaboradoresProgramaRepository.delete(colaborador);
				return true;
			}
			return false;
		});

		//Verificar por novas unidades cadastradas
		for (ColaboradoresProgramaTO colaborador : list) {
			Optional<ColaboradoresPrograma> findAny = listaColaboradoresPrograma.stream().filter(cp -> cp.getId() == colaborador.getId()).findAny();

			if (!findAny.isPresent()) {
				alterar(programa, colaborador);
			}
		}

	}

	private void alterar(Programa programa, ColaboradoresProgramaTO colaborador) {
		//		camposObrigatoriosColaboradoresProgramaRule.verificar(colaborador);
		ColaboradoresPrograma entity = colaboradoresProgramaTOBuilder.build(programa, colaborador);
		colaboradoresProgramaRepository.save(entity);
	}

}
