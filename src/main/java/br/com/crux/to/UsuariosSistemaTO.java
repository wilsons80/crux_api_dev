package br.com.crux.to;

import java.time.LocalDateTime;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import br.com.crux.infra.adapter.LocalDateTimeAdapter;

public class UsuariosSistemaTO {
	
	
	private Long idUsuario;
	private String username;
	private String senha;
	private String descFimVigenciaUsuario;
	
	@XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
	private LocalDateTime dataFimVigencia;
	@XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
	private LocalDateTime dataInicioVigencia;
	@XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
	private LocalDateTime dataUltimoAcesso;
	
	private Long qtdAcessoNegado;
	private String stAtivo;
	private String stTrocaSenha;
	
	private PessoaFisicaTO pessoaFisica;
	private Long usuarioAlteracao;
	
	
	public UsuariosSistemaTO() {
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getDescFimVigenciaUsuario() {
		return descFimVigenciaUsuario;
	}

	public void setDescFimVigenciaUsuario(String descFimVigenciaUsuario) {
		this.descFimVigenciaUsuario = descFimVigenciaUsuario;
	}

	public LocalDateTime getDataFimVigencia() {
		return dataFimVigencia;
	}

	public void setDataFimVigencia(LocalDateTime dataFimVigencia) {
		this.dataFimVigencia = dataFimVigencia;
	}

	public LocalDateTime getDataInicioVigencia() {
		return dataInicioVigencia;
	}

	public void setDataInicioVigencia(LocalDateTime dataInicioVigencia) {
		this.dataInicioVigencia = dataInicioVigencia;
	}

	public LocalDateTime getDataUltimoAcesso() {
		return dataUltimoAcesso;
	}

	public void setDataUltimoAcesso(LocalDateTime dataUltimoAcesso) {
		this.dataUltimoAcesso = dataUltimoAcesso;
	}

	public Long getQtdAcessoNegado() {
		return qtdAcessoNegado;
	}

	public void setQtdAcessoNegado(Long qtdAcessoNegado) {
		this.qtdAcessoNegado = qtdAcessoNegado;
	}

	public String getStAtivo() {
		return stAtivo;
	}

	public void setStAtivo(String stAtivo) {
		this.stAtivo = stAtivo;
	}

	public String getStTrocaSenha() {
		return stTrocaSenha;
	}

	public void setStTrocaSenha(String stTrocaSenha) {
		this.stTrocaSenha = stTrocaSenha;
	}

	public PessoaFisicaTO getPessoaFisica() {
		return pessoaFisica;
	}

	public void setPessoaFisica(PessoaFisicaTO pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
	}

	public Long getUsuarioAlteracao() {
		return usuarioAlteracao;
	}

	public void setUsuarioAlteracao(Long usuariosAlteracao) {
		this.usuarioAlteracao = usuariosAlteracao;
	}
	
	
	
}
