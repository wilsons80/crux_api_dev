package br.com.crux.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the diagnosticos database table.
 * 
 */
@Entity
@Table(name="diagnosticos")
public class Diagnostico  {

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