package br.com.crux.cmd;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.dao.repository.GrupoModuloRepository;
import br.com.crux.dao.repository.ModuloRepository;
import br.com.crux.dao.repository.UnidadeRepository;
import br.com.crux.dao.repository.UsuarioSistemaRepository;
import br.com.crux.dao.repository.UsuariosGrupoRepository;
import br.com.crux.entity.GruposModulo;
import br.com.crux.entity.Modulo;
import br.com.crux.entity.Unidade;
import br.com.crux.entity.UsuariosGrupo;
import br.com.crux.entity.UsuariosSistema;
import br.com.crux.exception.NotFoundException;
import br.com.crux.exception.PerfilAcessoCadastradoException;
import br.com.crux.to.CadastroAcessoTO;
import br.com.crux.to.UsuarioLogadoTO;

@Component
public class AlterarAcessoUsuarioCmd {

	@Autowired private UnidadeRepository unidadeRepository;
	@Autowired private ModuloRepository moduloRepository;
	@Autowired private UsuariosGrupoRepository usuariosGrupoRepository;
	@Autowired private UsuarioSistemaRepository usuarioSistemaRepository;
	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;
	@Autowired private GrupoModuloRepository grupoModuloRepository;
	
	public void alterar(CadastroAcessoTO acessoTO) {
		
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

		
		UsuarioLogadoTO usuarioLogadoTO = getUsuarioLogadoCmd.getUsuarioLogado();
		Optional<UsuariosSistema> usuarioLogado = usuarioSistemaRepository.findById(usuarioLogadoTO.getIdUsuario());
		if(!usuario.isPresent()) {
			throw new NotFoundException("Usuario logado não existe.");
		}		
		
		Optional<UsuariosGrupo> usuarioGrupo = usuariosGrupoRepository.findByGruposModuloAndUsuariosSistema(gruposModulo.get(), usuarioLogado.get());
		if(usuarioGrupo.isPresent()) {
			throw new PerfilAcessoCadastradoException("Usuário já possui esse perfil cadastrado.");
		}
		
		usuarioGrupo.get().setGruposModulo(gruposModulo.get());
		usuarioGrupo.get().setIdUsuarioApl(usuarioLogado.get().getIdUsuario());
		usuariosGrupoRepository.save(usuarioGrupo.get());
		
	}
}
