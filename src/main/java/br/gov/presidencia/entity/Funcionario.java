package br.gov.presidencia.entity;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
	public class Funcionario implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idFuncionario;
	
	private String nome;	  
	private String nomeGuerra;
	private String endereco;  
	private String cidade;
	private String bairro;
	private Date dtNascimento;
	private String ramal;    
	private String telefone;
	private String rg;
	private String orgaoExpedidorRg;
	private Date dtExpedicaoRg;	
	private String cpf;
	private String cnh;
	private Date validadeCnh; 
	private String categoriaCnh;
	private String numPassaporte;
	private Date validadePassaporte;
	private Date dtExpedicaoPassaporte;
	private String inscricaoTitulo;
	private Long zonaTitulo;
	private Long secaoTitulo;
	private Boolean status;
	

	public Funcionario() {

	}
	
	public Integer getIdFuncionario() {
		return idFuncionario;
	}
	
	public void setIdFuncionario(Integer idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNomeGuerra() {
		return nomeGuerra;
	}
	public void setNomeGuerra(String nomeGuerra) {
		this.nomeGuerra = nomeGuerra;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public Date getDtNascimento() {
		return dtNascimento;
	}
	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
	public String getRamal() {
		return ramal;
	}
	public void setRamal(String ramal) {
		this.ramal = ramal;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getOrgaoExpedidorRg() {
		return orgaoExpedidorRg;
	}
	public void setOrgaoExpedidorRg(String orgaoExpedidorRg) {
		this.orgaoExpedidorRg = orgaoExpedidorRg;
	}
	public Date getDtExpedicaoRg() {
		return dtExpedicaoRg;
	}
	public void setDtExpedicaoRg(Date dtExpedicaoRg) {
		this.dtExpedicaoRg = dtExpedicaoRg;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getCnh() {
		return cnh;
	}
	public void setCnh(String cnh) {
		this.cnh = cnh;
	}
	public Date getValidadeCnh() {
		return validadeCnh;
	}
	public void setValidadeCnh(Date validadeCnh) {
		this.validadeCnh = validadeCnh;
	}
	public String getCategoriaCnh() {
		return categoriaCnh;
	}
	public void setCategoriaCnh(String categoriaCnh) {
		this.categoriaCnh = categoriaCnh;
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
	public Long getZonaTitulo() {
		return zonaTitulo;
	}
	public void setZonaTitulo(Long zonaTitulo) {
		this.zonaTitulo = zonaTitulo;
	}
	public Long getSecaoTitulo() {
		return secaoTitulo;
	}
	public void setSecaoTitulo(Long secaoTitulo) {
		this.secaoTitulo = secaoTitulo;
	}
	public Boolean isStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	
}
