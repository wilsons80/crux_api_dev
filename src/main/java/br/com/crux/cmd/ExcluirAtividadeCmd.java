package br.com.crux.cmd;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.dao.repository.AtividadeRepository;
import br.com.crux.exception.ParametroNaoInformadoException;

@Component
public class ExcluirAtividadeCmd {

	@Autowired
	private AtividadeRepository repository;
	
	
	public void excluir(Long idDepartamento) {
		if(Objects.isNull(idDepartamento)) {
			throw new ParametroNaoInformadoException("Erro ao excluir a Atividade. Parâmetro 'atividade' ausente.");
		}
		repository.deleteById(idDepartamento);
	}
}
