package br.com.crux.cmd;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.to.AcessoTO;

@Component
public class GetAcessoUsuarioCmd {

	@Autowired
	private GetAllAcessoUsuarioPorUnidadeCmd getAllAcessoUsuarioPorUnidadeCmd;

	public List<AcessoTO> getAllAcessoUsuarioPorUnidadeCmd(Long idUsarname, Long idUnidade) {
		return getAllAcessoUsuarioPorUnidadeCmd.getAcesso(idUsarname, idUnidade);

	}

}
