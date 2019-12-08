package br.com.crux.cmd;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.ComposicaoRhProgramaTOBuilder;
import br.com.crux.dao.repository.ComposicaoRhProgramaRepository;
import br.com.crux.entity.ComposicaoRhPrograma;
import br.com.crux.entity.Programa;
import br.com.crux.to.ComposicaoRhProgramaTO;

@Component
public class AlterarListaComposicaoRhProgramaCmd {

	//TODO Fazer as RULES
	//@Autowired private CamposObrigatoriosParceriasProgramaRule camposObrigatoriosParceriasProgramaRule;

	@Autowired private ComposicaoRhProgramaTOBuilder composicaoRhProgramaTOBuilder;
	@Autowired private ComposicaoRhProgramaRepository composicaoRhProgramaRepository;

	public void alterarAll(List<ComposicaoRhProgramaTO> list, Programa programa) {

		// Lista da unidades que o usuário tem acesso.
		List<ComposicaoRhPrograma> composicaoRhPrograma = composicaoRhProgramaRepository.findByPrograma(programa).orElse(new ArrayList<ComposicaoRhPrograma>());

		BiPredicate<ComposicaoRhPrograma, List<ComposicaoRhProgramaTO>> contemNaLista = (nova, lista) -> lista.stream().anyMatch(jaTinha -> Objects.nonNull(jaTinha.getId()) && jaTinha.getCargo().getId() == nova.getCargo().getId());

		// Remove da lista todos os registros que não contém no Banco de Dados
		composicaoRhPrograma.removeIf(registro -> {
			if (!contemNaLista.test(registro, list)) {
				composicaoRhProgramaRepository.delete(registro);
				return true;
			}
			return false;
		});

		// Adiciona os novos registros
		List<ComposicaoRhProgramaTO> novos = list.stream().filter(registro -> Objects.isNull(registro.getId())).collect(Collectors.toList());

		if (Objects.nonNull(novos)) {
			novos.forEach(novo -> alterar(programa, novo));
		}

	}

	private void alterar(Programa programa, ComposicaoRhProgramaTO novo) {
		//camposObrigatoriosParceriasProgramaRule.verificar(novo);
		ComposicaoRhPrograma entity = composicaoRhProgramaTOBuilder.build(programa, novo);
		composicaoRhProgramaRepository.save(entity);
	}

}
