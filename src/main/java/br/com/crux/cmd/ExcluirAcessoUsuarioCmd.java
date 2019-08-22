package br.com.crux.cmd;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.dao.AcessoDao;
import br.com.crux.exception.ParametroNaoInformado;

@Component
public class ExcluirAcessoUsuarioCmd {

	@Autowired
	private AcessoDao acessoDao;
	
	
	public void excluir(Long idUsuarioGrupo) {
		if(Objects.isNull(idUsuarioGrupo)) {
			throw new ParametroNaoInformado("Erro ao excluir o acesso do usuário. Parâmetro 'usuarioGrupo' ausente.");
		}
		acessoDao.excluir(idUsuarioGrupo);
	}
}
