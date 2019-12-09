package br.com.crux.cmd;

import java.util.List;
import java.util.Objects;
import java.util.function.BiPredicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.ColaboradoresProjetoTOBuilder;
import br.com.crux.entity.ColaboradoresProjeto;
import br.com.crux.entity.Projeto;
import br.com.crux.to.ColaboradoresProjetoTO;

@Component
public class AtualizarColaboradoresProjetoCmd {

	@Autowired
	private ColaboradoresProjetoTOBuilder colaboradoresProjetoTOBuilder;
	
	@Autowired
	private CadastrarColaboradoresProjetoCmd cadastrarColaboradoresProjetoCmd;

	public void atualizar(List<ColaboradoresProjeto> listaColaboradoresProjeto, List<ColaboradoresProjetoTO> listaAtualizadaDeColaboradores, Projeto projeto) {

		BiPredicate<ColaboradoresProjetoTO, List<ColaboradoresProjetoTO>> contemNaLista = (colaboradorProjeto, listaNova) -> listaNova.stream().anyMatch(novoColaborador -> Objects.nonNull(novoColaborador) && colaboradorProjeto.getId().equals(novoColaborador.getId()));

		listaAtualizadaDeColaboradores.stream()
				.filter(registro -> Objects.nonNull(registro.getId()))
				.forEach(registro ->
				{
					if (contemNaLista.test(registro, colaboradoresProjetoTOBuilder.buildAll(listaColaboradoresProjeto))) {

						cadastrarColaboradoresProjetoCmd.cadastrar(registro, projeto);
					}
				});
	}
}
