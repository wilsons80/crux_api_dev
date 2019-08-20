package br.com.crux.cmd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import br.com.crux.entity.UsuariosSistema;
import br.com.crux.repository.UsuarioSistemaRepository;


@Component
public class GetUsuarioAutenticadoCmd implements UserDetailsService{
	
	@Autowired private UsuarioSistemaRepository usuarioSistemaRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UsuariosSistema> result = usuarioSistemaRepository.findByUsername(username);
		
		if(!result.isPresent()) throw new UsernameNotFoundException("Não existe usuário com username = " + username);
		
		UsuariosSistema user = result.get();
		
		List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
		//user.getUsuariosUnidades().forEach(unidades -> roles.add(new SimpleGrantedAuthority("ROLE_" + unidades.getUnidade().getCdUnidade().replaceAll(" ", "_").toUpperCase())));
		List<GrantedAuthority> authorities = roles;
		
		User userSpring = new User(user.getUsername(), user.getDsSenha(), authorities);
		
		return userSpring;
	}
	

	public UsuariosSistema loadUserById(Long id) throws UsernameNotFoundException {
		Optional<UsuariosSistema> result = usuarioSistemaRepository.findById(id);
		
		if(!result.isPresent()) throw new UsernameNotFoundException("Não existe usuário com o id = " + id);
		
		UsuariosSistema user = result.get();
		
		return user;
	}

	
}
