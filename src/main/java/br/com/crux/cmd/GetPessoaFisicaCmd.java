package br.com.crux.cmd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.PessoaFisicaTOBuilder;
import br.com.crux.dao.repository.PessoaFisicaRepository;
import br.com.crux.entity.PessoaFisica;
import br.com.crux.exception.NotFoundException;
import br.com.crux.to.PessoaFisicaTO;

@Component
public class GetPessoaFisicaCmd {

	@Autowired private PessoaFisicaRepository repository;
	@Autowired private PessoaFisicaTOBuilder toBuilder;
	
	public List<PessoaFisicaTO> getAll() {
		List<PessoaFisica> entitys = repository.findAll();
		if(entitys == null || entitys.isEmpty()) {
			return new ArrayList<PessoaFisicaTO>();
		}
		return toBuilder.buildAll(entitys);
	}
	
	public PessoaFisicaTO getById(Long id) {
		Optional<PessoaFisica> entityOptional = repository.findById(id);
		if(!entityOptional.isPresent()) {
			throw new NotFoundException("Pessoa física não encontrado.");
		}
		return toBuilder.buildTO(entityOptional.get());
	}
			
}
