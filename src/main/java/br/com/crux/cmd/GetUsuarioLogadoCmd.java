package br.com.crux.cmd;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import br.com.crux.exception.NotFoundException;
import br.com.crux.to.UsuarioLogadoTO;

@Component
public class GetUsuarioLogadoCmd {

	private static ThreadLocal<Map<String, UsuarioLogadoTO>> usuarios = new ThreadLocal<Map<String, UsuarioLogadoTO>>();
	
	public Authentication getAuthentication() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(Objects.isNull(authentication)) {
			throw new NotFoundException("Problema ao recuperar o usuário autenticado.");
		}
		return authentication;
	}
	
	public UsuarioLogadoTO getUsuarioLogado() {
		Authentication authentication = getAuthentication();
		String username = authentication.getName();
		
		UsuarioLogadoTO usuarioLogado = (UsuarioLogadoTO) get(username);
		if(usuarioLogado == null) {
			throw new NotFoundException("Erro ao recuperar o usuário logado.");
		}

		return usuarioLogado;
	}

	
	
	
	
	/**
	 * Cria um atributo no contexto da thread. Se o atributo existir, o valor é substituído.
	 *
	 * @param key
	 *            nome do atributo/propriedade.
	 * @param val
	 *            valor a ser atribuído ao atributo/propriedade.
	 */
	public static void set(String key, UsuarioLogadoTO val) {
		Map<String, UsuarioLogadoTO> vals = getVals();
		vals.put(key, val);
	}

	private static Map<String, UsuarioLogadoTO> getVals() {
		Map<String, UsuarioLogadoTO> vals = usuarios.get();
		if (vals == null) {
			vals = new HashMap<String, UsuarioLogadoTO>();
			usuarios.set(vals);			
		}
		return vals;
	}

	/**
	 * Obtém o valor de um atributo/propriedade contida no contexto de Thread.
	 *
	 * @param <T>
	 *            O tipo do atributo/propriedade
	 * @param key
	 *            o nome do atributo/propriedade.
	 * @return o valor do atributo/propriedade.
	 */
	@SuppressWarnings("unchecked")
	public static <T> T get(String key) {
		Map<String, UsuarioLogadoTO> vals = getVals();
		return (T) vals.get(key);
	}

	/**
	 * Destroi todos os atributos armazenados no contexto de Thread. Este método deve ser chamado principalmente ao final de cada request. Isto é importante porque, em um servidor
	 * de aplicações, é normal acontecer de o mesmo thread ser usado no processamento de requests de usuários diferentes. Se o método 'reset' não for invocado, pode acontecer de
	 * dados de uma request serem considerados em outras processadas pelo mesmo thread.
	 */
	public static void reset() {
		usuarios.set(null);
	}
	
}
