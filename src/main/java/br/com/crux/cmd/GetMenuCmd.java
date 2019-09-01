package br.com.crux.cmd;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.MenuTOBuilder;
import br.com.crux.dao.MenuDao;
import br.com.crux.dao.dto.MenuDTO;
import br.com.crux.entity.UsuariosSistema;
import br.com.crux.rule.VerificaParametrosAcessoRule;
import br.com.crux.rule.VerificaPermissaoMenuRule;
import br.com.crux.to.MenuTO;

@Component
public class GetMenuCmd {
	
	@Autowired private MenuDao menuDao ;
	@Autowired private MenuTOBuilder menuTOBuilder;
	@Autowired private VerificaParametrosAcessoRule verificaParametrosAcessoRule;
	@Autowired private VerificaPermissaoMenuRule verificaPermissaoMenuRule;
	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;
	
	
	public List<MenuTO> getMenuPrincipal(Long idUnidade) {
		UsuariosSistema usuarioLogado = getUsuarioLogadoCmd.getUsuarioLogado();
		String username = usuarioLogado.getUsername();
		
		verificaParametrosAcessoRule.verificar(username, idUnidade);
		List<MenuDTO> menu = menuDao.getMenuPrincipal(usuarioLogado.getIdUsuario(), idUnidade);
		
		verificaPermissaoMenuRule.verificar(menu);
		
		return menuTOBuilder.buildAll(menu);
	}

}
