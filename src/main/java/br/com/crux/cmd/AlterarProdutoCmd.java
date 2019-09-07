package br.com.crux.cmd;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.dao.repository.ProdutoRepository;
import br.com.crux.entity.Produto;
import br.com.crux.exception.NotFoundException;
import br.com.crux.to.ProdutoTO;
import br.com.crux.to.UsuarioLogadoTO;

@Component
public class AlterarProdutoCmd {

	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;
	@Autowired private ProdutoRepository repository;
	
	
	public void alterar(ProdutoTO to) {
		Optional<Produto> entityOptional = repository.findById(to.getId());
		if(!entityOptional.isPresent()) {
			throw new NotFoundException("Produto informado não existe.");
		}
		
		Produto entity = entityOptional.get();

		entity.setId(to.getId());
		entity.setNome(to.getNome());
		entity.setNomeProdutoNatafiscal(to.getNomeProdutoNatafiscal());
		entity.setCodigoUnidadeMedida(to.getCodigoUnidadeMedida());
		entity.setDescricaoUnidadeMedida(to.getDescricaoUnidadeMedida());
		
		UsuarioLogadoTO usuarioLogado = getUsuarioLogadoCmd.getUsuarioLogado();
		entity.setUsuarioAlteracao(usuarioLogado.getIdUsuario());
		
		repository.save(entity);
		
	}
}
