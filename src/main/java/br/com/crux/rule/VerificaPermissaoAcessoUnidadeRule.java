package br.com.crux.rule;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Component;

import br.com.crux.dto.AcessoDTO;
import br.com.crux.exception.UsuarioSemAcessoUnidadeException;

@Component
public class VerificaPermissaoAcessoUnidadeRule {

	public void verificar(List<AcessoDTO> acesso) {
		if(Objects.isNull(acesso) || acesso.isEmpty()) {
			throw new UsuarioSemAcessoUnidadeException("O usuário não possui acesso a esta unidade");
		}
		
	}

}
