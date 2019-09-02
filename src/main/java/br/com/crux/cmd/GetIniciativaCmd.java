package br.com.crux.cmd;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.IniciativaTOBuilder;
import br.com.crux.dao.repository.IniciativaRepository;
import br.com.crux.dao.repository.UnidadeRepository;
import br.com.crux.entity.Iniciativa;
import br.com.crux.entity.Unidade;
import br.com.crux.exception.NotFoundException;
import br.com.crux.exception.ParametroNaoInformadoException;
import br.com.crux.to.IniciativaTO;

@Component
public class GetIniciativaCmd {

	@Autowired
	private IniciativaRepository iniciativaRepository;
	@Autowired
	private IniciativaTOBuilder iniciativaTOBuilder;
	@Autowired
	private UnidadeRepository unidadeRepository;
	
	public List<IniciativaTO> getAll(Long idUnidade) {
		Optional<Unidade> unidade = unidadeRepository.findById(idUnidade);
		if(!unidade.isPresent()) {
			throw new ParametroNaoInformadoException("Unidade não informada.");
		}
		
		Optional<List<Iniciativa>> listaRetorno = iniciativaRepository.findByIdUnidade(unidade.get().getIdUnidade());
		if(listaRetorno.isPresent()) {
			return iniciativaTOBuilder.buildAll(listaRetorno.get());
		}
		return null;
	}
	
	public IniciativaTO getById(Long id) {
		Optional<Iniciativa> entityOptional = iniciativaRepository.findById(id);
		if(!entityOptional.isPresent()) {
			throw new NotFoundException("Iniciativa não encontrado");
		}
		return iniciativaTOBuilder.buildTO(entityOptional.get());
	}
			
}
