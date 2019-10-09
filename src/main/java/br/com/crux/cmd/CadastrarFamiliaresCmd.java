package br.com.crux.cmd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.FamiliaresTOBuilder;
import br.com.crux.dao.repository.FamiliaresRepository;
import br.com.crux.entity.Familiares;
import br.com.crux.rule.CamposObrigatoriosFamiliaresRule;
import br.com.crux.to.FamiliaresTO;
import br.com.crux.to.UsuarioLogadoTO;

@Component
public class CadastrarFamiliaresCmd {

	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;
	
	@Autowired private FamiliaresRepository repository;
	@Autowired private CamposObrigatoriosFamiliaresRule camposObrigatoriosRule;
	@Autowired private FamiliaresTOBuilder familiaresTOBuilder;
	
	public void cadastrar(FamiliaresTO to) {
		camposObrigatoriosRule.verificar(to);
		
		Familiares entity = familiaresTOBuilder.build(to);
		UsuarioLogadoTO usuarioLogado = getUsuarioLogadoCmd.getUsuarioLogado();
		entity.setUsuarioAlteracao(usuarioLogado.getIdUsuario());
		
		repository.save(entity);
		
	}
}
