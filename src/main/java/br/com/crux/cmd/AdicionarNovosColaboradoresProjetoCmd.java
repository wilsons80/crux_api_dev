package br.com.crux.cmd;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.entity.Projeto;
import br.com.crux.to.ColaboradoresProjetoTO;

@Component
public class AdicionarNovosColaboradoresProjetoCmd {

	@Autowired
	private CadastrarColaboradoresProjetoCmd cadastrarColaboradoresProjetoCmd;

	public void adicionar(List<ColaboradoresProjetoTO> listaAtualizadaDeColaboradores, Projeto projeto) {

		List<ColaboradoresProjetoTO> novos = listaAtualizadaDeColaboradores.stream()
				.filter(registro -> Objects.isNull(registro.getId()))
				.collect(Collectors.toList());

		if (Objects.nonNull(novos)) {
			novos.forEach(novoResponsavel -> cadastrarColaboradoresProjetoCmd.cadastrar(novoResponsavel, projeto));
		}

	}

}
