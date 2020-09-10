package br.gov.presidencia.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Graduacao implements Serializable {
	private static final long serialVersionUID=1L;
	public Graduacao() {		
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idGraduacao;
	@Column(name="descricao")
	private String descricao;
	
	public Long getIdGraduacao() {
		return idGraduacao;
	}
	public void setIdGraduacao(Long idGraduacao) {
		this.idGraduacao = idGraduacao;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
