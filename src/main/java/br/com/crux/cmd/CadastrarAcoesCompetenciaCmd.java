package br.com.crux.cmd;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.TalentosPFTOBuilder;
import br.com.crux.dao.repository.AcoesCompetenciaRepository;
import br.com.crux.entity.AcoesCompetencia;
import br.com.crux.exception.NotFoundException;
import br.com.crux.rule.CamposObrigatoriosAcoesCompentenciaRule;
import br.com.crux.to.AcoesCompetenciaTO;
import br.com.crux.to.UsuarioLogadoTO;

@Component
public class CadastrarAcoesCompetenciaCmd {

	@Autowired private AcoesCompetenciaRepository repository;
	@Autowired private CamposObrigatoriosAcoesCompentenciaRule camposObrigatoriosCargosRule;
	
	@Autowired private TalentosPFTOBuilder talentosPFTOBuilder;
	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;
	
	public void cadastrar(AcoesCompetenciaTO to) {

		if(Objects.isNull(to.getTalentosPf())) {
			throw new NotFoundException("Talento do funcionário não informado.");
		}
		
		camposObrigatoriosCargosRule.verificar(to.getDescricao(), to.getTalentosPf().getId());
		
		AcoesCompetencia entity = new AcoesCompetencia();
		
		entity.setDescricao(to.getDescricao());
		entity.setResultadoAcao(to.getResultadoAcao());
		entity.setResultadoPrevAcao(to.getResultadoPrevAcao());
		entity.setDataInicio(to.getDataInicio());
		entity.setDataFim(to.getDataFim());
		entity.setTalentosPf(talentosPFTOBuilder.build(to.getTalentosPf()));
		
		
		UsuarioLogadoTO usuarioLogado = getUsuarioLogadoCmd.getUsuarioLogado();
		entity.setUsuarioAlteracao(usuarioLogado.getIdUsuario());
		
		repository.save(entity);
	}
}
