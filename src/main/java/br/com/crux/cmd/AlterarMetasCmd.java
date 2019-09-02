package br.com.crux.cmd;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.IndicadoresTOBuilder;
import br.com.crux.dao.repository.MetasRepository;
import br.com.crux.entity.Metas;
import br.com.crux.entity.UsuariosSistema;
import br.com.crux.exception.NotFoundException;
import br.com.crux.rule.CamposObrigatoriosMetasRule;
import br.com.crux.to.MetasTO;

@Component
public class AlterarMetasCmd {

	@Autowired private MetasRepository metasRepository;
	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;
	@Autowired private IndicadoresTOBuilder indicadoresTOBuilder;
	@Autowired private CamposObrigatoriosMetasRule camposObrigatoriosRule;
	
	
	public void alterar(MetasTO to) {
		Optional<Metas> entityOptional = metasRepository.findById(to.getId());
		if(!entityOptional.isPresent()) {
			throw new NotFoundException("Meta informada não existe.");
		}
		
		if(Objects.isNull(to.getIndicadores())) {
			throw new NotFoundException("Indicador não informado.");
		}
		
		camposObrigatoriosRule.verificar(to.getNome(), to.getDataInicio(), to.getIndicadores().getIdIndicador());
		
		Metas entityUpdate = entityOptional.get();

		entityUpdate.setDescricao(to.getNome());
		entityUpdate.setDataInicio(to.getDataInicio());
		entityUpdate.setDataFim(to.getDataFim());

		entityUpdate.setIndicadores(indicadoresTOBuilder.build(to.getIndicadores()));
		
		UsuariosSistema usuarioLogado = getUsuarioLogadoCmd.getUsuarioLogado();
		entityUpdate.setUsuarioAlteracao(usuarioLogado.getIdUsuario());
		
		metasRepository.save(entityUpdate);
		
	}
}
