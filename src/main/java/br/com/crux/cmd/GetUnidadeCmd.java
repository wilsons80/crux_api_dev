package br.com.crux.cmd;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
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
import br.com.crux.to.AcessoUnidadeTO;
import br.com.crux.to.UnidadeTO;

@Component
public class GetUnidadeCmd {

	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;
	@Autowired private AcessoUnidadeTOBuilder acessoUnidadeTOBuilder;
	@Autowired private UnidadeRepository unidadeRepository;
	@Autowired private UnidadeBuilder unidadeBuilder;
	
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

}
