package br.gov.presidencia.entity;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ferias implements Serializable{
	
	private static final long serialVersionUID = 1L;
    public Ferias() {

	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idFerias;
	private Date inicio;
	private Date fim;

	public Date getInicio() {
		return inicio;
	}
	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}
	public Date getFim() {
		return fim;
	}
	public void setFim(Date fim) {
		this.fim = fim;
	}
	public int getIdFerias() {
		return idFerias;
	}
	public void setIdFerias(int idFerias) {
		this.idFerias = idFerias;
	}	
	
}
