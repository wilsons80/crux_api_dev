package br.com.crux.cmd;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import br.com.crux.builder.AcessoTOBuilder;
import br.com.crux.dao.PerfilAcessoDao;
import br.com.crux.dao.dto.AcessoDTO;
import br.com.crux.exception.NotFoundException;
import br.com.crux.rule.VerificaParametrosAcessoRule;
import br.com.crux.rule.VerificaPermissaoAcessoUnidadeRule;
import br.com.crux.to.AcessoTO;

@Component
public class GetAllAcessoUsuarioPorUnidadeCmd {
	
	@Autowired private PerfilAcessoDao perfilAcessoDao;
	
	@Autowired private AcessoTOBuilder acessoTOBuilder;
	
	@Autowired private VerificaParametrosAcessoRule verificaParametrosAcessoRule;

	@Autowired private VerificaPermissaoAcessoUnidadeRule verificaPermissaoAcessoUnidadeRule;
	
	public List<AcessoTO> getAcesso(Long idUnidade) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(Objects.isNull(authentication)) {
			throw new NotFoundException("Problema ao recuperar o usuário logado.");
		}

		String username = authentication.getName();
		verificaParametrosAcessoRule.verificar(username, idUnidade);
		List<AcessoDTO> acesso = perfilAcessoDao.getAcesso(username, idUnidade);
		
		verificaPermissaoAcessoUnidadeRule.verificar(acesso);
		
		
		return acessoTOBuilder.buildAll(acesso);
	}

}
