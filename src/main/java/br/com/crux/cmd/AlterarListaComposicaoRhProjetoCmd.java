package br.com.crux.cmd;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.ComposicaoRhProjetoTOBuilder;
import br.com.crux.dao.repository.ComposicaoRhProjetoRepository;
import br.com.crux.entity.ComposicaoRhProjeto;
import br.com.crux.entity.Projeto;
import br.com.crux.to.ComposicaoRhProjetoTO;

@Component
public class AlterarListaComposicaoRhProjetoCmd {

	//TODO Fazer as RULES
	//@Autowired private CamposObrigatoriosParceriasProjetoRule camposObrigatoriosParceriasProjetoRule;

	@Autowired
	private ComposicaoRhProjetoTOBuilder composicaoRhProjetoTOBuilder;
	@Autowired
	private ComposicaoRhProjetoRepository composicaoRhProjetoRepository;

	public void alterarAll(List<ComposicaoRhProjetoTO> composicaoRhProjetoTO, Projeto projeto) {

		// Lista da unidades que o usuário tem acesso.
		List<ComposicaoRhProjeto> composicaoRhProjeto = composicaoRhProjetoRepository.findByProjeto(projeto).orElse(new ArrayList<ComposicaoRhProjeto>());

		BiPredicate<ComposicaoRhProjeto, List<ComposicaoRhProjetoTO>> contemNaLista = (nova, lista) -> lista.stream().anyMatch(
				jaTinha -> Objects.nonNull(jaTinha.getId()) && jaTinha.getId() == nova.getId());

		// Remove da lista todos os registros que não contém no Banco de Dados
		composicaoRhProjeto.removeIf(registro -> {
			if (!contemNaLista.test(registro, composicaoRhProjetoTO)) {
				composicaoRhProjetoRepository.delete(registro);
				return true;
			}
			return false;
		});

		// Adiciona os novos registros
		List<ComposicaoRhProjetoTO> novos = composicaoRhProjetoTO.stream().filter(registro -> Objects.isNull(registro.getId())).collect(Collectors.toList());

		if (Objects.nonNull(novos)) {
			novos.forEach(novo -> alterar(projeto, novo));
		}

	}

	private void alterar(Projeto projeto, ComposicaoRhProjetoTO novo) {
		//camposObrigatoriosParceriasProjetoRule.verificar(novo);
		ComposicaoRhProjeto entity = composicaoRhProjetoTOBuilder.build(projeto, novo);
		composicaoRhProjetoRepository.save(entity);
	}

}
