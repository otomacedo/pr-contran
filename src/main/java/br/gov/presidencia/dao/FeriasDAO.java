package br.gov.presidencia.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;
import javax.enterprise.inject.Model;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import br.gov.presidencia.entity.Ferias;
import br.gov.presidencia.util.Response;

@Model
public class FeriasDAO extends CotranDAO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@PersistenceContext
	EntityManager e;
	
	@Resource
	UserTransaction userTransaction;
	
	public FeriasDAO() {
		// this.em = ConexaoFactory.e;
	}

	public boolean incluir(Ferias ferias) {
		this.e.persist(ferias);
		try {
			this.e.getTransaction().commit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Response excluir(Integer id) {
		try {
			userTransaction.begin();
			Ferias ferias = consultar(id);
			this.e.remove(ferias);
			userTransaction.commit();
			return new Response("Férias excluido com sucesso.", 1);
		} catch (Exception e) {
			return new Response("Erro ao excluir férias."+e.getMessage(), 2);
		}

	}

	public boolean alterar(Ferias ferias) {
		this.e.merge(ferias);
		try {
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Ferias consultar(Integer id) {
		return this.e.find(Ferias.class, id);
	}

	public List<Ferias> listar() {
		List<Ferias> f = e.createQuery("select f from Ferias f", Ferias.class).getResultList();
		return f;
	}

}
