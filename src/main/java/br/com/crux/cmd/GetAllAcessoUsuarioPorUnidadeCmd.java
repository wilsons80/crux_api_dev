package br.com.crux.cmd;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.dao.PerfilAcessoDao;
import br.com.crux.dto.AcessoDTO;

@Component
public class GetAllAcessoUsuarioPorUnidadeCmd {
	
	@Autowired
	private PerfilAcessoDao perfilAcessoDao;
	
	public List<AcessoDTO> getAcesso(Long idUsarname, Long idUnidade) {
		return perfilAcessoDao.getAcesso(idUsarname, idUnidade);
	}

}
