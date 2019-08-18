package br.com.crux.cmd;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.dao.PerfilAcessoDao;
import br.com.crux.dto.AcessoDTO;

@Component
public class GetAllAcessoUsuarioPorUnidadeCmd {
	
	@Autowired
	private PerfilAcessoDao perfilAcessoDao;
	
	public List<AcessoDTO> getAcesso(Long idUsarname, Long idUnidade) {
		
		if(Objects.isNull(idUsarname)) {
			throw new IllegalArgumentException("Parâmetro username não informado");
		}
		if(Objects.isNull(idUnidade)) {
			throw new IllegalArgumentException("Parâmetro unidade não informado");
		}
		
		return perfilAcessoDao.getAcesso(idUsarname, idUnidade);
	}

}
