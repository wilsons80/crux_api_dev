package br.com.crux.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the entidades_sociais database table.
 * 
 */
@Entity
@Table(name="entidades_sociais")
public class EntidadesSociai implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_entidade_social", unique=true, nullable=false, precision=10)
	private Long idEntidadeSocial;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_fim_entidade_social")
	private Date dtFimEntidadeSocial;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_vinculo_entidade_social")
	private Date dtVinculoEntidadeSocial;

	//bi-directional many-to-one association to EncaminhaAluno
	@OneToMany(mappedBy="entidadesSociai")
	private List<EncaminhaAluno> encaminhaAlunos;

	//bi-directional many-to-one association to Empresa
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_empresa", nullable=false)
	private Empresa empresa;

	public EntidadesSociai() {
	}

	public Long getIdEntidadeSocial() {
		return this.idEntidadeSocial;
	}

	public void setIdEntidadeSocial(Long idEntidadeSocial) {
		this.idEntidadeSocial = idEntidadeSocial;
	}

	public Date getDtFimEntidadeSocial() {
		return this.dtFimEntidadeSocial;
	}

	public void setDtFimEntidadeSocial(Date dtFimEntidadeSocial) {
		this.dtFimEntidadeSocial = dtFimEntidadeSocial;
	}

	public Date getDtVinculoEntidadeSocial() {
		return this.dtVinculoEntidadeSocial;
	}

	public void setDtVinculoEntidadeSocial(Date dtVinculoEntidadeSocial) {
		this.dtVinculoEntidadeSocial = dtVinculoEntidadeSocial;
	}

	public List<EncaminhaAluno> getEncaminhaAlunos() {
		return this.encaminhaAlunos;
	}

	public void setEncaminhaAlunos(List<EncaminhaAluno> encaminhaAlunos) {
		this.encaminhaAlunos = encaminhaAlunos;
	}

	public EncaminhaAluno addEncaminhaAluno(EncaminhaAluno encaminhaAluno) {
		getEncaminhaAlunos().add(encaminhaAluno);
		encaminhaAluno.setEntidadesSociai(this);

		return encaminhaAluno;
	}

	public EncaminhaAluno removeEncaminhaAluno(EncaminhaAluno encaminhaAluno) {
		getEncaminhaAlunos().remove(encaminhaAluno);
		encaminhaAluno.setEntidadesSociai(null);

		return encaminhaAluno;
	}

	public Empresa getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

}