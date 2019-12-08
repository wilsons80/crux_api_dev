package br.com.crux.cmd;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.ParceriasProgramaTOBuilder;
import br.com.crux.dao.repository.ParceriasProgramaRepository;
import br.com.crux.entity.ParceriasPrograma;
import br.com.crux.entity.Programa;
import br.com.crux.to.ParceriasProgramaTO;

@Component
public class AlterarParceriasProgramaCmd {

	//	@Autowired private CamposObrigatoriosParceriasProgramaRule camposObrigatoriosParceriasProgramaRule;
	@Autowired private ParceriasProgramaTOBuilder parceriasProgramaTOBuilder;
	@Autowired private ParceriasProgramaRepository parceriasProgramaRepository;

	public void alterarAll(List<ParceriasProgramaTO> list, Programa programa) {

		// Lista da unidades que o usuário tem acesso.
		List<ParceriasPrograma> parceriasPrograma = parceriasProgramaRepository.findByPrograma(programa).orElse(new ArrayList<ParceriasPrograma>());

		BiPredicate<ParceriasPrograma, List<ParceriasProgramaTO>> contemNaLista = (nova, lista) -> lista.stream().anyMatch(jaTinha -> Objects.nonNull(jaTinha.getEmpresa()) && jaTinha.getEmpresa().getId().equals(nova.getEmpresa().getId()));

		// Remove da lista todos os registros que não contém no Banco de Dados
		parceriasPrograma.removeIf(registro -> {
			if (!contemNaLista.test(registro, list)) {
				parceriasProgramaRepository.delete(registro);
				return true;
			}
			return false;
		});

		// Adiciona os novos registros
		List<ParceriasProgramaTO> novos = list.stream().filter(registro -> Objects.isNull(registro.getId())).collect(Collectors.toList());

		if (Objects.nonNull(novos)) {
			novos.forEach(novo -> alterar(programa, novo));
		}

	}

	private void alterar(Programa programa, ParceriasProgramaTO novo) {
		//		camposObrigatoriosParceriasProgramaRule.verificar(novo);
		ParceriasPrograma entity = parceriasProgramaTOBuilder.build(programa, novo);
		parceriasProgramaRepository.save(entity);
	}

}
