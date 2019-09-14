package br.com.crux.cmd;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.dao.repository.CargoRepository;
import br.com.crux.entity.Cargo;
import br.com.crux.exception.NotFoundException;
import br.com.crux.rule.CamposObrigatoriosCargosRule;
import br.com.crux.to.CargoTO;
import br.com.crux.to.UsuarioLogadoTO;

@Component
public class AlterarCargosCmd {

	@Autowired private CargoRepository repository;
	
	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;
	@Autowired private CamposObrigatoriosCargosRule camposObrigatoriosRule;
	
	
	public void alterar(CargoTO to) {
		Optional<Cargo> entityOptional = repository.findById(to.getId());
		if(!entityOptional.isPresent()) {
			throw new NotFoundException("Cargo formação informado não existe.");
		}
		
		camposObrigatoriosRule.verificar(to.getCodigo(), to.getNome(), to.getTipoCargo());
		
		Cargo entity = entityOptional.get();

		entity.setNome(to.getNome());
		entity.setCodigo(to.getCodigo());
		entity.setTipoCargo(to.getTipoCargo());
		
		UsuarioLogadoTO usuarioLogado = getUsuarioLogadoCmd.getUsuarioLogado();
		entity.setUsuarioAlteracao(usuarioLogado.getIdUsuario());
		
		repository.save(entity);
		
	}
}
