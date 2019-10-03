package br.com.crux.cmd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.UsuariosSistemaTOBuilder;
import br.com.crux.dao.repository.UsuarioSistemaRepository;
import br.com.crux.entity.UsuariosSistema;
import br.com.crux.exception.NotFoundException;
import br.com.crux.rule.CamposObrigatoriosUsuariosSistemaRule;
import br.com.crux.to.UsuariosSistemaTO;

@Component
public class AlterarUsuariosSistemaCmd {

	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;
	@Autowired private UsuarioSistemaRepository repository;
	@Autowired private CamposObrigatoriosUsuariosSistemaRule camposObrigatoriosRule;
	@Autowired private UsuariosSistemaTOBuilder toBuilder;
	@Autowired private AlterarPessoaFisicaCmd alterarPessoaFisicaCmd;
	
	public UsuariosSistemaTO alterar(UsuariosSistemaTO to) {
		camposObrigatoriosRule.verificar(to);
		UsuariosSistema usuarioSistema = repository.findById(to.getIdUsuario()).orElseThrow((() -> new NotFoundException("Usuário informado não existe.")));
		to.setUsuarioAlteracao(getUsuarioLogadoCmd.getUsuarioLogado().getIdUsuario());
		
		usuarioSistema = toBuilder.build(to);
		usuarioSistema.setPessoaFisica(alterarPessoaFisicaCmd.alterar(to.getPessoaFisica()));
		
		UsuariosSistema usuarioSalvo = repository.save(usuarioSistema);
		return toBuilder.buildTO(usuarioSalvo);
	}
}
