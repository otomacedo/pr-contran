package br.gov.presidencia.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;
import javax.enterprise.inject.Model;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import br.gov.presidencia.entity.Setor;
import br.gov.presidencia.util.Response;

@Model
public class SetorDAO extends CotranDAO implements Serializable{
	private static final long serialVersionUID = 1L;

	@PersistenceContext
	EntityManager em;
	
	@Resource
	UserTransaction userTransaction;
	
	public SetorDAO () {
		//this.em = ConexaoFactory.getEntityManager();
	}

	public Response incluir(Setor setor) {
		try {
			userTransaction.begin();
			em.persist(setor);
			userTransaction.commit();
			return new Response("Setor salvo com sucesso.",1);
		} catch (Exception e) {
			return new Response("Erro ao salvar setor."+e.getMessage(),2);
		}
	
	}

	public Response excluir(Long id) {
		try {
			Setor setor = consultar(id);
			userTransaction.begin();
			em.remove(setor);
			userTransaction.commit();
			return new Response("Setor excluido com sucesso.",1);

		} catch (Exception e) {
			return new Response("Erro ao exlcuir setor."+e.getMessage(),2);

		}
		

	}

	public Response alterar(Setor setor) {
		try {
			this.getEntityManager().merge(setor);
			return new Response("Setor alterado com sucesso.",1);
		} catch (Exception e) {
			return new Response("Erro ao alterar setor."+e.getMessage(),2);
		}
		
	}

	public Setor consultar(long id) {
		try {
			return this.getEntityManager().find(Setor.class,id);
		} catch (Exception e) {
			return null;
		}finally {
		}
	}
	
	public List<Setor> listar() {
		List<Setor> t = getEntityManager().createQuery("select s from Setor s", Setor.class).getResultList();
		return t;
	}
}

