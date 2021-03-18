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
	private String periodo;
	private String status;

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
	public String getPeriodo() {
		return periodo;
	}
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
