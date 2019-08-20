package br.com.crux.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.repository.TrocarSenhaRepository;

@Component
public class AcessoDao {
	
	@Autowired 
	protected TrocarSenhaRepository trocarSenhaRepository;
	
	public void trocarSenha(String username, String senha) {
		trocarSenhaRepository.updateSenha(username, senha);
	}

}
