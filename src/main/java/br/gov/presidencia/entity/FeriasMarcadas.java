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
import javax.persistence.OneToMany;

@Entity
public class FeriasMarcadas implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public FeriasMarcadas() {
	
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idFeriasMarcadas;
	
	private Date dataDeMarcacao;
	
	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn(name="idFeriasMarcadas")
	private List<Ferias> ferias;

	public Integer getIdFeriasMarcadas() {
		return idFeriasMarcadas;
	}

	public void setIdFeriasMarcadas(Integer idFeriasMarcadas) {
		this.idFeriasMarcadas = idFeriasMarcadas;
	}

	public Date getDataDeMarcacao() {
		return dataDeMarcacao;
	}

	public void setDataDeMarcacao(Date dataDeMarcacao) {
		this.dataDeMarcacao = dataDeMarcacao;
	}

	public List<Ferias> getFerias() {
		return ferias;
	}

	public void setFerias(List<Ferias> ferias) {
		this.ferias = ferias;
	}
	
	
	
	
}
