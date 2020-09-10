package br.gov.presidencia.dao;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.persistence.Query;

import br.gov.presidencia.entity.Documento;

@Model
public class DocumentoDAO extends CotranDAO implements Serializable{
	private static final long serialVersionUID = 1L;

	public DocumentoDAO () {
		//this.em = ConexaoFactory.getEntityManager();
	}

	public boolean incluir(Documento documento) {
		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().persist(documento);
		try {
			this.getEntityManager().getTransaction().commit();
			return true;
		} catch (Exception e) { 
			return false;
		}
	}

	public boolean excluir(Documento documento) {
		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().remove(documento);
		try {
			this.getEntityManager().getTransaction().commit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean alterar(Documento documento) {
		this.getEntityManager().merge(documento);
		try {
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Documento consultar(long id) {
		try {
			return this.getEntityManager().find(Documento.class,id);
		} catch (Exception e) {
			return null;
		}finally {
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Documento> listar() {
		Query q = this.getEntityManager().createQuery("SELECT c FROM Documento c");
		return q.getResultList();
	}
	
}
		
		
		