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
@NamedQuery(name="Diagnostico.findAll", query="SELECT d FROM Diagnostico d")
public class Diagnostico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_diagnostico")
	private Long idDiagnostico;

	@Column(name="ds_diagnostico")
	private String dsDiagnostico;

	//bi-directional many-to-one association to Atendimento
	@OneToMany(mappedBy="diagnostico")
	private List<Atendimento> atendimentos;

	//bi-directional many-to-one association to UsuariosSistema
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_usuario_apl")
	private UsuariosSistema usuariosSistema;

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

	public UsuariosSistema getUsuariosSistema() {
		return this.usuariosSistema;
	}

	public void setUsuariosSistema(UsuariosSistema usuariosSistema) {
		this.usuariosSistema = usuariosSistema;
	}

}