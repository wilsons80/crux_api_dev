package br.com.crux.cmd;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.UsuariosUnidadeTOBuilder;
import br.com.crux.dao.repository.UsuariosUnidadeRepository;
import br.com.crux.entity.UsuariosUnidade;
import br.com.crux.rule.CamposObrigatoriosUsuariosUnidadeRule;
import br.com.crux.to.UsuariosUnidadesTO;

@Component
public class AlterarUsuariosUnidadeCmd {

	@Autowired private CamposObrigatoriosUsuariosUnidadeRule camposObrigatoriosUsuariosUnidadeRule;
	@Autowired private UsuariosUnidadeTOBuilder usuarioUnidadeTOBuilder;
	@Autowired private UsuariosUnidadeRepository usuariosUnidadeRepository;

	public void alterar(UsuariosUnidadesTO usuarioUnidade) {
		camposObrigatoriosUsuariosUnidadeRule.verificar(usuarioUnidade);
		UsuariosUnidade entity = usuarioUnidadeTOBuilder.build(usuarioUnidade);
		usuariosUnidadeRepository.save(entity);
	}
	
	public void alterarAll(List<UsuariosUnidadesTO> lista) {
		lista.stream().forEach(usuarioUnidade -> {
			alterar(usuarioUnidade);
		});
	}

}
