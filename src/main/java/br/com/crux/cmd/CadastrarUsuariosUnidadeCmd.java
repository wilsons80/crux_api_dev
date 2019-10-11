package br.com.crux.cmd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.UsuarioUnidadeTOBuilder;
import br.com.crux.dao.repository.UsuariosUnidadeRepository;
import br.com.crux.entity.Unidade;
import br.com.crux.entity.UsuariosSistema;
import br.com.crux.entity.UsuariosUnidade;
import br.com.crux.rule.CamposObrigatoriosUsuariosUnidadeRule;

@Component
public class CadastrarUsuariosUnidadeCmd {

	@Autowired private CamposObrigatoriosUsuariosUnidadeRule camposObrigatoriosUsuariosUnidadeRule;
	@Autowired private UsuarioUnidadeTOBuilder usuarioUnidadeTOBuilder;
	@Autowired private UsuariosUnidadeRepository usuariosUnidadeRepository;

	public UsuariosUnidade cadastrar(UsuariosSistema usuarioSistema, Unidade unidade) {
		camposObrigatoriosUsuariosUnidadeRule.verificar(usuarioSistema, unidade);
		UsuariosUnidade entity = usuarioUnidadeTOBuilder.build(usuarioSistema, unidade);
		return usuariosUnidadeRepository.save(entity);
	}
}
