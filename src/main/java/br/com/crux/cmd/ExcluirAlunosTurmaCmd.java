package br.com.crux.cmd;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import br.com.crux.dao.repository.AlunosTurmaRepository;
import br.com.crux.exception.ParametroNaoInformadoException;
import br.com.crux.exception.TabaleReferenciaEncontradaException;

@Component
public class ExcluirAlunosTurmaCmd {

	@Autowired private AlunosTurmaRepository repository;
	
	public void excluir(Long id) {
		try {
			if(Objects.isNull(id)) {throw new ParametroNaoInformadoException("Erro ao excluir, parâmetro ausente.");}
			repository.deleteById(id);
			
		} catch (DataIntegrityViolationException e) {
			throw new TabaleReferenciaEncontradaException("Erro ao excluir, verifique se há outros cadastro com referência a este registro.");
		}
	}
}
