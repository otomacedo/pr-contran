package br.gov.presidencia.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
public class Gratificacao implements Serializable {
	private static final long serialVersionUID=1L;
	public Gratificacao() {
		
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idGratificacao;
	
	private String descricao;
	@JsonManagedReference
	@OneToMany(cascade= CascadeType.ALL, mappedBy="gratificacao")
	private List<TipoGratificacao> tipoGratificacoes;
	
	public Long getIdGratificacao() {
		return idGratificacao;
	}
	public void setIdGratificacao(Long idGratificacao) {
		this.idGratificacao = idGratificacao;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;  
	}
	public List<TipoGratificacao> getTipoGratificacoes() {
		return tipoGratificacoes;
	}
	public void setTipoGratificacoes(List<TipoGratificacao> tipoGratificacoes) {
		this.tipoGratificacoes = tipoGratificacoes;
	}
	
}
