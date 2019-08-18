package br.com.crux.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.repository.TrocarSenhaRepository;

@Component
public class AcessoDao {
	
	@Autowired 
	protected TrocarSenhaRepository trocarSenhaRepository;
	
	public Boolean trocarSenha(String username, String senha) {
		int updateSenha = trocarSenhaRepository.updateSenha(username, senha);
		return updateSenha == 1;
	}

}
