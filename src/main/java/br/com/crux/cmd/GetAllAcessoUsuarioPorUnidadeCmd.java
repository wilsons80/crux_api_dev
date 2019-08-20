package br.com.crux.cmd;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.AcessoTOBuilder;
import br.com.crux.dao.PerfilAcessoDao;
import br.com.crux.dto.AcessoDTO;
import br.com.crux.rule.VerificaParametrosAcessoRule;
import br.com.crux.rule.VerificaPermissaoAcessoUnidadeRule;
import br.com.crux.to.AcessoTO;

@Component
public class GetAllAcessoUsuarioPorUnidadeCmd {
	
	@Autowired private PerfilAcessoDao perfilAcessoDao;
	
	@Autowired private AcessoTOBuilder acessoTOBuilder;
	
	@Autowired private VerificaParametrosAcessoRule verificaParametrosAcessoRule;

	@Autowired private VerificaPermissaoAcessoUnidadeRule verificaPermissaoAcessoUnidadeRule;
	
	public List<AcessoTO> getAcesso(String username, Long idUnidade) {
		
		verificaParametrosAcessoRule.verificar(username, idUnidade);
		List<AcessoDTO> acesso = perfilAcessoDao.getAcesso(username, idUnidade);
		
		verificaPermissaoAcessoUnidadeRule.verificar(acesso);
		
		
		return acessoTOBuilder.buildAll(acesso);
	}

}
