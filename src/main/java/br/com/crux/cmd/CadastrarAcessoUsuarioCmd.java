package br.com.crux.cmd;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.dao.repository.ModuloRepository;
import br.com.crux.dao.repository.UnidadeRepository;
import br.com.crux.dao.repository.UsuarioSistemaRepository;
import br.com.crux.dao.repository.UsuariosGrupoRepository;
import br.com.crux.entity.GruposModulo;
import br.com.crux.entity.Modulo;
import br.com.crux.entity.PerfisAcesso;
import br.com.crux.entity.Unidade;
import br.com.crux.entity.UsuariosGrupo;
import br.com.crux.entity.UsuariosSistema;
import br.com.crux.exception.NotFoundException;
import br.com.crux.to.CadastroAcessoTO;

@Component
public class CadastrarAcessoUsuarioCmd {

	@Autowired private GetPerfilAcessoCmd getPerfilAcessoCmd;
	@Autowired private UnidadeRepository unidadeRepository;
	@Autowired private ModuloRepository moduloRepository;
	@Autowired private UsuariosGrupoRepository usuariosGrupoRepository;
	@Autowired private GetGruposModulosCmd getGruposModulosCmd;
	@Autowired private UsuarioSistemaRepository usuarioSistemaRepository;
	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;
	
	public void cadastrar(CadastroAcessoTO acessoTO) {
		List<PerfisAcesso> perfisAcesso = getPerfilAcessoCmd.getAllPerfilAcesso();
		
		PerfisAcesso perfil = perfisAcesso.stream()
				                          .filter(p -> {
														return p.getCsAltera().equals(acessoTO.getAltera())
															&& p.getCsConsulta().equals(acessoTO.getConsulta())
															&& p.getCsDeleta().equals(acessoTO.getDeleta())
															&& p.getCsInsere().equals(acessoTO.getInsere());
													})
				                          .findFirst().orElseGet(null);
		
		Optional<Unidade> unidade = unidadeRepository.findById(acessoTO.getIdUnidade());
		if(!unidade.isPresent()) {
			throw new NotFoundException("Unidade informada não existe.");
		}
		
		Optional<Modulo> modulo = moduloRepository.findById(acessoTO.getIdModulo());
		if(!modulo.isPresent()) {
			throw new NotFoundException("Modulo informado não existe.");
		}
		
		Optional<UsuariosSistema> usuario = usuarioSistemaRepository.findById(acessoTO.getIdUsuario());
		if(!modulo.isPresent()) {
			throw new NotFoundException("Usuario informado não existe.");
		}

		GruposModulo gruposModulo = getGruposModulosCmd.getGrupoModulo(unidade.get().getIdUnidade(), 
				                                                      modulo.get().getIdModulo(), 
				                                                      perfil.getIdPerfilAcesso());


		
		Optional<UsuariosSistema> usuarioLogado = usuarioSistemaRepository.findByUsername(getUsuarioLogadoCmd.get().getName());
		if(!usuarioLogado.isPresent()) {
			throw new NotFoundException("Erro ao recuperar o usuário logado.");
		}
		
		UsuariosGrupo usuariosGrupo = new UsuariosGrupo();
		usuariosGrupo.setGruposModulo(gruposModulo);
		usuariosGrupo.setUsuariosSistema(usuario.get());
		usuariosGrupo.setIdUsuarioApl(usuarioLogado.get().getIdUsuario());
		usuariosGrupoRepository.save(usuariosGrupo);
		
	}
}
