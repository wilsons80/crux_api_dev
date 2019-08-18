package br.com.crux.cmd;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.dao.PerfilAcessoDao;
import br.com.crux.dto.AcessoDTO;
import br.com.crux.rule.VerificaParametrosAcessoRule;
import br.com.crux.to.AcessoTO;

@Component
public class GetAcessoUsuarioCmd {

	@Autowired
	private PerfilAcessoDao perfilAcessoDao;
	@Autowired
	private GetAllAcessoUsuarioPorUnidadeCmd getAllAcessoUsuarioPorUnidadeCmd;

	@Autowired
	private VerificaParametrosAcessoRule verificaParametrosAcessoRule;

	public List<AcessoDTO> getAllAcessoUsuarioPorUnidadeCmd1(Long idUsarname, Long idUnidade) {

		verificaParametrosAcessoRule.verificar(idUsarname, idUnidade);
		return perfilAcessoDao.getAcesso(idUsarname, idUnidade);

	}

	public List<AcessoTO> getAllAcessoUsuarioPorUnidadeCmd(Long idUsarname, Long idUnidade) {
		return getAllAcessoUsuarioPorUnidadeCmd.getAcesso(idUsarname, idUnidade);

	}

}
