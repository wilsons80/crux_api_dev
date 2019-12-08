package br.com.crux.cmd;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.MateriaisProjetoTOBuilder;
import br.com.crux.dao.repository.MateriaisProjetoRepository;
import br.com.crux.entity.MateriaisProjeto;
import br.com.crux.entity.Projeto;
import br.com.crux.to.MateriaisProjetoTO;

@Component
public class AlterarListaMateriaisProjetoCmd {

	//TODO Fazer as RULES
	//@Autowired private CamposObrigatoriosParceriasProjetoRule camposObrigatoriosParceriasProjetoRule;

	@Autowired private MateriaisProjetoTOBuilder materiaisProjetoTOBuilder;
	@Autowired private MateriaisProjetoRepository materiaisProjetoRepository;

	public void alterarAll(List<MateriaisProjetoTO> list, Projeto projeto) {

		// Lista da unidades que o usuário tem acesso.
		List<MateriaisProjeto> listaMateriaisProjeto = materiaisProjetoRepository.findByProjeto(projeto).orElse(new ArrayList<MateriaisProjeto>());

		BiPredicate<MateriaisProjeto, List<MateriaisProjetoTO>> contemNaLista = (nova, lista) -> lista.stream().anyMatch(jaTinha -> Objects.nonNull(jaTinha.getId()) && jaTinha.getId() == nova.getId());

		// Remove da lista todos os registros que não contém no Banco de Dados
		listaMateriaisProjeto.removeIf(registro -> {
			if (!contemNaLista.test(registro, list)) {
				materiaisProjetoRepository.delete(registro);
				return true;
			}
			return false;
		});

		// Adiciona os novos registros
		List<MateriaisProjetoTO> novos = list.stream().filter(registro -> Objects.isNull(registro.getId())).collect(Collectors.toList());

		if (Objects.nonNull(novos)) {
			novos.forEach(novo -> alterar(projeto, novo));
		}

	}

	private void alterar(Projeto projeto, MateriaisProjetoTO novo) {
		//camposObrigatoriosParceriasProjetoRule.verificar(novo);
		MateriaisProjeto entity = materiaisProjetoTOBuilder.build(projeto, novo);
		materiaisProjetoRepository.save(entity);
	}

}
