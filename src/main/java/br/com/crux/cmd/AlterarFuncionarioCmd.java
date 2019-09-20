package br.com.crux.cmd;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.CargosTOBuilder;
import br.com.crux.builder.EmpresaTOBuilder;
import br.com.crux.builder.FuncionarioTOBuilder;
import br.com.crux.builder.PessoaFisicaTOBuilder;
import br.com.crux.builder.UnidadeTOBuilder;
import br.com.crux.dao.repository.FuncionarioRepository;
import br.com.crux.entity.Funcionario;
import br.com.crux.exception.NotFoundException;
import br.com.crux.rule.CamposObrigatoriosCargosRule;
import br.com.crux.rule.CamposObrigatoriosFuncionarioRule;
import br.com.crux.rule.CamposObrigatoriosPessoaFisicaRule;
import br.com.crux.to.FuncionarioTO;
import br.com.crux.to.UsuarioLogadoTO;

@Component
public class AlterarFuncionarioCmd {

	@Autowired private FuncionarioRepository repository;
	@Autowired private FuncionarioTOBuilder funcionarioTOBuilder;
	@Autowired private CamposObrigatoriosFuncionarioRule camposObrigatoriosRule;
	@Autowired private CamposObrigatoriosPessoaFisicaRule camposObrigatoriosPessoaFisicaRule;
	@Autowired private CamposObrigatoriosCargosRule camposObrigatoriosCargosRule;
	
	@Autowired private CargosTOBuilder cargoTOBuilder;
	@Autowired private PessoaFisicaTOBuilder pessoaFisicaTOBuilder; 
	@Autowired private UnidadeTOBuilder unidadeBuilder;
	@Autowired private EmpresaTOBuilder empresaTOBuilder;
	
	
	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;
	
	
	public void alterar(FuncionarioTO to) {
		Optional<Funcionario> entityOptional = repository.findById(to.getId());
		if(!entityOptional.isPresent()) {
			throw new NotFoundException("Funcionario informado não existe.");
		}
		
		if(Objects.isNull(to.getUnidade())) {
			throw new NotFoundException("UnidAtividadeade não informada.");
		}
		
		if(Objects.isNull(to.getPessoasFisica())) {
			throw new NotFoundException("Pessoa Física não informada.");
		}
		
		if(Objects.isNull(to.getEmpresaFuncionario())) {
			throw new NotFoundException("Empresa do Funcionário não informada.");
		}
		
		if(Objects.isNull(to.getCargo())) {
			throw new NotFoundException("Cargo não informado.");
		}	
		
		camposObrigatoriosCargosRule.verificar(to.getCargo().getCodigo(), to.getCargo().getNome(), to.getCargo().getTipoCargo());
		camposObrigatoriosPessoaFisicaRule.verificar(to.getPessoasFisica().getNome(), to.getPessoasFisica().getCpf(), to.getPessoasFisica().getEndereco(), to.getPessoasFisica().getCelular());
		camposObrigatoriosRule.verificar(to.getMatricula(), to.getDataAdmissao(), to.getCargo().getId(), to.getPessoasFisica().getId(), to.getUnidade().getIdUnidade(), to.getEmpresaFuncionario().getId());
		
		Funcionario entity = entityOptional.get();
		
		entity.setMatricula(to.getMatricula());
		entity.setDataAdmissao(to.getDataAdmissao());
		entity.setDataDemissao(to.getDataDemissao());
		entity.setTipoFuncionario(to.getTipoFuncionario());
		entity.setSalarioPretendido(to.getSalarioPretendido());
		entity.setCargo(cargoTOBuilder.build(to.getCargo()));
		entity.setPessoasFisica(pessoaFisicaTOBuilder.build(to.getPessoasFisica()));
		entity.setUnidade(unidadeBuilder.build(to.getUnidade()));
		entity.setDtHrEntrevista(to.getDtHrEntrevista());
		entity.setParecerEntrevistador(to.getParecerEntrevistador());
		entity.setDescricaoParecerEntrevistador(to.getDescricaoParecerEntrevistador());
		entity.setConclusaoParecer(to.getConclusaoParecer());
		entity.setEmpresaFuncionario(empresaTOBuilder.build(to.getEmpresaFuncionario()));
		entity.setUsuarioAlteracao(to.getUsuarioAlteracao());
		entity.setFuncionarioEntrevistador(funcionarioTOBuilder.getFuncionarioEntrevistador(to.getFuncionarioEntrevistador()));
		
		UsuarioLogadoTO usuarioLogado = getUsuarioLogadoCmd.getUsuarioLogado();
		entity.setUsuarioAlteracao(usuarioLogado.getIdUsuario());
		
		repository.save(entity);
		
	}
}
