package br.com.crux.cmd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.dao.repository.CargoRepository;
import br.com.crux.entity.Cargo;
import br.com.crux.rule.CamposObrigatoriosCargosRule;
import br.com.crux.to.CargoTO;
import br.com.crux.to.UsuarioLogadoTO;

@Component
public class CadastrarCargosCmd {

	@Autowired private CargoRepository repository;
	
	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;
	@Autowired private CamposObrigatoriosCargosRule camposObrigatoriosRule;
	
	public void cadastrar(CargoTO to) {
		
		camposObrigatoriosRule.verificar(to.getCodigo(), to.getNome(), to.getTipoCargo());
		
		
		Cargo entity = new Cargo();

		entity.setNome(to.getNome());
		entity.setCodigo(to.getCodigo());
		entity.setTipoCargo(to.getTipoCargo());
		
		UsuarioLogadoTO usuarioLogado = getUsuarioLogadoCmd.getUsuarioLogado();
		entity.setUsuarioAlteracao(usuarioLogado.getIdUsuario());
		
		repository.save(entity);
		
	}
}
