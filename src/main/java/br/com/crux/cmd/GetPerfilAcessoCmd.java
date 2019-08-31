package br.com.crux.cmd;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.PerfilAcessoUsuarioTOBuilder;
import br.com.crux.builder.UnidadeModuloAcessoTOBuilder;
import br.com.crux.dao.AcessoDao;
import br.com.crux.dao.repository.PerfilAcessoRepository;
import br.com.crux.entity.PerfisAcesso;
import br.com.crux.exception.ParametroNaoInformadoException;
import br.com.crux.to.PerfilAcessoUsuarioTO;
import br.com.crux.to.UnidadeModuloAcessoTO;

@Component
public class GetPerfilAcessoCmd {

	@Autowired
	private PerfilAcessoRepository perfilAcessoRepository;
	@Autowired
	private AcessoDao acessoDao;
	@Autowired
	private PerfilAcessoUsuarioTOBuilder perfilAcessoUsuarioTOBuilder;
	@Autowired
	private UnidadeModuloAcessoTOBuilder unidadeModuloAcessoTOBuilder;
	@Autowired
	private GetUsuarioLogadoCmd getUsuarioLogadoCmd;

	
	public List<PerfisAcesso> getAllPerfilAcesso() {
		return perfilAcessoRepository.findAll();
	}

	public List<PerfilAcessoUsuarioTO> getPerfilAcesso(Long idUnidade,Long idUsuario,Long idModulo) {
		if(Objects.isNull(idUnidade)) {
			throw new ParametroNaoInformadoException("Erro ao recuperar os perfils do usuário, unidade não informada.");
		}
		return perfilAcessoUsuarioTOBuilder.buildAll(acessoDao.getPerfilAcesso(idUnidade, idUsuario, idModulo));
	}

	public List<UnidadeModuloAcessoTO> getUnidadesComPermissaoModuloAcesso() {
		Long idUsuarioLogado = getUsuarioLogadoCmd.getUsuarioLogado().getIdUsuario();
		return unidadeModuloAcessoTOBuilder.buildAll(acessoDao.getUnidadesComPermissaoModuloAcesso(idUsuarioLogado));
	}

}
