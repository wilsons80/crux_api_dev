package br.com.crux.to;

import java.time.LocalDateTime;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import br.com.crux.enums.ConclusaoParecer;
import br.com.crux.enums.ParecerEntrevistador;
import br.com.crux.enums.TipoFuncionario;
import br.com.crux.infra.adapter.LocalDateTimeAdapter;

public class FuncionarioTO {

	private Long id;
	private String matricula;

	@XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
	private LocalDateTime dataAdmissao;
	@XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
	private LocalDateTime dataDemissao;

	private String tipoFuncionario;
	private Double salarioPretendido;
	private CargoTO cargo;

	private PessoaFisicaTO pessoasFisica;

	private UnidadeTO unidade;
	private Date dtHrEntrevista;

	private String parecerEntrevistador;
	private String descricaoParecerEntrevistador;
	private String conclusaoParecer;
	private FuncionarioTO funcionarioEntrevistador;

	private EmpresaTO empresaFuncionario;

	private Long usuarioAlteracao;

	public FuncionarioTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public LocalDateTime getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(LocalDateTime dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public LocalDateTime getDataDemissao() {
		return dataDemissao;
	}

	public void setDataDemissao(LocalDateTime dataDemissao) {
		this.dataDemissao = dataDemissao;
	}

	public String getTipoFuncionario() {
		return tipoFuncionario;
	}

	public void setTipoFuncionario(String tipoFuncionario) {
		this.tipoFuncionario = tipoFuncionario;
	}

	public Double getSalarioPretendido() {
		return salarioPretendido;
	}

	public void setSalarioPretendido(Double salarioPretendido) {
		this.salarioPretendido = salarioPretendido;
	}

	public CargoTO getCargo() {
		return cargo;
	}

	public void setCargo(CargoTO cargo) {
		this.cargo = cargo;
	}

	public PessoaFisicaTO getPessoasFisica() {
		return pessoasFisica;
	}

	public void setPessoasFisica(PessoaFisicaTO pessoasFisica) {
		this.pessoasFisica = pessoasFisica;
	}

	public UnidadeTO getUnidade() {
		return unidade;
	}

	public void setUnidade(UnidadeTO unidade) {
		this.unidade = unidade;
	}

	public Date getDtHrEntrevista() {
		return dtHrEntrevista;
	}

	public void setDtHrEntrevista(Date dtHrEntrevista) {
		this.dtHrEntrevista = dtHrEntrevista;
	}

	public String getParecerEntrevistador() {
		return parecerEntrevistador;
	}

	public void setParecerEntrevistador(String parecerEntrevistador) {
		this.parecerEntrevistador = parecerEntrevistador;
	}

	public String getDescricaoParecerEntrevistador() {
		return descricaoParecerEntrevistador;
	}

	public void setDescricaoParecerEntrevistador(String descricaoParecerEntrevistador) {
		this.descricaoParecerEntrevistador = descricaoParecerEntrevistador;
	}

	public String getConclusaoParecer() {
		return conclusaoParecer;
	}

	public void setConclusaoParecer(String conclusaoParecer) {
		this.conclusaoParecer = conclusaoParecer;
	}

	public FuncionarioTO getFuncionarioEntrevistador() {
		return funcionarioEntrevistador;
	}

	public void setFuncionarioEntrevistador(FuncionarioTO funcionarioEntrevistador) {
		this.funcionarioEntrevistador = funcionarioEntrevistador;
	}

	public EmpresaTO getEmpresaFuncionario() {
		return empresaFuncionario;
	}

	public void setEmpresaFuncionario(EmpresaTO empresaFuncionario) {
		this.empresaFuncionario = empresaFuncionario;
	}

	public Long getUsuarioAlteracao() {
		return usuarioAlteracao;
	}

	public void setUsuarioAlteracao(Long usuarioAlteracao) {
		this.usuarioAlteracao = usuarioAlteracao;
	}

}
