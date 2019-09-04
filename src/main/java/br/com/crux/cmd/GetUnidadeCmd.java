package br.com.crux.cmd;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import br.com.crux.builder.AcessoUnidadeTOBuilder;
import br.com.crux.builder.UnidadeBuilder;
import br.com.crux.dao.repository.UnidadeRepository;
import br.com.crux.entity.Unidade;
import br.com.crux.entity.UsuariosSistema;
import br.com.crux.entity.UsuariosUnidade;
import br.com.crux.enums.ClassificadorSituacaoImovel;
import br.com.crux.enums.TipoUnidade;
import br.com.crux.security.CustomUserDetails;
import br.com.crux.to.AcessoUnidadeTO;
import br.com.crux.to.UnidadeTO;

@Component
public class GetUnidadeCmd {

	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;
	@Autowired private AcessoUnidadeTOBuilder acessoUnidadeTOBuilder;
	@Autowired private UnidadeRepository unidadeRepository;
	@Autowired private UnidadeBuilder unidadeBuilder;
	@Autowired private CarregarUnidadeLogadaCmd carregarUnidadeLogadaCmd;
	
	public List<AcessoUnidadeTO> getUnidadesComAcesso() throws UsernameNotFoundException {
		UsuariosSistema user = getUsuarioLogadoCmd.getUsuarioLogado();
		
		return user.getUsuariosUnidades().stream().map((UsuariosUnidade unidade) -> {
			return acessoUnidadeTOBuilder.build(unidade.getUnidade());
		}).collect(Collectors.toList());
	}

	public Optional<UnidadeTO> getUnidadeUsuarioLogadoComAcesso(Long idUnidade) {
		UsuariosSistema user = getUsuarioLogadoCmd.getUsuarioLogado();
		
		Optional<Unidade> unidadeOptional = unidadeRepository.findUnidadeDoUsuarioLogado(user.getIdUsuario(), idUnidade);
		if(!unidadeOptional.isPresent()) {
			return Optional.empty();
		}
		
		//Carrega a unidade logada no Contexto do usuário
		CustomUserDetails customUserDetails = carregarUnidadeLogadaCmd.carregarUnidadeLogada(unidadeOptional.get().getIdUnidade());		
		Authentication authentication = getUsuarioLogadoCmd.get();
		
		authentication = new UsernamePasswordAuthenticationToken(customUserDetails, null, authentication.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		return Optional.ofNullable(unidadeBuilder.buildTO(unidadeOptional.get()));
	}
	
	public List<UnidadeTO> getAllUnidadesUsuarioLogadoTemAcesso() {
		UsuariosSistema user = getUsuarioLogadoCmd.getUsuarioLogado();
		
		Optional<List<Unidade>> unidadesOptional = unidadeRepository.findAllUnidadesDoUsuarioLogado(user.getIdUsuario());
		if(!unidadesOptional.isPresent()) {
			return null;
		}
		
		return unidadeBuilder.buildAllTO(unidadesOptional.get());
	}
	
	public List<TipoUnidade> getAllTiposUnidade() {
		return Arrays.asList(TipoUnidade.values());
	}
	
	public List<ClassificadorSituacaoImovel> getAllClassificadorSituacaoImovel() {
		return Arrays.asList(ClassificadorSituacaoImovel.values());
	}
	
	

	public Unidade getBySigla(String sigla) {
		Optional<Unidade> unidade = unidadeRepository.findBySiglaUnidade(sigla);
		return unidade.orElse(null);
	}
	
	
}
