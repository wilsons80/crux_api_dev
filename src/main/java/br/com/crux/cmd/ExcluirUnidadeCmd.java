package br.com.crux.cmd;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import br.com.crux.dao.repository.UnidadeRepository;
import br.com.crux.entity.Unidade;
import br.com.crux.exception.NotFoundException;
import br.com.crux.exception.base.NegocioException;
import br.com.crux.to.UnidadeTO;

@Component
public class ExcluirUnidadeCmd {

	@Autowired
	private UnidadeRepository unidadeRepository;
	@Autowired
	private GetUnidadeCmd getUnidadeCmd;
	
	public void excluir(Long idUnidade) {
		Optional<UnidadeTO> unidadeApagar = getUnidadeCmd.getUnidadeUsuarioLogadoComAcesso(idUnidade);
		if(!unidadeApagar.isPresent()) {
			throw new NotFoundException("Usuário não tem permissão para excluir essa unidade.");
		}
		
		Optional<Unidade> unidade = unidadeRepository.findById(idUnidade);
		try {
			unidadeRepository.delete(unidade.get());
		} catch (DataIntegrityViolationException e) {
			throw new NegocioException("Erro ao excluir, existe usuário vinculado a essa unidade.");
		}
	}
}
