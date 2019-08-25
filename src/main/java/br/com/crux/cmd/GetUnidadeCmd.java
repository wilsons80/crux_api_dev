package br.com.crux.cmd;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import br.com.crux.builder.AcessoUnidadeTOBuilder;
import br.com.crux.entity.UsuariosSistema;
import br.com.crux.entity.UsuariosUnidade;
import br.com.crux.to.AcessoUnidadeTO;

@Component
public class GetUnidadeCmd {

	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;
	@Autowired private AcessoUnidadeTOBuilder unidadeTOBuilder;

	public List<AcessoUnidadeTO> getUnidadesComAcesso() throws UsernameNotFoundException {
		UsuariosSistema user = getUsuarioLogadoCmd.getUsuarioLogado();
		
		return user.getUsuariosUnidades().stream().map((UsuariosUnidade unidade) -> {
			return unidadeTOBuilder.build(unidade.getUnidade());
		}).collect(Collectors.toList());
	}

}
