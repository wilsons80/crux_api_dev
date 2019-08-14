package br.com.crux.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the diagnosticos database table.
 * 
 */
@Entity
@Table(name="diagnosticos")
public class Diagnostico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_diagnostico", unique=true, nullable=false, precision=10)
	private Long idDiagnostico;

	@Column(name="ds_diagnostico", nullable=false, length=200)
	private String dsDiagnostico;

	//bi-directional many-to-one association to Atendimento
	@OneToMany(mappedBy="diagnostico")
	private List<Atendimento> atendimentos;

	public Diagnostico() {
	}

	public Long getIdDiagnostico() {
		return this.idDiagnostico;
	}

	public void setIdDiagnostico(Long idDiagnostico) {
		this.idDiagnostico = idDiagnostico;
	}

	public String getDsDiagnostico() {
		return this.dsDiagnostico;
	}

	public void setDsDiagnostico(String dsDiagnostico) {
		this.dsDiagnostico = dsDiagnostico;
	}

	public List<Atendimento> getAtendimentos() {
		return this.atendimentos;
	}

	public void setAtendimentos(List<Atendimento> atendimentos) {
		this.atendimentos = atendimentos;
	}

	public Atendimento addAtendimento(Atendimento atendimento) {
		getAtendimentos().add(atendimento);
		atendimento.setDiagnostico(this);

		return atendimento;
	}

	public Atendimento removeAtendimento(Atendimento atendimento) {
		getAtendimentos().remove(atendimento);
		atendimento.setDiagnostico(null);

		return atendimento;
	}

}