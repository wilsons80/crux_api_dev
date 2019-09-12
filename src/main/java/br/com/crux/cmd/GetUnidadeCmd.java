package br.com.crux.cmd;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import br.com.crux.builder.UnidadeBuilder;
import br.com.crux.dao.repository.UnidadeRepository;
import br.com.crux.entity.Unidade;
import br.com.crux.enums.ClassificadorSituacaoImovel;
import br.com.crux.enums.TipoUnidade;
import br.com.crux.exception.SemAcessoUnidadeException;
import br.com.crux.to.AcessoUnidadeTO;
import br.com.crux.to.UnidadeTO;
import br.com.crux.to.UsuarioLogadoHolder;
import br.com.crux.to.UsuarioLogadoTO;

@Component
public class GetUnidadeCmd {

	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;
	@Autowired private UnidadeRepository unidadeRepository;
	@Autowired private UnidadeBuilder unidadeBuilder;
	@Autowired private CarregarUnidadeLogadaCmd carregarUnidadeLogadaCmd;
	
	@Autowired private UsuarioLogadoHolder usuarioLogadoHolder;
	
	public List<AcessoUnidadeTO> getUnidadesComAcesso() throws UsernameNotFoundException {
		UsuarioLogadoTO usuarioLogado = usuarioLogadoHolder.getUsuarioLogadoTO();
		return usuarioLogado.getUnidades();
	}

	public Optional<UnidadeTO> getUnidadeUsuarioLogadoComAcesso(Long idUnidade) {
		UsuarioLogadoTO usuarioLogadoTO = usuarioLogadoHolder.getUsuarioLogadoTO();
		
		Optional<Unidade> unidadeOptional = unidadeRepository.findUnidadeDoUsuarioLogado(usuarioLogadoTO.getIdUsuario(), idUnidade);
		if(!unidadeOptional.isPresent()) {
			throw new SemAcessoUnidadeException("Usuário não tem acesso a essa unidade.");
		}

		//Carrega a unidade logada no Contexto do usuário
		AcessoUnidadeTO unidadeLogada = carregarUnidadeLogadaCmd.carregarUnidadeLogada(unidadeOptional.get().getIdUnidade());
		usuarioLogadoTO.setUnidadeLogada(unidadeLogada);
		
		return Optional.ofNullable(unidadeBuilder.buildTO(unidadeOptional.get()));
	}
	
	
	
	public List<UnidadeTO> getAllUnidadesUsuarioLogadoTemAcesso() {
		UsuarioLogadoTO user = getUsuarioLogadoCmd.getUsuarioLogado();
		
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
