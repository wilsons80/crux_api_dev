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
public class CadastrarFuncionarioCmd {

	@Autowired
	private FuncionarioRepository repository;
	@Autowired
	private FuncionarioTOBuilder funcionarioTOBuilder;
	@Autowired
	private CamposObrigatoriosFuncionarioRule camposObrigatoriosRule;
	@Autowired
	private CamposObrigatoriosPessoaFisicaRule camposObrigatoriosPessoaFisicaRule;
	@Autowired
	private CamposObrigatoriosCargosRule camposObrigatoriosCargosRule;

	@Autowired
	private CargosTOBuilder cargoTOBuilder;
	@Autowired
	private UnidadeTOBuilder unidadeBuilder;
	@Autowired
	private EmpresaTOBuilder empresaTOBuilder;
	@Autowired
	private CadastrarPessaoFisicaCmd cadastrarPessaoFisicaCmd;

	@Autowired
	private GetUsuarioLogadoCmd getUsuarioLogadoCmd;

	public void cadastrar(FuncionarioTO to) {
		if (Objects.isNull(to.getUnidade())) {
			throw new NotFoundException("UnidAtividadeade não informada.");
		}

		if (Objects.isNull(to.getPessoasFisica())) {
			throw new NotFoundException("Pessoa Física não informada.");
		}

		if (Objects.isNull(to.getEmpresaFuncionario())) {
			throw new NotFoundException("Empresa do Funcionário não informada.");
		}

		if (Objects.isNull(to.getCargo())) {
			throw new NotFoundException("Cargo não informado.");
		}

		camposObrigatoriosCargosRule.verificar(to.getCargo().getCodigo(), to.getCargo().getNome(),
				to.getCargo().getTipoCargo());
		camposObrigatoriosPessoaFisicaRule.verificar(to.getPessoasFisica().getNome(), to.getPessoasFisica().getCpf(),
				to.getPessoasFisica().getEndereco(), to.getPessoasFisica().getCelular());
		camposObrigatoriosRule.verificar(to.getMatricula(), to.getDataAdmissao(), to.getCargo().getId(),
				to.getPessoasFisica().getId(), to.getUnidade().getIdUnidade(), to.getEmpresaFuncionario().getId());

		Funcionario entity = new Funcionario();

		entity.setId(to.getId());
		entity.setMatricula(to.getMatricula());
		entity.setDataAdmissao(to.getDataAdmissao());
		entity.setDataDemissao(to.getDataDemissao());
		entity.setTipoFuncionario(to.getTipoFuncionario());
		entity.setSalarioPretendido(to.getSalarioPretendido());

		Optional.ofNullable(to.getCargo()).ifPresent(cargo -> {
			entity.setCargo(cargoTOBuilder.build(cargo));
		});

		Optional.ofNullable(to.getPessoasFisica()).ifPresent(pf -> {
			entity.setPessoasFisica(cadastrarPessaoFisicaCmd.cadastrar(to.getPessoasFisica()));
		});

		Optional.ofNullable(to.getUnidade()).ifPresent(u -> {
			entity.setUnidade(unidadeBuilder.build(u));
		});

		entity.setDtHrEntrevista(to.getDtHrEntrevista());
		entity.setParecerEntrevistador(to.getParecerEntrevistador());
		entity.setDescricaoParecerEntrevistador(to.getDescricaoParecerEntrevistador());
		entity.setConclusaoParecer(to.getConclusaoParecer());

		Optional.ofNullable(to.getEmpresaFuncionario()).ifPresent(ef -> {
			entity.setEmpresaFuncionario(empresaTOBuilder.build(ef));
		});

		Optional.ofNullable(to.getFuncionarioEntrevistador()).ifPresent(fe -> {
			entity.setFuncionarioEntrevistador(
					funcionarioTOBuilder.getFuncionarioEntrevistador(to.getFuncionarioEntrevistador()));
		});

		entity.setUsuarioAlteracao(to.getUsuarioAlteracao());

		UsuarioLogadoTO usuarioLogado = getUsuarioLogadoCmd.getUsuarioLogado();
		entity.setUsuarioAlteracao(usuarioLogado.getIdUsuario());

		repository.save(entity);

	}
}
