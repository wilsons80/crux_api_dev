package br.com.crux.cmd;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.dao.repository.GrupoModuloRepository;
import br.com.crux.dao.repository.ModuloRepository;
import br.com.crux.dao.repository.PerfilAcessoRepository;
import br.com.crux.dao.repository.UnidadeRepository;
import br.com.crux.dao.repository.UsuarioSistemaRepository;
import br.com.crux.dao.repository.UsuariosGrupoRepository;
import br.com.crux.entity.GruposModulo;
import br.com.crux.entity.Modulo;
import br.com.crux.entity.PerfilAcesso;
import br.com.crux.entity.Unidade;
import br.com.crux.entity.UsuariosGrupo;
import br.com.crux.entity.UsuariosSistema;
import br.com.crux.exception.NotFoundException;
import br.com.crux.exception.PerfilAcessoException;
import br.com.crux.to.CadastroAcessoTO;
import br.com.crux.to.UsuarioLogadoTO;

@Component
public class CadastrarAcessoUsuarioCmd {

	@Autowired private UnidadeRepository unidadeRepository;
	@Autowired private ModuloRepository moduloRepository;
	@Autowired private UsuariosGrupoRepository usuariosGrupoRepository;
	@Autowired private UsuarioSistemaRepository usuarioSistemaRepository;
	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;
	@Autowired private GrupoModuloRepository grupoModuloRepository;
	@Autowired private PerfilAcessoRepository perfilAcessoRepository;
	
	public void cadastrar(CadastroAcessoTO acessoTO) {
		
		Optional<Unidade> unidade = unidadeRepository.findById(acessoTO.getIdUnidade());
		if(!unidade.isPresent()) {
			throw new NotFoundException("Unidade informada não existe.");
		}
		
		Optional<Modulo> modulo = moduloRepository.findById(acessoTO.getIdModulo());
		if(!modulo.isPresent()) {
			throw new NotFoundException("Modulo informado não existe.");
		}
		
		Optional<UsuariosSistema> usuario = usuarioSistemaRepository.findById(acessoTO.getIdUsuario());
		if(!usuario.isPresent()) {
			throw new NotFoundException("Usuario informado não existe.");
		}

		Optional<GruposModulo> gruposModulo = grupoModuloRepository.findById(acessoTO.getIdGrupoModulo());
		if(!gruposModulo.isPresent()) {
			throw new NotFoundException("Não existe o tipo de perfil cadastrado para essa unidade.");
		}
		
		Optional<UsuariosGrupo> usuarioGrupo = usuariosGrupoRepository.findByGruposModuloAndUsuariosSistema(gruposModulo.get(), usuario.get());
		if(usuarioGrupo.isPresent()) {
			throw new PerfilAcessoException("Usuário já possui esse perfil cadastrado.");
		}
		
		UsuarioLogadoTO usuarioLogado = getUsuarioLogadoCmd.getUsuarioLogado();

		//Valido se já existe permissão no módulo pai.
		Optional<List<UsuariosGrupo>> permissaoModuloPai = usuariosGrupoRepository.getPermissoes(acessoTO.getIdUsuario(), modulo.get().getModuloPai().getId());
		if (!permissaoModuloPai.isPresent()) {
			Optional<PerfilAcesso> perfilApenasConsulta = perfilAcessoRepository.getPerfilApenasConsulta();
			if(!perfilApenasConsulta.isPresent()) {
				throw new PerfilAcessoException("Não foi possível atribuir permissão ao modulo pai.");
			}

			Optional<GruposModulo> grupoModuloOptional = grupoModuloRepository.findByIdModuloAndIdPerfilAcessoAndIdUnidade(modulo.get().getModuloPai().getId(), 
			                                              		perfilApenasConsulta.get().getId(), unidade.get().getIdUnidade());
			
			GruposModulo gruposModuloPai = new GruposModulo();
			if(!grupoModuloOptional.isPresent()) {
				gruposModuloPai.setModulo(modulo.get().getModuloPai());
				gruposModuloPai.setNome("C");
				gruposModuloPai.setPerfilAcesso(perfilApenasConsulta.get());
				gruposModuloPai.setDescricao("Grupo de perfil de consultar");
				gruposModuloPai.setUnidade(unidade.get());
				
				gruposModuloPai = grupoModuloRepository.save(gruposModuloPai);
			} else {
				gruposModuloPai = grupoModuloOptional.get();
			}
			
			UsuariosGrupo usuariosGrupoPai = new UsuariosGrupo();
			usuariosGrupoPai.setGruposModulo(gruposModuloPai);
			usuariosGrupoPai.setUsuariosSistema(usuario.get());
			usuariosGrupoPai.setIdUsuarioApl(usuarioLogado.getIdUsuario());
			usuariosGrupoRepository.save(usuariosGrupoPai);
		}
		
		
		
		UsuariosGrupo usuariosGrupo = new UsuariosGrupo();
		usuariosGrupo.setGruposModulo(gruposModulo.get());
		usuariosGrupo.setUsuariosSistema(usuario.get());
		usuariosGrupo.setIdUsuarioApl(usuarioLogado.getIdUsuario());
		usuariosGrupoRepository.save(usuariosGrupo);
		
	}
}
