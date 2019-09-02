package br.com.crux.cmd;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.IndicadoresTOBuilder;
import br.com.crux.dao.repository.IndicadoresRepository;
import br.com.crux.dao.repository.MetasRepository;
import br.com.crux.entity.Indicadores;
import br.com.crux.entity.Metas;
import br.com.crux.entity.UsuariosSistema;
import br.com.crux.exception.NotFoundException;
import br.com.crux.exception.ParametroNaoInformadoException;
import br.com.crux.rule.CamposObrigatoriosMetasRule;
import br.com.crux.to.MetasTO;

@Component
public class CadastrarMetasCmd {

	@Autowired private MetasRepository metasRepository;
	@Autowired private IndicadoresRepository indicadoresRepository;  
	@Autowired private IndicadoresTOBuilder indicadoresTOBuilder; 
	@Autowired private CamposObrigatoriosMetasRule camposObrigatoriosRule;
	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;
	
	public void cadastrar(MetasTO to) {
		
		if(Objects.isNull(to.getIndicadores())) {
			throw new ParametroNaoInformadoException("Indicador não foi informado.");
		}
		
		Optional<Indicadores> objetivo = indicadoresRepository.findById(to.getIndicadores().getIdIndicador());
		if(!objetivo.isPresent()) {
			throw new NotFoundException("Indicador informado não existe.");
		}
		
		camposObrigatoriosRule.verificar(to.getNome(), to.getDataInicio(), to.getIndicadores().getIdIndicador());
		
		Metas entity = new Metas();

		entity.setDescricao(to.getNome());
		entity.setDataInicio(to.getDataInicio());
		entity.setDataFim(to.getDataFim());
		
		entity.setIndicadores(indicadoresTOBuilder.build(to.getIndicadores()));
		
		UsuariosSistema usuarioLogado = getUsuarioLogadoCmd.getUsuarioLogado();
		entity.setUsuarioAlteracao(usuarioLogado.getIdUsuario());
		
		metasRepository.save(entity);
		
	}
}
