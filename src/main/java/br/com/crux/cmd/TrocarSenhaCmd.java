package br.com.crux.cmd;

import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import br.com.crux.dao.AcessoDao;
import br.com.crux.exception.NotFoundException;
import br.com.crux.security.CustomPasswordEncoder;

@Component
public class TrocarSenhaCmd {
	
	@Autowired private CustomPasswordEncoder customPasswordEncoder;
	@Autowired private AcessoDao acessoDao;
	
	public void trocarSenha(String senha) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(Objects.isNull(authentication)) {
			throw new NotFoundException("Problema ao recuperar o usuário logado.");
		}

		
		if(StringUtils.isEmpty(senha)) {
			throw new NotFoundException("A nova senha não foi informada.");
		}
		if(StringUtils.isEmpty(senha)) {
			throw new NotFoundException("O usuário não foi informado.");
		}		
		
		String senhaEncode = customPasswordEncoder.encode(senha);
		
		acessoDao.trocarSenha(authentication.getName(), senhaEncode);
	}

}
