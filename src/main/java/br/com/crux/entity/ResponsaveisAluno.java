package br.com.crux.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

import br.com.crux.enums.TipoResponsavel;
import br.com.crux.infra.constantes.Constantes;


/**
 * The persistent class for the responsaveis_alunos database table.
 * 
 */
@Entity
@Table(name="responsaveis_alunos")
public class ResponsaveisAluno  {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_id_responsavel_aluno")
	@SequenceGenerator(name = "sq_id_responsavel_aluno", sequenceName = "sq_id_responsavel_aluno", schema = Constantes.SCHEMA_PUBLIC, initialValue = 1, allocationSize = 1)
	@Column(name="id_responsavel_aluno")
	private Long id;

	@Column(name="ds_desligamento")
	private String descDesligamento;

	@Column(name="ds_grau_parentesco")
	private String descGrauParentesco;

	@Column(name="dt_desvinculacao")
	private LocalDateTime dataDesvinculacao;

	@Column(name="dt_vinculacao")
	private LocalDateTime dataVinculacao;

	@Column(name="st_mesmo_ender_resp")
	private String mesmoEnderResponsavel;

	@Column(name="st_tipo_responsavel")
	@Type(type = "br.com.crux.infra.dao.GenericEnumUserType", 
	      parameters = { @Parameter(name = "enumClass", value = "br.com.crux.enums.TipoResponsavel"),
	    		         @Parameter(name = "keyName", value = "tipo")}) 	
	private TipoResponsavel tipoResponsavel;

	@Column(name="id_usuario_apl")
	private Long usuarioAlteracao;

	public ResponsaveisAluno() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescDesligamento() {
		return descDesligamento;
	}

	public void setDescDesligamento(String descDesligamento) {
		this.descDesligamento = descDesligamento;
	}

	public String getDescGrauParentesco() {
		return descGrauParentesco;
	}

	public void setDescGrauParentesco(String descGrauParentesco) {
		this.descGrauParentesco = descGrauParentesco;
	}

	public LocalDateTime getDataDesvinculacao() {
		return dataDesvinculacao;
	}

	public void setDataDesvinculacao(LocalDateTime dataDesvinculacao) {
		this.dataDesvinculacao = dataDesvinculacao;
	}

	public LocalDateTime getDataVinculacao() {
		return dataVinculacao;
	}

	public void setDataVinculacao(LocalDateTime dataVinculacao) {
		this.dataVinculacao = dataVinculacao;
	}

	public String getMesmoEnderResponsavel() {
		return mesmoEnderResponsavel;
	}

	public void setMesmoEnderResponsavel(String mesmoEnderResponsavel) {
		this.mesmoEnderResponsavel = mesmoEnderResponsavel;
	}

	public TipoResponsavel getTipoResponsavel() {
		return tipoResponsavel;
	}

	public void setTipoResponsavel(TipoResponsavel tipoResponsavel) {
		this.tipoResponsavel = tipoResponsavel;
	}

	public Long getUsuarioAlteracao() {
		return usuarioAlteracao;
	}

	public void setUsuarioAlteracao(Long usuarioAlteracao) {
		this.usuarioAlteracao = usuarioAlteracao;
	}


}
