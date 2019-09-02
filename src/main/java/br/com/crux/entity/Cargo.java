package br.com.crux.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

import br.com.crux.enums.TipoCarga;
import br.com.crux.infra.constantes.Constantes;


@Entity
@Table(name="cargos")
public class Cargo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_id_cargo")
	@SequenceGenerator(name = "sq_id_cargo", sequenceName = "sq_id_cargo", schema = Constantes.SCHEMA_PUBLIC, initialValue = 1, allocationSize = 1)
	@Column(name="id_cargo")
	private Long id;

	@Column(name="cd_cargo")
	private String codigo;

	@Column(name="nm_cargo")
	private String nome;

	@Column(name="st_tipo_cargo")
	@Type(type = "br.com.crux.infra.dao.GenericEnumUserType", 
	           parameters = { @Parameter(name = "enumClass", value = "br.com.crux.enums.TipoCarga") }) 
	private TipoCarga tipoCargo;	

	@Column(name="id_usuario_apl")
	private Long usuarioAlteracao;


	public Cargo() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long idCargo) {
		this.id = idCargo;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String cdCargo) {
		this.codigo = cdCargo;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nmCargo) {
		this.nome = nmCargo;
	}

	public TipoCarga getTipoCargo() {
		return tipoCargo;
	}

	public void setTipoCargo(TipoCarga tipoCargo) {
		this.tipoCargo = tipoCargo;
	}

	public Long getUsuarioAlteracao() {
		return this.usuarioAlteracao;
	}

	public void setUsuarioAlteracao(Long usuariosSistema) {
		this.usuarioAlteracao = usuariosSistema;
	}


}