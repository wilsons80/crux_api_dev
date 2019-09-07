package br.com.crux.cmd;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.ObjetivoTOBuilder;
import br.com.crux.dao.repository.IndicadoresRepository;
import br.com.crux.dao.repository.ObjetivoRepository;
import br.com.crux.entity.Indicadores;
import br.com.crux.entity.Objetivo;
import br.com.crux.exception.NotFoundException;
import br.com.crux.exception.ParametroNaoInformadoException;
import br.com.crux.rule.CamposObrigatoriosIndicadoresRule;
import br.com.crux.to.IndicadoresTO;
import br.com.crux.to.UsuarioLogadoTO;

@Component
public class CadastrarIndicadoresCmd {

	@Autowired private IndicadoresRepository indicadoresRepository;
	@Autowired private ObjetivoRepository objetivoRepository;  
	@Autowired private ObjetivoTOBuilder objetivoTOBuilder; 
	@Autowired private CamposObrigatoriosIndicadoresRule camposObrigatoriosRule;
	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;
	
	public void cadastrar(IndicadoresTO to) {
		
		if(Objects.isNull(to.getObjetivo())) {
			throw new ParametroNaoInformadoException("Objetivo não foi informado.");
		}
		
		Optional<Objetivo> objetivo = objetivoRepository.findById(to.getObjetivo().getIdObjetivo());
		if(!objetivo.isPresent()) {
			throw new NotFoundException("Perspectiva informada não existe.");
		}
		
		camposObrigatoriosRule.verificar(to.getNome(), to.getDataInicio(), to.getObjetivo().getIdObjetivo());
		
		Indicadores entity = new Indicadores();

		entity.setNome(to.getNome());
		entity.setDataInicio(to.getDataInicio());
		entity.setDataFim(to.getDataFim());
		
		entity.setObjetivo(objetivoTOBuilder.build(to.getObjetivo()));
		
		UsuarioLogadoTO usuarioLogado = getUsuarioLogadoCmd.getUsuarioLogado();
		entity.setUsuarioAlteracao(usuarioLogado.getIdUsuario());
		
		indicadoresRepository.save(entity);
		
	}
}
