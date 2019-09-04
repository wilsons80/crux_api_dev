package br.com.crux.cmd;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import br.com.crux.dao.repository.UnidadeRepository;
import br.com.crux.entity.Unidade;
import br.com.crux.exception.NotFoundException;
import br.com.crux.security.CustomUserDetails;
import br.com.crux.to.UnidadeLogadaTO;

@Component
public class CarregarUnidadeLogadaCmd {

	@Autowired private UnidadeRepository unidadeRepository;
	
	public void carregarUnidadeLogada(Long idUnidade) {
		if( Objects.nonNull(idUnidade) ) {
			Optional<Unidade> unidade = unidadeRepository.findById(idUnidade);
			
			if(unidade.isPresent()) {
				Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
				if(Objects.isNull(authentication)) {
					throw new NotFoundException("Problema ao recuperar o usuário logado.");
				}
				
				UnidadeLogadaTO unidadeLogada = new UnidadeLogadaTO();  
				unidadeLogada.setIdUnidade(unidade.get().getIdUnidade());
				unidadeLogada.setNomeUnidade(unidade.get().getNomeUnidade());
				unidadeLogada.setSiglaUnidade(unidade.get().getSiglaUnidade());
				

				UsernamePasswordAuthenticationToken currentAuth = (UsernamePasswordAuthenticationToken) authentication;
				
				CustomUserDetails userDetail = (CustomUserDetails) currentAuth.getPrincipal(); 
				userDetail.setUnidadeLogada(unidadeLogada);
				
				SecurityContextHolder.getContext().setAuthentication(currentAuth);
			}
		}
	}
}
