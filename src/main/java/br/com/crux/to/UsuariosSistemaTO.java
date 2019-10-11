package br.com.crux.to;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import br.com.crux.infra.adapter.LocalDateTimeAdapter;

public class UsuariosSistemaTO {
	
	
	private Long idUsuario;
	private String nomeUsuario;
	private String senhaUsuario;
	private String descFimVigenciaUsuario;
	
	@XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
	private LocalDateTime dataFimVigencia;
	@XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
	private LocalDateTime dataInicioVigencia;
	@XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
	private LocalDateTime dataUltimoAcesso;
	
	private Long qtdAcessoNegado;
	private Boolean stAtivo;
	private Boolean stTrocaSenha;
	
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

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String username) {
		this.nomeUsuario = username;
	}

	public String getSenhaUsuario() {
		return senhaUsuario;
	}

	public void setSenhaUsuario(String senha) {
		this.senhaUsuario = senha;
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

	public Boolean getStAtivo() {
		return Optional.ofNullable(stAtivo).orElse(false);
	}

	public void setStAtivo(Boolean stAtivo) {
		this.stAtivo = stAtivo;
	}

	public Boolean getStTrocaSenha() {
		return Optional.ofNullable(stTrocaSenha).orElse(false);
	}

	public void setStTrocaSenha(Boolean stTrocaSenha) {
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
