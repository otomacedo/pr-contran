package br.gov.presidencia.util;

import java.io.Serializable;

public class Response implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Response() {
		// TODO Auto-generated constructor stub
	}
	
	public Response(String mensagem, Integer codigo) {
		this.codigo = codigo;
		this.mensagem =  mensagem;
	}
	
	
	private String mensagem;
	private Integer codigo;

	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
}
