package br.gov.presidencia.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Setor implements Serializable {
	private static final long serialVersionUID = 1L;

	public Setor() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSetor;
	private String descricao;

	public Long getIdSetor() {
		return idSetor;
	}

	public void setIdSetor(Long idSetor) {
		this.idSetor = idSetor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
