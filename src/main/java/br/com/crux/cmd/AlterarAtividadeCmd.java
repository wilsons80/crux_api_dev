package br.com.crux.cmd;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.PlanosAcaoTOBuilder;
import br.com.crux.builder.ProjetoTOBuilder;
import br.com.crux.builder.UnidadeBuilder;
import br.com.crux.dao.repository.AtividadeRepository;
import br.com.crux.entity.Atividade;
import br.com.crux.exception.NotFoundException;
import br.com.crux.rule.CamposObrigatoriosAtividadeRule;
import br.com.crux.to.AtividadeTO;
import br.com.crux.to.UsuarioLogadoTO;

@Component
public class AlterarAtividadeCmd {

	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;
	@Autowired private AtividadeRepository repository;
	
	@Autowired private UnidadeBuilder unidadeBuilder;
	@Autowired private ProjetoTOBuilder projetoBuilder;
	@Autowired private PlanosAcaoTOBuilder planosAcaoBuilder;
	
	@Autowired private CamposObrigatoriosAtividadeRule camposObrigatoriosRule;
	
	
	public void alterar(AtividadeTO to) {
		Optional<Atividade> entityOptional = repository.findById(to.getId());
		if(!entityOptional.isPresent()) {
			throw new NotFoundException("Atividade informado não existe.");
		}
		
		if(Objects.isNull(to.getUnidade())) {
			throw new NotFoundException("Unidade não informada.");
		}
		if(Objects.isNull(to.getProjeto())) {
			throw new NotFoundException("Projeto não informado.");
		}
		if(Objects.isNull(to.getPlanosAcao())) {
			throw new NotFoundException("Plano de Ação não informado.");
		}
		
		
		camposObrigatoriosRule.verificar(to.getDataInicio(), to.getDescricao(), to.getUnidade().getIdUnidade(), to.getProjeto().getId(), to.getPlanosAcao().getId());
		
		Atividade entity = entityOptional.get();

		entity.setId(to.getId());
		entity.setDescricao(to.getDescricao());
		entity.setDescricaoLocalExecucao(to.getDescricaoLocalExecucao());
		entity.setDataFim(to.getDataFim());
		entity.setDataInicio(to.getDataInicio());
		entity.setDataPrevisaoInicio(to.getDataPrevisaoInicio());
		entity.setDataPrevisaoTermino(to.getDataPrevisaoTermino());
		entity.setHoraFim(to.getHoraFim());
		entity.setHoraInicio(to.getHoraInicio());
		entity.setNumeroAulas(to.getNumeroAulas());
		entity.setCargaHoraria(to.getCargaHoraria());
		entity.setMaximoParticipantes(to.getMaximoParticipantes());
		entity.setPeriodoAtividade(to.getPeriodoAtividade());
		entity.setHorarioFixo(to.getHorarioFixo());
		entity.setLocalExecucao(to.getLocalExecucao());
		entity.setSegunda(to.getSegunda());
		entity.setTerca(to.getTerca());
		entity.setQuarta(to.getQuarta());
		entity.setQuinta(to.getQuinta());
		entity.setSexta(to.getSexta());
		entity.setSabado(to.getSabado());
		entity.setDomingo(to.getDomingo());
		entity.setObservacoes(to.getObservacoes());
		entity.setValorCustoAtividade(to.getValorCustoAtividade());
		entity.setUnidade(unidadeBuilder.build(to.getUnidade()));
		entity.setProjeto(projetoBuilder.build(to.getProjeto()));
		entity.setPlanosAcao(planosAcaoBuilder.build(to.getPlanosAcao()));
		
		UsuarioLogadoTO usuarioLogado = getUsuarioLogadoCmd.getUsuarioLogado();
		entity.setUsuarioAlteracao(usuarioLogado.getIdUsuario());
		
		repository.save(entity);
		
	}
}
