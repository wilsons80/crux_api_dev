package br.com.crux.cmd;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.ObjetivoTOBuilder;
import br.com.crux.dao.repository.IndicadoresRepository;
import br.com.crux.entity.Indicadores;
import br.com.crux.exception.NotFoundException;
import br.com.crux.rule.CamposObrigatoriosIndicadoresRule;
import br.com.crux.to.IndicadoresTO;
import br.com.crux.to.UsuarioLogadoTO;

@Component
public class AlterarIndicadoresCmd {

	@Autowired private IndicadoresRepository indicadoresRepository;
	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;
	@Autowired private ObjetivoTOBuilder objetivoTOBuilder;
	@Autowired private CamposObrigatoriosIndicadoresRule camposObrigatoriosRule;
	
	
	public void alterar(IndicadoresTO to) {
		Optional<Indicadores> entityOptional = indicadoresRepository.findById(to.getIdIndicador());
		if(!entityOptional.isPresent()) {
			throw new NotFoundException("Indicador informado não existe.");
		}
		
		if(Objects.isNull(to.getObjetivo())) {
			throw new NotFoundException("Objetivo não informado.");
		}
		
		camposObrigatoriosRule.verificar(to.getNome(), to.getDataInicio(), to.getObjetivo().getIdObjetivo());
		
		Indicadores entityUpdate = entityOptional.get();

		entityUpdate.setNome(to.getNome());
		entityUpdate.setDataInicio(to.getDataInicio());
		entityUpdate.setDataFim(to.getDataFim());

		entityUpdate.setObjetivo(objetivoTOBuilder.build(to.getObjetivo()));
		
		UsuarioLogadoTO usuarioLogado = getUsuarioLogadoCmd.getUsuarioLogado();
		entityUpdate.setUsuarioAlteracao(usuarioLogado.getIdUsuario());
		
		indicadoresRepository.save(entityUpdate);
		
	}
}
