package br.com.crux.cmd;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.PerfilAcessoUsuarioTOBuilder;
import br.com.crux.dao.AcessoDao;
import br.com.crux.dao.repository.PerfilAcessoRepository;
import br.com.crux.entity.PerfisAcesso;
import br.com.crux.exception.ParametroNaoInformado;
import br.com.crux.to.PerfilAcessoUsuarioTO;

@Component
public class GetPerfilAcessoCmd {

	@Autowired
	private PerfilAcessoRepository perfilAcessoRepository;
	@Autowired
	private AcessoDao acessoDao;
	@Autowired
	private PerfilAcessoUsuarioTOBuilder perfilAcessoUsuarioTOBuilder;
	

	public List<PerfisAcesso> getAllPerfilAcesso() {
		return perfilAcessoRepository.findAll();
	}

	public List<PerfilAcessoUsuarioTO> getPerfilAcesso(Long idUnidade,Long idUsuario,Long idModulo) {
		if(Objects.isNull(idUnidade)) {
			throw new ParametroNaoInformado("Erro ao recuperar os perfils do usuário, unidade não informada.");
		}
		return perfilAcessoUsuarioTOBuilder.buildAll(acessoDao.getPerfilAcesso(idUnidade, idUsuario, idModulo));
	}

}
