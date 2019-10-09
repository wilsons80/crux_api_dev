package br.com.crux.cmd;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.FamiliaresTOBuilder;
import br.com.crux.dao.repository.FamiliaresRepository;
import br.com.crux.entity.Familiares;
import br.com.crux.exception.NotFoundException;
import br.com.crux.rule.CamposObrigatoriosFamiliaresRule;
import br.com.crux.to.FamiliaresTO;
import br.com.crux.to.UsuarioLogadoTO;

@Component
public class AlterarFamiliaresCmd {

	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;
	
	@Autowired private FamiliaresRepository repository;
	@Autowired private CamposObrigatoriosFamiliaresRule camposObrigatoriosRule;
	@Autowired private FamiliaresTOBuilder familiaresTOBuilder;
	
	public void alterar(FamiliaresTO to) {
		camposObrigatoriosRule.verificar(to);
		
		Optional<Familiares> entityOptional = repository.findById(to.getId());
		if(!entityOptional.isPresent()) {
			throw new NotFoundException("Familiar informado não existe.");
		}
		
		Familiares entity = familiaresTOBuilder.build(to);
		
		UsuarioLogadoTO usuarioLogado = getUsuarioLogadoCmd.getUsuarioLogado();
		entity.setUsuarioAlteracao(usuarioLogado.getIdUsuario());
		
		repository.save(entity);
		
	}
}
