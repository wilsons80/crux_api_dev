package br.com.crux.cmd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.GrupoModuloTOBuilder;
import br.com.crux.dao.repository.GrupoModuloRepository;
import br.com.crux.entity.GruposModulo;
import br.com.crux.rule.CamposObrigatoriosGrupoModuloRule;
import br.com.crux.to.GrupoModuloTO;

@Component
public class CadastrarGrupoModuloCmd {

	@Autowired private GrupoModuloRepository repository;
	@Autowired private CamposObrigatoriosGrupoModuloRule camposObrigatoriosRule;
	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;
	@Autowired private GrupoModuloTOBuilder toBuilder;

	
	public void cadastrar(GrupoModuloTO to) {
		camposObrigatoriosRule.verificar(to);
		
		to.setUsuarioAlteracao(getUsuarioLogadoCmd.getUsuarioLogado().getIdUsuario());
		GruposModulo entity = toBuilder.buildTO(to);

		repository.save(entity);

	}
}
