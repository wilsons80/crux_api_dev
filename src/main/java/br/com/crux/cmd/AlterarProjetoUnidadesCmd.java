package br.com.crux.cmd;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.UsuariosUnidadeTOBuilder;
import br.com.crux.dao.repository.UnidadeRepository;
import br.com.crux.dao.repository.UsuariosUnidadeRepository;
import br.com.crux.entity.Unidade;
import br.com.crux.entity.UsuariosUnidade;
import br.com.crux.rule.CamposObrigatoriosUsuariosUnidadeRule;
import br.com.crux.to.UnidadeTO;
import br.com.crux.to.UsuariosUnidadesTO;

@Component
public class AlterarProjetoUnidadesCmd {

	@Autowired
	private CamposObrigatoriosUsuariosUnidadeRule camposObrigatoriosUsuariosUnidadeRule;
	@Autowired
	private UsuariosUnidadeTOBuilder usuarioUnidadeTOBuilder;
	@Autowired
	private UsuariosUnidadeRepository usuariosUnidadeRepository;
	@Autowired
	private UnidadeRepository unidadeRepository;

	private void alterar(UsuariosUnidadesTO usuarioUnidade) {
		camposObrigatoriosUsuariosUnidadeRule.verificar(usuarioUnidade);
		UsuariosUnidade entity = usuarioUnidadeTOBuilder.build(usuarioUnidade);
		usuariosUnidadeRepository.save(entity);
	}

	public void alterarAll(List<UnidadeTO> unidades, Long idProjeto) {
		// Lista da unidades que o usuário tem acesso.
		List<Unidade> listaUnidades = unidadeRepository.getUnidadeByProjeto(idProjeto)
															.orElse(new ArrayList<Unidade>());

		BiPredicate<UsuariosUnidadesTO, List<UsuariosUnidadesTO>> contemNaLista = (parte, lista) -> lista.stream()
								.anyMatch(parteNova -> Objects.nonNull(parteNova.getUnidade().getIdUnidade())
													&& parteNova.getUnidade().getIdUnidade().equals(parte.getUnidade().getIdUnidade()));

		// Remove da lista todos os registros que não contém no Banco de Dados
//		listaUnidades.removeIf(registro -> {
//			if (!contemNaLista.test(usuarioUnidadeTOBuilder.buildTO(registro), unidades)) {
//				usuariosUnidadeRepository.delete(registro);
//				return true;
//			}
//			return false;
//		});

		// Adiciona os novos registros
//		List<UsuariosUnidadesTO> novos = unidades.stream()
//				.filter(registro -> Objects.isNull(registro.getId())).collect(Collectors.toList());
//
//		if (Objects.nonNull(novos)) {
//			novos.forEach(novo -> alterar(novo));
//		}

	}

}
