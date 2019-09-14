package br.com.crux.cmd;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.dao.repository.CursosFormacaoPFRepository;
import br.com.crux.dao.repository.PessoaFisicaRepository;
import br.com.crux.entity.CursosFormacaoPf;
import br.com.crux.entity.PessoaFisica;
import br.com.crux.exception.NotFoundException;
import br.com.crux.exception.ParametroNaoInformadoException;
import br.com.crux.exception.TabaleReferenciaEncontradaException;

@Component
public class ExcluirCursosFormacaoPFCmd {

	@Autowired
	private CursosFormacaoPFRepository repository;
	
	@Autowired
	private PessoaFisicaRepository pessoaFisicarepository;
	
	public void excluir(Long id) {
		if(Objects.isNull(id)) {
			throw new ParametroNaoInformadoException("Erro ao excluir o curso formação.");
		}
		
		Optional<CursosFormacaoPf> curso = repository.findById(id);
		if(!curso.isPresent()) {
			throw new NotFoundException("Curso de Formação informado não existe.");
		}
		
		Optional<PessoaFisica> pessoaFisica = pessoaFisicarepository.findById(curso.get().getPessoaFisica().getId());
		if(pessoaFisica.isPresent()) {
			throw new TabaleReferenciaEncontradaException("Pessoa Física deve ser excluída primeiro.");
		}
		
		repository.deleteById(id);
	}
}