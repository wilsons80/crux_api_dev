package br.com.crux.cmd;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.AtividadesTOBuilder;
import br.com.crux.builder.PessoaFisicaTOBuilder;
import br.com.crux.dao.repository.AtividadeRepository;
import br.com.crux.dao.repository.CadastroReservaAtividadeRepository;
import br.com.crux.dao.repository.PessoaFisicaRepository;
import br.com.crux.entity.Atividades;
import br.com.crux.entity.CadastroReservaAtividade;
import br.com.crux.entity.PessoaFisica;
import br.com.crux.exception.NotFoundException;
import br.com.crux.rule.CamposObrigatoriosCadastroReservaAtividadeRule;
import br.com.crux.to.CadastroReservaAtividadeTO;
import br.com.crux.to.UsuarioLogadoTO;

@Component
public class CadastrarCadastroReservaAtividadeCmd {

	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;
	@Autowired private CadastroReservaAtividadeRepository repository;
	
	@Autowired private AtividadeRepository atividadeRepository;
	@Autowired private PessoaFisicaRepository pessoaFisicaRepository;
	
	@Autowired private AtividadesTOBuilder atividadeBuilder;
	@Autowired private PessoaFisicaTOBuilder pessoaFisicaBuilder;
	
	@Autowired private CamposObrigatoriosCadastroReservaAtividadeRule camposObrigatoriosRule;
	
	
	public void cadastrar(CadastroReservaAtividadeTO to) {
		
		if(Objects.isNull(to.getAtividade())) {
			throw new NotFoundException("Atividade não informada.");
		}

		if(Objects.isNull(to.getPessoasFisica())) {
			throw new NotFoundException("Pessoa Física não informada.");
		}
		
		camposObrigatoriosRule.verificar(to.getAtividade().getId(), to.getPessoasFisica().getId());
		
		Optional<Atividades> atividadeOptional = atividadeRepository.findById(to.getAtividade().getId());
		if(!atividadeOptional.isPresent()) {
			throw new NotFoundException("Atividade informado não existe.");
		}
		Optional<PessoaFisica> pessoaFisicaOptional = pessoaFisicaRepository.findById(to.getPessoasFisica().getId());
		if(!pessoaFisicaOptional.isPresent()) {
			throw new NotFoundException("Pessoa Física informada não existe.");
		}
	
				
		CadastroReservaAtividade entity = new CadastroReservaAtividade();

		entity.setId(to.getId());
		entity.setDescricaoCadastroReserva(to.getDescricaoCadastroReserva());
		entity.setDescricaoCancelamentoCadastro(to.getDescricaoCancelamentoCadastro());
		entity.setDataCadastroReserva(to.getDataCadastroReserva());
		entity.setDataCancelamentoCadastro(to.getDataCancelamentoCadastro());
		entity.setDataCadastroAtividade(to.getDataCadastroAtividade());
		entity.setDtAlteracaoAtividade(to.getDtAlteracaoAtividade());
		entity.setAtividade(atividadeBuilder.build(to.getAtividade()));
		entity.setPessoasFisica(pessoaFisicaBuilder.build(to.getPessoasFisica()));
		
		UsuarioLogadoTO usuarioLogado = getUsuarioLogadoCmd.getUsuarioLogado();
		entity.setUsuarioCadastro(usuarioLogado.getIdUsuario());
		//entity.setUsuarioUltimaAlteracao(usuarioLogado.getIdUsuario());
		entity.setUsuarioAlteracao(usuarioLogado.getIdUsuario());
		
		repository.save(entity);
		
	}
}
