package br.com.crux.cmd;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.to.AcessoTO;

@Component
public class GetAcessoUsuarioCmd {

	@Autowired
	private GetAllAcessoUsuarioPorUnidadeCmd getAllAcessoUsuarioPorUnidadeCmd;

	public List<AcessoTO> getAllAcessoUsuarioPorUnidade(Long idUnidade) {
		return getAllAcessoUsuarioPorUnidadeCmd.getAcesso(idUnidade);

	}

}
