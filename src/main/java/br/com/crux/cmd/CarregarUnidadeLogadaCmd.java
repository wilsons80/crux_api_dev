package br.com.crux.cmd;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.dao.repository.UnidadeRepository;
import br.com.crux.entity.Unidade;
import br.com.crux.security.CustomUserDetails;
import br.com.crux.to.AcessoUnidadeTO;

@Component
public class CarregarUnidadeLogadaCmd {

	@Autowired private UnidadeRepository unidadeRepository;
	
	
	public CustomUserDetails carregarUnidadeLogada(Long idUnidade) {
		CustomUserDetails customUserDetails = new CustomUserDetails();
		
		if( Objects.nonNull(idUnidade) ) {
			Optional<Unidade> unidade = unidadeRepository.findById(idUnidade);
			
			if(unidade.isPresent()) {
				AcessoUnidadeTO unidadeLogada = new AcessoUnidadeTO();  
				unidadeLogada.setId(unidade.get().getIdUnidade());
				unidadeLogada.setNome(unidade.get().getNomeUnidade());
				unidadeLogada.setIdentificador(unidade.get().getSiglaUnidade());
				
				customUserDetails.setUnidadeLogada(unidadeLogada);
			}
		}
		
		return customUserDetails;
	}
}
