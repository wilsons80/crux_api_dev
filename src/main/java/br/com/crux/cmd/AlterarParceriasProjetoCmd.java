package br.com.crux.cmd;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.ParceriasProjetoTOBuilder;
import br.com.crux.dao.repository.ParceriasProjetoRepository;
import br.com.crux.entity.ParceriasProjeto;
import br.com.crux.entity.Projeto;
import br.com.crux.rule.CamposObrigatoriosParceriasProjetoRule;
import br.com.crux.to.ParceriasProjetoTO;

@Component
public class AlterarParceriasProjetoCmd {

	@Autowired private CamposObrigatoriosParceriasProjetoRule camposObrigatoriosParceriasProjetoRule;
	@Autowired private ParceriasProjetoTOBuilder parceriasProjetoTOBuilder;
	@Autowired private ParceriasProjetoRepository parceriasProjetoRepository;

	public void alterarAll(List<ParceriasProjetoTO> parceriasProjetoTO, Projeto projeto) {

		// Lista da unidades que o usuário tem acesso.
		List<ParceriasProjeto> parceriasProjeto = parceriasProjetoRepository.findByProjeto(projeto).orElse(new ArrayList<ParceriasProjeto>());

		BiPredicate<ParceriasProjeto, List<ParceriasProjetoTO>> contemNaLista = (nova, lista) -> lista.stream().anyMatch(
				jaTinha -> Objects.nonNull(jaTinha.getEmpresa()) && jaTinha.getEmpresa().getId().equals(nova.getEmpresa().getId()));

		// Remove da lista todos os registros que não contém no Banco de Dados
		parceriasProjeto.removeIf(registro -> {
			if (!contemNaLista.test(registro, parceriasProjetoTO)) {
				parceriasProjetoRepository.delete(registro);
				return true;
			}
			return false;
		});

		// Adiciona os novos registros
		List<ParceriasProjetoTO> novos = parceriasProjetoTO.stream().filter(registro -> Objects.isNull(registro.getId())).collect(Collectors.toList());

		if (Objects.nonNull(novos)) {
			novos.forEach(novo -> alterar(projeto, novo));
		}

	}

	private void alterar(Projeto projeto, ParceriasProjetoTO novo) {
		camposObrigatoriosParceriasProjetoRule.verificar(novo);
		ParceriasProjeto entity = parceriasProjetoTOBuilder.build(projeto, novo);
		parceriasProjetoRepository.save(entity);
	}

}
