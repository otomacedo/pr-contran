package br.gov.presidencia.entity;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Rh implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idRh;
	
	private String orgaoOrigem;
	private Date possePr;
	private String matriculaSiape;
	private String matriculaPr;
	private Boolean tercerizado; 
	private String observacao;
	
	public Rh() {}
	
	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn(name="idRh")
	private List<FeriasMarcadas> feriasMarcadas;
	
	@OneToOne
	@JoinColumn(name="idFuncionario")
	private Funcionario funcionario;
	
	@OneToOne
	@JoinColumn(name="idDepartamento")
	private Departamento departamento;
	
	@OneToOne
	@JoinColumn(name="idSetor")
	private Setor setor; 
	
	@ManyToOne
	@JoinColumn(name="idGratificacao")
	private Gratificacao gratificacao;
	
	@OneToOne
	@JoinColumn(name="idGraduacao")
	private Graduacao graduacao;
	
	@OneToOne
	@JoinColumn(name="idAtividade")
	private Atividade atividade;
	
	@ManyToOne
	@JoinColumn(name="tipo_idTipoGratificacao")
	private TipoGratificacao tipo;
	
	public Integer getIdRh() {
		return idRh;
	}
	public void setIdRh(Integer idRh) {
		this.idRh = idRh;
	}
	public String getOrgaoOrigem() {
		return orgaoOrigem;
	}
	public void setOrgaoOrigem(String orgaoOrigem) {
		this.orgaoOrigem = orgaoOrigem;
	}
	public Date getPossePr() {
		return possePr;
	}
	public void setPossePr(Date possePr) {
		this.possePr = possePr;
	}
	public String getMatriculaSiape() {
		return matriculaSiape;
	}
	public void setMatriculaSiape(String matriculaSiape) {
		this.matriculaSiape = matriculaSiape;
	}
	public String getMatriculaPr() {
		return matriculaPr;
	}
	public void setMatriculaPr(String matriculaPr) {
		this.matriculaPr = matriculaPr;
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	public List<FeriasMarcadas> getFeriasMarcadas() {
		return feriasMarcadas;
	}
	public void setFeriasMarcadas(List<FeriasMarcadas> feriasMarcadas) {
		this.feriasMarcadas = feriasMarcadas;
	}

	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	public Gratificacao getGratificacao() {
		return gratificacao;
	}
	public void setGratificacao(Gratificacao gratificacao) {
		this.gratificacao = gratificacao;
	}
	public Graduacao getGraduacao() {
		return graduacao;
	}
	public void setGraduacao(Graduacao graduacao) {
		this.graduacao = graduacao;
	}
	public Atividade getAtividade() {
		return atividade;
	}
	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}
	public Setor getSetor() {
		return setor;
	}
	public void setSetor(Setor setor) {
		this.setor = setor;
	}
	public TipoGratificacao getTipo() {
		return tipo;
	}
	public void setTipo(TipoGratificacao tipo) {
		this.tipo = tipo;
	}
	public Boolean getTercerizado() {
		return tercerizado;
	}
	public void setTercerizado(Boolean tercerizado) {
		this.tercerizado = tercerizado;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
}
