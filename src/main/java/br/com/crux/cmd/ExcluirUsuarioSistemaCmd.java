package br.com.crux.cmd;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.dao.repository.UsuarioSistemaRepository;
import br.com.crux.exception.ParametroNaoInformadoException;

@Component
public class ExcluirUsuarioSistemaCmd {

	@Autowired
	private UsuarioSistemaRepository repository;
	
	
	public void excluir(Long id) {
		if(Objects.isNull(id)) {throw new ParametroNaoInformadoException("Usuário não informado.");}
		repository.deleteById(id);
	}
}
