package br.com.crux.cmd;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import br.com.crux.builder.AcessoUnidadeTOBuilder;
import br.com.crux.dao.repository.UnidadeRepository;
import br.com.crux.entity.Unidade;
import br.com.crux.entity.UsuariosSistema;
import br.com.crux.exception.NotFoundException;
import br.com.crux.security.CustomUserDetails;
import br.com.crux.to.AcessoUnidadeTO;
import br.com.crux.to.LoginTO;
import br.com.crux.to.TrocaSenhaTO;
import br.com.crux.to.UsuarioLogadoTO;

@Component
public class AutenticadorCmd {
	
	@Autowired private AuthenticationManager authManager;
	@Autowired private TokenJwtCmd createTokenJwtCmd;
	@Autowired private UnidadeRepository unidadeRepository;
	@Autowired private AcessoUnidadeTOBuilder unidadeTOBuilder;
	@Autowired private TrocarSenhaCmd trocarSenhaCmd;
	@Autowired private GetUsuarioSistemaCmd usuarioSistemaCmd;
	@Autowired private CarregarUnidadeLogadaCmd carregarUnidadeLogadaCmd;
	
	
	public UsuarioLogadoTO autenticar(LoginTO user) {

		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user.getUserName(),user.getSenha());
		Authentication auth = authManager.authenticate(token);

		SecurityContextHolder.getContext().setAuthentication(auth);
		User userSpring = (User) auth.getPrincipal();
		UsuarioLogadoTO usuarioLogadoTO = getUsuarioLogado(userSpring);
		
		if(usuarioLogadoTO.getUnidades().size() == 1) {
			Long idUnidade = usuarioLogadoTO.getUnidades().get(0).getId();
			carregarUnidadeLogadaCmd.carregarUnidadeLogada(idUnidade);
		}

		return usuarioLogadoTO;
	}

	
	public UsuarioLogadoTO refreshToken() {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(Objects.isNull(authentication)) {
			throw new NotFoundException("Problema ao recuperar o usuário logado.");
		}
		
		CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();
		String username = customUserDetails.getUsername();
		UsuariosSistema usuarioByUsername = usuarioSistemaCmd.get(username);
		
		User userSpring = new User(username, usuarioByUsername.getDsSenha(), authentication.getAuthorities());
		UsuarioLogadoTO usuarioLogadoTO = getUsuarioLogado(userSpring);
		
		if(Objects.nonNull(authentication.getPrincipal())) {
			usuarioLogadoTO.setUnidadeLogada(((CustomUserDetails)authentication.getPrincipal()).getUnidadeLogada());
		}

		return usuarioLogadoTO;
	}
	
	
	public void trocarSenha(TrocaSenhaTO trocaSenhaTO) {
		trocarSenhaCmd.trocarSenha(trocaSenhaTO);
	}
	
	

	private UsuarioLogadoTO getUsuarioLogado(User userSpring) {
		String jwt = createTokenJwtCmd.createToken(userSpring.getUsername(), userSpring);
		
		UsuarioLogadoTO usuarioLogadoTO = new UsuarioLogadoTO();
		usuarioLogadoTO.setToken(jwt);
		usuarioLogadoTO.setUsername(userSpring.getUsername());
		
		List<AcessoUnidadeTO> unidades = new ArrayList<>();
		userSpring.getAuthorities().stream().forEach( autho -> {
			Optional<Unidade> unidade = unidadeRepository.findBySiglaUnidade(autho.getAuthority().replace("ROLE_", ""));
			
			if(unidade.isPresent()) {
				unidades.add(unidadeTOBuilder.build(unidade.get()));
			}
		});
		
		usuarioLogadoTO.setUnidades(unidades);
		return usuarioLogadoTO;
	}

}
