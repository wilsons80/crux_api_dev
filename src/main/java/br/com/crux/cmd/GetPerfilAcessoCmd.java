package br.com.crux.cmd;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.PerfilAcessoTOBuilder;
import br.com.crux.builder.PerfilAcessoUsuarioTOBuilder;
import br.com.crux.dao.AcessoDao;
import br.com.crux.dao.repository.PerfilAcessoRepository;
import br.com.crux.entity.PerfisAcesso;
import br.com.crux.entity.UsuariosSistema;
import br.com.crux.exception.ParametroNaoInformadoException;
import br.com.crux.to.PerfilAcessoTO;
import br.com.crux.to.PerfilAcessoUsuarioTO;

@Component
public class GetPerfilAcessoCmd {

	@Autowired private PerfilAcessoRepository perfilAcessoRepository;
	@Autowired private AcessoDao acessoDao;
	@Autowired private PerfilAcessoTOBuilder perfilAcessoTOBuilder;
	@Autowired private PerfilAcessoUsuarioTOBuilder perfilAcessoUsuarioTOBuilder;  
	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;

	
	public List<PerfisAcesso> getAllPerfilAcesso() {
		return perfilAcessoRepository.findAll();
	}

	
	public List<PerfilAcessoUsuarioTO> getPerfilAcessoDoUsuario(Long idUnidade, Long idUsuario, Long idModulo) {
		if(Objects.isNull(idUnidade)) {
			throw new ParametroNaoInformadoException("Erro ao recuperar os perfils do usuário, unidade não informada.");
		}
		return perfilAcessoUsuarioTOBuilder.buildAll(acessoDao.getPerfilAcessoDoUsuario(idUnidade, idUsuario , idModulo));
	}
	
	public List<PerfilAcessoTO> getPerfilAcesso(Long idUnidade,Long idModulo) {
		if(Objects.isNull(idUnidade)) {
			throw new ParametroNaoInformadoException("Erro ao recuperar os perfils do usuário, unidade não informada.");
		}
		
		UsuariosSistema usuarioLogado = getUsuarioLogadoCmd.getUsuarioLogado();
		return perfilAcessoTOBuilder.buildAll(acessoDao.getPerfilAcesso(idUnidade, usuarioLogado.getIdUsuario(), idModulo));
	}

	/*
	public List<UnidadeModuloAcessoTO> getUnidadesComPermissaoModuloAcesso() {
		Long idUsuarioLogado = getUsuarioLogadoCmd.getUsuarioLogado().getIdUsuario();
		return unidadeModuloAcessoTOBuilder.buildAll(acessoDao.getUnidadesComPermissaoModuloAcesso(idUsuarioLogado));
	}
	*/

}
