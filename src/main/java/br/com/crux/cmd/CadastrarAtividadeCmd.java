package br.com.crux.cmd;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.PlanosAcaoTOBuilder;
import br.com.crux.builder.ProjetoTOBuilder;
import br.com.crux.builder.UnidadeBuilder;
import br.com.crux.dao.repository.AtividadeRepository;
import br.com.crux.dao.repository.PlanosAcaoRepository;
import br.com.crux.dao.repository.ProjetoRepository;
import br.com.crux.dao.repository.UnidadeRepository;
import br.com.crux.entity.Atividade;
import br.com.crux.entity.PlanosAcao;
import br.com.crux.entity.Projeto;
import br.com.crux.entity.Unidade;
import br.com.crux.exception.NotFoundException;
import br.com.crux.rule.CamposObrigatoriosAtividadeRule;
import br.com.crux.to.AtividadeTO;
import br.com.crux.to.UsuarioLogadoTO;

@Component
public class CadastrarAtividadeCmd {

	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;
	@Autowired private AtividadeRepository repository;
	
	@Autowired private UnidadeBuilder unidadeBuilder;
	@Autowired private ProjetoTOBuilder projetoBuilder;
	@Autowired private PlanosAcaoTOBuilder planosAcaoBuilder;
	
	@Autowired private UnidadeRepository unidadeRepository;
	@Autowired private ProjetoRepository projetoRepository;
	@Autowired private PlanosAcaoRepository planoAcaoRepository;
	
	@Autowired private CamposObrigatoriosAtividadeRule camposObrigatoriosRule;
	
	
	public void cadastrar(AtividadeTO to) {
		
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

		
		Optional<Unidade> unidade = unidadeRepository.findById(to.getUnidade().getIdUnidade());
		if(!unidade.isPresent()) {
			throw new NotFoundException("Unidade informada não existe.");
		}
		Optional<Projeto> projeto = projetoRepository.findById(to.getUnidade().getIdUnidade());
		if(!projeto.isPresent()) {
			throw new NotFoundException("Projeto informado não existe.");
		}
		Optional<PlanosAcao> planoAcao = planoAcaoRepository.findById(to.getUnidade().getIdUnidade());
		if(!planoAcao.isPresent()) {
			throw new NotFoundException("Plano de Ação informado não existe.");
		}
		
				
		Atividade entity = new Atividade();

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
