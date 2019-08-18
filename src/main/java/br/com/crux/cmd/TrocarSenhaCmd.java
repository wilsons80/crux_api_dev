package br.com.crux.cmd;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.dao.AcessoDao;
import br.com.crux.exception.NotFoundException;
import br.com.crux.security.CustomPasswordEncoder;

@Component
public class TrocarSenhaCmd {
	
	@Autowired private CustomPasswordEncoder customPasswordEncoder;
	@Autowired private AcessoDao acessoDao;
	
	public Boolean trocarSenha(String username, String senha) {
		if(StringUtils.isEmpty(senha)) {
			throw new NotFoundException("A nova senha não foi informada.");
		}
		if(StringUtils.isEmpty(senha)) {
			throw new NotFoundException("O usuário não foi informado.");
		}		
		
		String senhaEncode = customPasswordEncoder.encode(senha);
		
		return acessoDao.trocarSenha(username, senhaEncode);
	}

}
