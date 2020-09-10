package br.gov.presidencia.entity;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class Documento implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public Documento() {
		
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idDocumento;
	
	private String rg;
	private String orgaoExpedidorRg;
	private String dtExpedicaoRg;	
	private String cpf;
	private String cnh;
	private Date validadeCnh; 
	private String categoriaCnh;
	private String numPassaporte;
	private Date validadePassaporte;
	private Date dtExpedicaoPassaporte;
	private String inscricaoTitulo;
	private Long zonaTitulo = 0L;
	private Long secaoTitulo = 0L;
	
	
	
	public int getIdDocumento() {
		return idDocumento;
	}
	public void setIdDocumento(int idDocumento) {
		this.idDocumento = idDocumento;
	}
	
	public String getCategoriaCnh() {
		return categoriaCnh;
	}
	public void setCategoriaCnh(String categoriaCnh) {
		this.categoriaCnh = categoriaCnh;
	}
	public void setZonaTitulo(Long zonaTitulo) {
		this.zonaTitulo = zonaTitulo;
	}
	public void setSecaoTitulo(Long secaoTitulo) {
		this.secaoTitulo = secaoTitulo;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Date getValidadeCnh() {
		return validadeCnh;
	}
	public void setValidadeCnh(Date validadeCnh) {
		this.validadeCnh = validadeCnh;
	}
	public long getZonaTitulo() {
		return zonaTitulo;
	}
	public void setZonaTitulo(long zonaTitulo) {
		this.zonaTitulo = zonaTitulo;
	}
	public long getSecaoTitulo() {
		return secaoTitulo;
	}
	public void setSecaoTitulo(long secaoTitulo) {
		this.secaoTitulo = secaoTitulo;
	}
	public String getOrgaoExpedidorRg() {
		return orgaoExpedidorRg;
	}
	public void setOrgaoExpedidorRg(String orgaoExpedidorRg) {
		this.orgaoExpedidorRg = orgaoExpedidorRg;
	}
	public String getCnh() {
		return cnh;
	}
	public void setCnh(String cnh) {
		this.cnh = cnh;
	}
	public String getNumPassaporte() {
		return numPassaporte;
	}
	public void setNumPassaporte(String numPassaporte) {
		this.numPassaporte = numPassaporte;
	}
	public Date getValidadePassaporte() {
		return validadePassaporte;
	}
	public void setValidadePassaporte(Date validadePassaporte) {
		this.validadePassaporte = validadePassaporte;
	}
	public Date getDtExpedicaoPassaporte() {
		return dtExpedicaoPassaporte;
	}
	public void setDtExpedicaoPassaporte(Date dtExpedicaoPassaporte) {
		this.dtExpedicaoPassaporte = dtExpedicaoPassaporte;
	}
	public String getInscricaoTitulo() {
		return inscricaoTitulo;
	}
	public void setInscricaoTitulo(String inscricaoTitulo) {
		this.inscricaoTitulo = inscricaoTitulo;
	}
	public String getDtExpedicaoRg() {
		return dtExpedicaoRg;
	}
	public void setDtExpedicaoRg(String dtExpedicaoRg) {
		this.dtExpedicaoRg = dtExpedicaoRg;
	}
	
}
