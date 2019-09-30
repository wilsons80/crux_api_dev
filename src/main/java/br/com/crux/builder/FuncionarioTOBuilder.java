package br.com.crux.builder;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.entity.Funcionario;
import br.com.crux.enums.ConclusaoParecer;
import br.com.crux.enums.ParecerEntrevistador;
import br.com.crux.enums.TipoFuncionario;
import br.com.crux.to.FuncionarioTO;


@Component
public class FuncionarioTOBuilder {
	
	@Autowired private CargosTOBuilder cargoTOBuilder;
	@Autowired private PessoaFisicaTOBuilder pessoaFisicaTOBuilder;
	@Autowired private UnidadeTOBuilder unidadeBuilder;
	@Autowired private EmpresaTOBuilder empresaTOBuilder; 
	

	public Funcionario build(FuncionarioTO p) {
		Funcionario retorno = new Funcionario();
		
		retorno.setId(p.getId());
		retorno.setMatricula(p.getMatricula());
		retorno.setDataAdmissao(p.getDataAdmissao());
		retorno.setDataDemissao(p.getDataDemissao());
		
		Optional.ofNullable(p.getTipoFuncionario()).ifPresent(tf -> {
			retorno.setTipoFuncionario(TipoFuncionario.getPorTipo(p.getTipoFuncionario()));
		});
		
		retorno.setSalarioPretendido(p.getSalarioPretendido());
		
		Optional.ofNullable(p.getCargo()).ifPresent(cargo -> {
			retorno.setCargo(cargoTOBuilder.build(cargo));
		});
		
		Optional.ofNullable(p.getPessoasFisica()).ifPresent(pf -> {
			retorno.setPessoasFisica(pessoaFisicaTOBuilder.build(pf));
		});

		Optional.ofNullable(p.getUnidade()).ifPresent(u -> {
			retorno.setUnidade(unidadeBuilder.build(u));
		});
		
		retorno.setDtHrEntrevista(p.getDtHrEntrevista());
		
		Optional.ofNullable(p.getParecerEntrevistador()).ifPresent(pe -> {
			retorno.setParecerEntrevistador(ParecerEntrevistador.getPorTipo(pe));
		});
		
		retorno.setDescricaoParecerEntrevistador(p.getDescricaoParecerEntrevistador());
		
		Optional.ofNullable(p.getConclusaoParecer()).ifPresent(cp -> {
			retorno.setConclusaoParecer(ConclusaoParecer.getPorTipo(cp));
		});
		
		
		Optional.ofNullable(p.getEmpresaFuncionario()).ifPresent(ef -> {
			retorno.setEmpresaFuncionario(empresaTOBuilder.build(ef));
		});
		
		retorno.setUsuarioAlteracao(p.getUsuarioAlteracao());
	
		Optional.ofNullable(p.getFuncionarioEntrevistador()).ifPresent(fe -> {
			retorno.setFuncionarioEntrevistador(getFuncionarioEntrevistador(fe));
		});
	
		
		
		return retorno;
	}

	
	public FuncionarioTO buildTO(Funcionario p) {
		FuncionarioTO retorno = new FuncionarioTO();
		
		retorno.setId(p.getId());
		retorno.setMatricula(p.getMatricula());
		retorno.setDataAdmissao(p.getDataAdmissao());
		retorno.setDataDemissao(p.getDataDemissao());
	
		Optional.ofNullable(p.getTipoFuncionario()).ifPresent(tf -> {
			retorno.setTipoFuncionario(tf.getTipo());
		});
		
		retorno.setSalarioPretendido(p.getSalarioPretendido());
		
		Optional.ofNullable(p.getCargo()).ifPresent(cargo -> {
			retorno.setCargo(cargoTOBuilder.buildTO(cargo));
		});
		
		Optional.ofNullable(p.getPessoasFisica()).ifPresent(pf -> {
			retorno.setPessoasFisica(pessoaFisicaTOBuilder.buildTO(pf));
		});

		Optional.ofNullable(p.getUnidade()).ifPresent(u -> {
			retorno.setUnidade(unidadeBuilder.buildTO(u));
		});
		
		retorno.setDtHrEntrevista(p.getDtHrEntrevista());
		

		Optional.ofNullable(p.getParecerEntrevistador()).ifPresent(pe -> {
			retorno.setParecerEntrevistador(pe.getTipo());
		});
		
		Optional.ofNullable(p.getConclusaoParecer()).ifPresent(cp -> {
			retorno.setConclusaoParecer(cp.getTipo());
		});

		
		retorno.setDescricaoParecerEntrevistador(p.getDescricaoParecerEntrevistador());
		

		Optional.ofNullable(p.getEmpresaFuncionario()).ifPresent(ef -> {
			retorno.setEmpresaFuncionario(empresaTOBuilder.buildTO(ef));
		});
		
		Optional.ofNullable(p.getFuncionarioEntrevistador()).ifPresent(fe -> {
			retorno.setFuncionarioEntrevistador(getFuncionarioEntrevistador(fe));
		});
		
		retorno.setUsuarioAlteracao(p.getUsuarioAlteracao());
		
		return retorno;
	}
	
	private FuncionarioTO getFuncionarioEntrevistador(Funcionario p) {
		FuncionarioTO retorno = new FuncionarioTO();
		
		retorno.setId(p.getId());
		retorno.setMatricula(p.getMatricula());
		retorno.setDataAdmissao(p.getDataAdmissao());
		retorno.setDataDemissao(p.getDataDemissao());
		
		Optional.ofNullable(p.getTipoFuncionario()).ifPresent(tf -> {
			retorno.setTipoFuncionario(tf.getTipo());
		});
		
		Optional.ofNullable(p.getTipoFuncionario()).ifPresent(tf -> {
			retorno.setTipoFuncionario(tf.getTipo());
		});		retorno.setSalarioPretendido(p.getSalarioPretendido());
		
		Optional.ofNullable(p.getCargo()).ifPresent(cargo -> {
			retorno.setCargo(cargoTOBuilder.buildTO(cargo));
		});
		
		Optional.ofNullable(p.getPessoasFisica()).ifPresent(pf -> {
			retorno.setPessoasFisica(pessoaFisicaTOBuilder.buildTO(pf));
		});

		Optional.ofNullable(p.getUnidade()).ifPresent(u -> {
			retorno.setUnidade(unidadeBuilder.buildTO(u));
		});
		
		retorno.setDtHrEntrevista(p.getDtHrEntrevista());
		
		Optional.ofNullable(p.getParecerEntrevistador()).ifPresent(pe -> {
			retorno.setParecerEntrevistador(pe.getTipo());
		});
		
		retorno.setDescricaoParecerEntrevistador(p.getDescricaoParecerEntrevistador());

		Optional.ofNullable(p.getConclusaoParecer()).ifPresent(cp -> {
			retorno.setConclusaoParecer(cp.getTipo());
		});
		
		Optional.ofNullable(p.getEmpresaFuncionario()).ifPresent(ef -> {
			retorno.setEmpresaFuncionario(empresaTOBuilder.buildTO(ef));
		});
		
		retorno.setUsuarioAlteracao(p.getUsuarioAlteracao());
		
		
		return retorno;
	}
	
	public Funcionario getFuncionarioEntrevistador(FuncionarioTO p) {
		Funcionario retorno = new Funcionario();
		
		retorno.setId(p.getId());
		retorno.setMatricula(p.getMatricula());
		retorno.setDataAdmissao(p.getDataAdmissao());
		retorno.setDataDemissao(p.getDataDemissao());
		retorno.setTipoFuncionario(TipoFuncionario.getPorTipo(p.getTipoFuncionario()));
		retorno.setSalarioPretendido(p.getSalarioPretendido());
		
		Optional.ofNullable(p.getCargo()).ifPresent(cargo -> {
			retorno.setCargo(cargoTOBuilder.build(cargo));
		});
		
		Optional.ofNullable(p.getPessoasFisica()).ifPresent(pf -> {
			retorno.setPessoasFisica(pessoaFisicaTOBuilder.build(pf));
		});

		Optional.ofNullable(p.getUnidade()).ifPresent(u -> {
			retorno.setUnidade(unidadeBuilder.build(u));
		});
		
		retorno.setDtHrEntrevista(p.getDtHrEntrevista());
		
		Optional.ofNullable(p.getParecerEntrevistador()).ifPresent(pe -> {
			retorno.setParecerEntrevistador(ParecerEntrevistador.getPorTipo(pe));
		});
		
		retorno.setDescricaoParecerEntrevistador(p.getDescricaoParecerEntrevistador());
		
		Optional.ofNullable(p.getConclusaoParecer()).ifPresent(cp -> {
			retorno.setConclusaoParecer(ConclusaoParecer.getPorTipo(cp));
		});
		
		
		
		Optional.ofNullable(p.getEmpresaFuncionario()).ifPresent(ef -> {
			retorno.setEmpresaFuncionario(empresaTOBuilder.build(ef));
		});
		
		retorno.setUsuarioAlteracao(p.getUsuarioAlteracao());
		
		
		return retorno;
	}
	
	
	public List<FuncionarioTO> buildAll(List<Funcionario> dtos){
		return dtos.stream().map(dto -> buildTO(dto)).collect(Collectors.toList());
	}

}
