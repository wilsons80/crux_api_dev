package br.com.crux.cmd;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.IniciativaTOBuilder;
import br.com.crux.dao.repository.PlanosAcaoRepository;
import br.com.crux.entity.PlanosAcao;
import br.com.crux.exception.NotFoundException;
import br.com.crux.rule.CamposObrigatoriosPlanosAcaoRule;
import br.com.crux.to.PlanosAcaoTO;
import br.com.crux.to.UsuarioLogadoTO;

@Component
public class AlterarPlanosAcaoCmd {

	@Autowired private PlanosAcaoRepository repository;
	@Autowired private IniciativaTOBuilder toBuilder;
	
	@Autowired private CamposObrigatoriosPlanosAcaoRule camposObrigatoriosRule;
	
	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;
	
	
	public void alterar(PlanosAcaoTO to) {
		Optional<PlanosAcao> entityOptional = repository.findById(to.getId());
		if(!entityOptional.isPresent()) {
			throw new NotFoundException("Planos de Acao informado não existe.");
		}
		
		if(Objects.isNull(to.getIniciativa())) {
			throw new NotFoundException("Iniciativa não informado.");
		}
		
		camposObrigatoriosRule.verificar(to.getNome(), to.getDataInicio(), to.getIniciativa().getId());
		
		PlanosAcao entityUpdate = entityOptional.get();

		entityUpdate.setNome(to.getNome());
		entityUpdate.setDataInicio(to.getDataInicio());
		entityUpdate.setDataFim(to.getDataFim());

		entityUpdate.setIniciativa(toBuilder.build(to.getIniciativa()));
		
		UsuarioLogadoTO usuarioLogado = getUsuarioLogadoCmd.getUsuarioLogado();
		entityUpdate.setUsuarioAlteracao(usuarioLogado.getIdUsuario());
		
		repository.save(entityUpdate);
		
	}
}
