package br.com.crux.cmd;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.AtividadesTOBuilder;
import br.com.crux.dao.repository.AtividadeRepository;
import br.com.crux.dao.repository.PlanosAcaoRepository;
import br.com.crux.dao.repository.ProjetoRepository;
import br.com.crux.dao.repository.UnidadeRepository;
import br.com.crux.entity.Atividades;
import br.com.crux.entity.PlanosAcao;
import br.com.crux.entity.Projeto;
import br.com.crux.entity.Unidade;
import br.com.crux.exception.NotFoundException;
import br.com.crux.rule.CamposObrigatoriosAtividadeRule;
import br.com.crux.to.AtividadesTO;
import br.com.crux.to.UsuarioLogadoTO;

@Component
public class CadastrarAtividadeCmd {

	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;
	@Autowired private AtividadeRepository repository;
	@Autowired private AtividadesTOBuilder atividadesTOBuilder;  
	
	@Autowired private UnidadeRepository unidadeRepository;
	@Autowired private ProjetoRepository projetoRepository;
	@Autowired private PlanosAcaoRepository planoAcaoRepository;
	
	@Autowired private CamposObrigatoriosAtividadeRule camposObrigatoriosRule;
	
	
	public void cadastrar(AtividadesTO to) {
		
		if(Objects.isNull(to.getUnidade())) {
			throw new NotFoundException("Unidade não informada.");
		}
		if(Objects.isNull(to.getProjeto())) {
			throw new NotFoundException("Projeto não informado.");
		}
		if(Objects.isNull(to.getPlanosAcao())) {
			throw new NotFoundException("Plano de Ação não informado.");
		}
		
		camposObrigatoriosRule.verificar(to.getDataInicio(),  to.getDataPrevisaoInicio(), to.getDescricao(), to.getUnidade().getIdUnidade(), to.getProjeto().getId(), to.getPlanosAcao().getId());

		
		Optional<Unidade> unidade = unidadeRepository.findById(to.getUnidade().getIdUnidade());
		if(!unidade.isPresent()) {
			throw new NotFoundException("Unidade informada não existe.");
		}
		Optional<Projeto> projeto = projetoRepository.findById(to.getProjeto().getId());
		if(!projeto.isPresent()) {
			throw new NotFoundException("Projeto informado não existe.");
		}
		Optional<PlanosAcao> planoAcao = planoAcaoRepository.findById(to.getUnidade().getIdUnidade());
		if(!planoAcao.isPresent()) {
			throw new NotFoundException("Plano de Ação informado não existe.");
		}
		
				
		Atividades entity = new Atividades();

		to.setId(null);
		entity = atividadesTOBuilder.build(to);
		
		UsuarioLogadoTO usuarioLogado = getUsuarioLogadoCmd.getUsuarioLogado();
		entity.setUsuarioAlteracao(usuarioLogado.getIdUsuario());
		
		repository.save(entity);
		
	}
}
