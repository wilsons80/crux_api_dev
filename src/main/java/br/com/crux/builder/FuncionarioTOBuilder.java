package br.com.crux.builder;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.entity.Funcionario;
import br.com.crux.to.FuncionarioTO;


@Component
public class FuncionarioTOBuilder {
	
	@Autowired private CargosTOBuilder cargoTOBuilder;
	@Autowired private PessoaFisicaTOBuilder pessoaFisicaTOBuilder;
	@Autowired private UnidadeBuilder unidadeBuilder;
	@Autowired private EmpresaTOBuilder empresaTOBuilder; 
	

	public Funcionario build(FuncionarioTO p) {
		Funcionario retorno = new Funcionario();
		
		retorno.setId(p.getId());
		retorno.setMatricula(p.getMatricula());
		retorno.setDataAdmissao(p.getDataAdmissao());
		retorno.setDataDemissao(p.getDataDemissao());
		retorno.setTipoFuncionario(p.getTipoFuncionario());
		retorno.setSalarioPretendido(p.getSalarioPretendido());
		retorno.setCargo(cargoTOBuilder.build(p.getCargo()));
		retorno.setPessoasFisica(pessoaFisicaTOBuilder.build(p.getPessoasFisica()));
		retorno.setUnidade(unidadeBuilder.build(p.getUnidade()));
		retorno.setDtHrEntrevista(p.getDtHrEntrevista());
		retorno.setParecerEntrevistador(p.getParecerEntrevistador());
		retorno.setDescricaoParecerEntrevistador(p.getDescricaoParecerEntrevistador());
		retorno.setConclusaoParecer(p.getConclusaoParecer());
		retorno.setEmpresaFuncionario(empresaTOBuilder.build(p.getEmpresaFuncionario()));
		retorno.setUsuarioAlteracao(p.getUsuarioAlteracao());
		retorno.setFuncionarioEntrevistador(getFuncionarioEntrevistador(p.getFuncionarioEntrevistador()));
		
		return retorno;
	}

	
	public FuncionarioTO buildTO(Funcionario p) {
		FuncionarioTO retorno = new FuncionarioTO();
		
		retorno.setId(p.getId());
		retorno.setMatricula(p.getMatricula());
		retorno.setDataAdmissao(p.getDataAdmissao());
		retorno.setDataDemissao(p.getDataDemissao());
		retorno.setTipoFuncionario(p.getTipoFuncionario());
		retorno.setSalarioPretendido(p.getSalarioPretendido());
		retorno.setCargo(cargoTOBuilder.buildTO(p.getCargo()));
		retorno.setPessoasFisica(pessoaFisicaTOBuilder.buildTO(p.getPessoasFisica()));
		retorno.setUnidade(unidadeBuilder.buildTO(p.getUnidade()));
		retorno.setDtHrEntrevista(p.getDtHrEntrevista());
		retorno.setParecerEntrevistador(p.getParecerEntrevistador());
		retorno.setDescricaoParecerEntrevistador(p.getDescricaoParecerEntrevistador());
		retorno.setConclusaoParecer(p.getConclusaoParecer());
		retorno.setEmpresaFuncionario(empresaTOBuilder.buildTO(p.getEmpresaFuncionario()));
		retorno.setUsuarioAlteracao(p.getUsuarioAlteracao());
		retorno.setFuncionarioEntrevistador(getFuncionarioEntrevistador(p.getFuncionarioEntrevistador()));

		
		return retorno;
	}
	
	private FuncionarioTO getFuncionarioEntrevistador(Funcionario p) {
		FuncionarioTO retorno = new FuncionarioTO();
		
		retorno.setId(p.getId());
		retorno.setMatricula(p.getMatricula());
		retorno.setDataAdmissao(p.getDataAdmissao());
		retorno.setDataDemissao(p.getDataDemissao());
		retorno.setTipoFuncionario(p.getTipoFuncionario());
		retorno.setSalarioPretendido(p.getSalarioPretendido());
		retorno.setCargo(cargoTOBuilder.buildTO(p.getCargo()));
		retorno.setPessoasFisica(pessoaFisicaTOBuilder.buildTO(p.getPessoasFisica()));
		retorno.setUnidade(unidadeBuilder.buildTO(p.getUnidade()));
		retorno.setDtHrEntrevista(p.getDtHrEntrevista());
		retorno.setParecerEntrevistador(p.getParecerEntrevistador());
		retorno.setDescricaoParecerEntrevistador(p.getDescricaoParecerEntrevistador());
		retorno.setConclusaoParecer(p.getConclusaoParecer());
		retorno.setEmpresaFuncionario(empresaTOBuilder.buildTO(p.getEmpresaFuncionario()));
		retorno.setUsuarioAlteracao(p.getUsuarioAlteracao());
		
		
		return retorno;
	}
	
	private Funcionario getFuncionarioEntrevistador(FuncionarioTO p) {
		Funcionario retorno = new Funcionario();
		
		retorno.setId(p.getId());
		retorno.setMatricula(p.getMatricula());
		retorno.setDataAdmissao(p.getDataAdmissao());
		retorno.setDataDemissao(p.getDataDemissao());
		retorno.setTipoFuncionario(p.getTipoFuncionario());
		retorno.setSalarioPretendido(p.getSalarioPretendido());
		retorno.setCargo(cargoTOBuilder.build(p.getCargo()));
		retorno.setPessoasFisica(pessoaFisicaTOBuilder.build(p.getPessoasFisica()));
		retorno.setUnidade(unidadeBuilder.build(p.getUnidade()));
		retorno.setDtHrEntrevista(p.getDtHrEntrevista());
		retorno.setParecerEntrevistador(p.getParecerEntrevistador());
		retorno.setDescricaoParecerEntrevistador(p.getDescricaoParecerEntrevistador());
		retorno.setConclusaoParecer(p.getConclusaoParecer());
		retorno.setEmpresaFuncionario(empresaTOBuilder.build(p.getEmpresaFuncionario()));
		retorno.setUsuarioAlteracao(p.getUsuarioAlteracao());
		
		
		return retorno;
	}
	
	
	public List<FuncionarioTO> buildAll(List<Funcionario> dtos){
		return dtos.stream().map(dto -> buildTO(dto)).collect(Collectors.toList());
	}

}
