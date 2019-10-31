package br.com.crux.cmd;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import br.com.crux.dao.repository.AtividadeRepository;
import br.com.crux.exception.ParametroNaoInformadoException;
import br.com.crux.exception.base.NegocioException;

@Component
public class ExcluirAtividadeCmd {

	@Autowired private AtividadeRepository repository;

	public void excluir(Long idAtividade) {
		if (Objects.isNull(idAtividade)) {
			throw new ParametroNaoInformadoException("Erro ao excluir a Atividade. Parâmetro 'atividade' ausente.");
		}

		try {
			repository.deleteById(idAtividade);
		} catch (DataIntegrityViolationException e) {
			throw new NegocioException("Erro ao excluir, existem dados vinculados a essa atividade.");
		}

	}
}
