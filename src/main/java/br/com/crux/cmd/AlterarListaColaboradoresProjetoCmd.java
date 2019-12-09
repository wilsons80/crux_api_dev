package br.com.crux.cmd;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.entity.ColaboradoresProjeto;
import br.com.crux.entity.Projeto;
import br.com.crux.to.ColaboradoresProjetoTO;

@Component
public class AlterarListaColaboradoresProjetoCmd {

	@Autowired private GetColaboradoresProjetoCmd getColaboradoresProjetoCmd;
	@Autowired private RemoverColaboradoresProjetoCasoNecessarioCmd removerColaboradoresProjetoCasoNecessarioCmd;
	@Autowired private AdicionarNovosColaboradoresProjetoCmd adicionarNovosColaboradoresProjetoCmd;
	@Autowired private AtualizarColaboradoresProjetoCmd atualizarColaboradoresProjetoCmd;

	public void alterarAll(List<ColaboradoresProjetoTO> listaAtualizadaDeColaboradores, Projeto projeto) {

		List<ColaboradoresProjeto> listaColaboradoresProjeto = getColaboradoresProjetoCmd.getPorProjeto(projeto);

		removerColaboradoresProjetoCasoNecessarioCmd.remover(listaColaboradoresProjeto, listaAtualizadaDeColaboradores);

		adicionarNovosColaboradoresProjetoCmd.adicionar(listaAtualizadaDeColaboradores, projeto);

		atualizarColaboradoresProjetoCmd.atualizar(listaColaboradoresProjeto, listaAtualizadaDeColaboradores, projeto);
	}

}
