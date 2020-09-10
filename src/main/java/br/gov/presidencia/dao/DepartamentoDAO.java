package br.gov.presidencia.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;
import javax.enterprise.inject.Model;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import br.gov.presidencia.entity.Departamento;
import br.gov.presidencia.util.Response;

@Model
public class DepartamentoDAO extends CotranDAO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public DepartamentoDAO () {
		//this.em = ConexaoFactory.getEntityManager();
	}

	
	@PersistenceContext
	EntityManager em;
	
	@Resource
	UserTransaction userTransaction;
	
	public Response incluir(Departamento departamento) {
		try {
			userTransaction.begin();
			em.persist(departamento);
			userTransaction.commit();
			return new Response("Departamento salvo com sucesso!",1);
		} catch (Exception e) { 
			return new Response("Erro ao salvar departamento."+e.getMessage(),2);
		}
	}

	public Response excluir(Long id) {
		try {
			Departamento departamento = consultar(id);
			userTransaction.begin();
			em.remove(departamento);
			userTransaction.commit();
			return new Response("Departamento excluido com sucesso.",1);
		} catch (Exception e) {
			return new Response("Erro ao excluir departamento."+e.getMessage(),2);
		}
	}

	public boolean alterar(Departamento departamento) {
		
		try {
			this.getEntityManager().merge(departamento);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Departamento consultar(long id) {
		try {
			return this.getEntityManager().find(Departamento.class,id);
		} catch (Exception e) {
			return null;
		}finally {
		} 
	}
	
	public List<Departamento> listar() {
		List<Departamento> a = getEntityManager().createQuery("select d from Departamento d", Departamento.class).getResultList();
		return a;
	}
	
}
