package br.com.crux.cmd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.UsuariosSistemaTOBuilder;
import br.com.crux.dao.repository.UsuarioSistemaRepository;
import br.com.crux.entity.UsuariosSistema;
import br.com.crux.rule.CamposObrigatoriosUsuariosSistemaRule;
import br.com.crux.to.UsuariosSistemaTO;

@Component
public class CadastrarUsuariosSistemaCmd {

	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;
	@Autowired private UsuarioSistemaRepository repository;
	@Autowired private CamposObrigatoriosUsuariosSistemaRule camposObrigatoriosRule;
	@Autowired private UsuariosSistemaTOBuilder toBuilder;
	@Autowired private CadastrarPessoaFisicaCmd cadastrarPessoaFisicaCmd;
	@Autowired private CadastrarUsuariosUnidadeCmd cadastrarUsuariosUnidadeCmd;
	
	
	public UsuariosSistemaTO cadastrar(UsuariosSistemaTO to) {
		camposObrigatoriosRule.verificar(to);
		to.setUsuarioAlteracao(getUsuarioLogadoCmd.getUsuarioLogado().getIdUsuario());
		
		UsuariosSistema usuarioSistema = toBuilder.build(to);
		usuarioSistema.setPessoaFisica(cadastrarPessoaFisicaCmd.cadastrar(to.getPessoaFisica()));
		
		UsuariosSistema usuarioSalvo = repository.save(usuarioSistema);
	
		cadastrarUsuariosUnidadeCmd.cadastrarAll(to.getUsuariosUnidades());
		
		return toBuilder.buildTO(usuarioSalvo);
	}
}
