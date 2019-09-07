package br.com.crux.cmd;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.AtividadeTOBuilder;
import br.com.crux.builder.PessoaFisicaTOBuilder;
import br.com.crux.dao.repository.AtividadeRepository;
import br.com.crux.dao.repository.CadastroReservaAtividadeRepository;
import br.com.crux.dao.repository.PessoaFisicaRepository;
import br.com.crux.entity.Atividade;
import br.com.crux.entity.CadastroReservaAtividade;
import br.com.crux.entity.PessoaFisica;
import br.com.crux.exception.NotFoundException;
import br.com.crux.rule.CamposObrigatoriosCadastroReservaAtividadeRule;
import br.com.crux.to.CadastroReservaAtividadeTO;
import br.com.crux.to.UsuarioLogadoTO;

@Component
public class AlterarCadastroReservaAtividadeCmd {

	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;
	@Autowired private CadastroReservaAtividadeRepository repository;
	
	@Autowired private AtividadeRepository atividadeRepository;
	@Autowired private PessoaFisicaRepository pessoaFisicaRepository;
	
	@Autowired private AtividadeTOBuilder atividadeBuilder;
	@Autowired private PessoaFisicaTOBuilder pessoaFisicaBuilder;
	
	@Autowired private CamposObrigatoriosCadastroReservaAtividadeRule camposObrigatoriosRule;
	
	
	public void alterar(CadastroReservaAtividadeTO to) {
		Optional<CadastroReservaAtividade> entityOptional = repository.findById(to.getId());
		if(!entityOptional.isPresent()) {
			throw new NotFoundException("Cadastro reserva atividade informada não existe.");
		}
		
		if(Objects.isNull(to.getAtividade())) {
			throw new NotFoundException("Atividade não informada.");
		}

		if(Objects.isNull(to.getPessoasFisica())) {
			throw new NotFoundException("Pessoa Física não informada.");
		}
		
		camposObrigatoriosRule.verificar(to.getAtividade().getId(), to.getPessoasFisica().getId());
		
		
		Optional<Atividade> atividadeOptional = atividadeRepository.findById(to.getAtividade().getId());
		if(!atividadeOptional.isPresent()) {
			throw new NotFoundException("Atividade informado não existe.");
		}
		Optional<PessoaFisica> pessoaFisicaOptional = pessoaFisicaRepository.findById(to.getPessoasFisica().getId());
		if(!pessoaFisicaOptional.isPresent()) {
			throw new NotFoundException("Pessoa Física informada não existe.");
		}
		
		CadastroReservaAtividade entity = entityOptional.get();

		entity.setId(to.getId());
		entity.setDescricaoCadastroReserva(to.getDescricaoCadastroReserva());
		entity.setDescricaoCancelamentoCadastro(to.getDescricaoCancelamentoCadastro());
		entity.setDataCadastroReserva(to.getDataCadastroReserva());
		entity.setDataCancelamentoCadastro(to.getDataCancelamentoCadastro());
		entity.setDataCadastroAtividade(to.getDataCadastroAtividade());
		entity.setDtAlteracaoAtividade(to.getDtAlteracaoAtividade());
		entity.setAtividade(atividadeBuilder.build(to.getAtividade()));
		entity.setPessoasFisica(pessoaFisicaBuilder.build(to.getPessoasFisica()));
		
		//entity.setUsuarioCadastro(to.getUsuarioCadastro());
		
		UsuarioLogadoTO usuarioLogado = getUsuarioLogadoCmd.getUsuarioLogado();
		entity.setUsuarioUltimaAlteracao(usuarioLogado.getIdUsuario());
		entity.setUsuarioAlteracao(usuarioLogado.getIdUsuario());
		
		repository.save(entity);
		
	}
}
