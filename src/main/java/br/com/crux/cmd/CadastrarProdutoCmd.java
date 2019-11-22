package br.com.crux.cmd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.dao.repository.ProdutoRepository;
import br.com.crux.entity.Produto;
import br.com.crux.to.ProdutoTO;
import br.com.crux.to.UsuarioLogadoTO;

@Component
public class CadastrarProdutoCmd {

	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;
	@Autowired private ProdutoRepository repository;
	
	
	public void cadastrar(ProdutoTO to) {
				
		Produto entity = new Produto();

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
