package br.com.crux.cmd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.UsuariosSistemaTOBuilder;
import br.com.crux.dao.repository.UsuarioSistemaRepository;
import br.com.crux.entity.UsuariosSistema;
import br.com.crux.exception.NotFoundException;
import br.com.crux.rule.CamposObrigatoriosUsuariosSistemaRule;
import br.com.crux.security.CustomPasswordEncoder;
import br.com.crux.to.UsuariosSistemaTO;

@Component
public class AlterarUsuariosSistemaCmd {

	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;
	@Autowired private UsuarioSistemaRepository repository;
	@Autowired private CamposObrigatoriosUsuariosSistemaRule camposObrigatoriosRule;
	@Autowired private UsuariosSistemaTOBuilder toBuilder;
	@Autowired private AlterarPessoaFisicaCmd alterarPessoaFisicaCmd;
	@Autowired private CustomPasswordEncoder customPasswordEncoder;
	
	public UsuariosSistemaTO alterar(UsuariosSistemaTO to) {
		camposObrigatoriosRule.verificar(to);
		
		UsuariosSistema usuarioSistema = repository.findById(to.getIdUsuario()).orElseThrow((() -> new NotFoundException("Usuário informado não existe.")));
		to.setUsuarioAlteracao(getUsuarioLogadoCmd.getUsuarioLogado().getIdUsuario());
		
		usuarioSistema = toBuilder.build(to);
		usuarioSistema.setPessoaFisica(alterarPessoaFisicaCmd.alterar(to.getPessoaFisica()));
		
		if(to.getStTrocaSenha()) {
			String novaSenhaEncode = customPasswordEncoder.encode( to.getPessoaFisica().getCpf().toString() );
			usuarioSistema.setSenha( novaSenhaEncode );
			usuarioSistema.setQtdAcessoNegado(0L);
		}
		
		UsuariosSistema usuarioSalvo = repository.save(usuarioSistema);
		return toBuilder.buildTO(usuarioSalvo);
	}
}
