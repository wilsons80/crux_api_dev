package br.com.crux.cmd;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.AcessoTOBuilder;
import br.com.crux.dao.PerfilAcessoDao;
import br.com.crux.dto.AcessoDTO;
import br.com.crux.to.AcessoTO;

@Component
public class GetAllAcessoUsuarioPorUnidadeCmd {
	
	@Autowired
	private PerfilAcessoDao perfilAcessoDao;
	
	@Autowired
	private AcessoTOBuilder acessoTOBuilder;
	
	public List<AcessoTO> getAcesso(Long idUsarname, Long idUnidade) {
		
		if(Objects.isNull(idUsarname)) {
			throw new IllegalArgumentException("Parâmetro username não informado");
		}
		if(Objects.isNull(idUnidade)) {
			throw new IllegalArgumentException("Parâmetro unidade não informado");
		}
		
		List<AcessoDTO> acesso = perfilAcessoDao.getAcesso(idUsarname, idUnidade);
		
		return acessoTOBuilder.buildAll(acesso);
	}

}
