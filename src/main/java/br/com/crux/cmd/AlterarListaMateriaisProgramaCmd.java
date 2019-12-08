package br.com.crux.cmd;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.MateriaisProgramaTOBuilder;
import br.com.crux.dao.repository.MateriaisProgramaRepository;
import br.com.crux.entity.MateriaisPrograma;
import br.com.crux.entity.Programa;
import br.com.crux.to.MateriaisProgramaTO;

@Component
public class AlterarListaMateriaisProgramaCmd {

	//TODO Fazer as RULES
	//@Autowired private CamposObrigatoriosParceriasProgramaRule camposObrigatoriosParceriasProgramaRule;

	@Autowired private MateriaisProgramaTOBuilder materiaisProgramaTOBuilder;
	@Autowired private MateriaisProgramaRepository materiaisProgramaRepository;

	public void alterarAll(List<MateriaisProgramaTO> list, Programa programa) {

		// Lista da unidades que o usuário tem acesso.
		List<MateriaisPrograma> listaMateriaisPrograma = materiaisProgramaRepository.findByPrograma(programa).orElse(new ArrayList<MateriaisPrograma>());

		BiPredicate<MateriaisPrograma, List<MateriaisProgramaTO>> contemNaLista = (nova, lista) -> lista.stream().anyMatch(jaTinha -> Objects.nonNull(jaTinha.getId()) && jaTinha.getId() == nova.getId());

		// Remove da lista todos os registros que não contém no Banco de Dados
		listaMateriaisPrograma.removeIf(registro -> {
			if (!contemNaLista.test(registro, list)) {
				materiaisProgramaRepository.delete(registro);
				return true;
			}
			return false;
		});

		// Adiciona os novos registros
		List<MateriaisProgramaTO> novos = list.stream().filter(registro -> Objects.isNull(registro.getId())).collect(Collectors.toList());

		if (Objects.nonNull(novos)) {
			novos.forEach(novo -> alterar(programa, novo));
		}

	}

	private void alterar(Programa programa, MateriaisProgramaTO novo) {
		//camposObrigatoriosParceriasProgramaRule.verificar(novo);
		MateriaisPrograma entity = materiaisProgramaTOBuilder.build(programa, novo);
		materiaisProgramaRepository.save(entity);
	}

}
