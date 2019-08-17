package br.com.crux.cmd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import br.com.crux.entity.UsuariosSistema;
import br.com.crux.repository.AutenticadorRepository;


@Component
public class GetUsuarioAutenticadoCmd implements UserDetailsService{
	
	@Autowired private AutenticadorRepository autenticadorRepository;
	
	
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UsuariosSistema> result = autenticadorRepository.findByUsername(username);
		
		if(!result.isPresent()) throw new UsernameNotFoundException("Não existe usuário com username = " + username);
		
		UsuariosSistema user = result.get();
		
		List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
		user.getUsuariosUnidades().forEach(unidades -> roles.add(new SimpleGrantedAuthority("ROLE_" + unidades.getUnidade().getCdUnidade().replaceAll(" ", "_").toUpperCase())));
		
		List<GrantedAuthority> authorities = roles;
		
		User userSpring = new User(user.getUsername(), user.getDsSenha(), authorities);
		
		
		
		
		return userSpring;
	}
	
	public UsuariosSistema loadUserByUsername1(String username) throws UsernameNotFoundException {
		Optional<UsuariosSistema> result = autenticadorRepository.findByUsername(username);
		
		if(!result.isPresent()) throw new UsernameNotFoundException("Não existe usuário com username = " + username);
		
		UsuariosSistema user = result.get();
		
		return user;
	}

}
