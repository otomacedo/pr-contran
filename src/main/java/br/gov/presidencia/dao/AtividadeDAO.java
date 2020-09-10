package br.gov.presidencia.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;
import javax.enterprise.inject.Model;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import br.gov.presidencia.entity.Atividade;
import br.gov.presidencia.util.Response;

@Model
public class AtividadeDAO extends CotranDAO implements Serializable{
	private static final long serialVersionUID = 1L;
	

	@PersistenceContext
	EntityManager em;
	
	@Resource
	UserTransaction userTransaction;
	
	public AtividadeDAO () {
		//this.em = ConexaoFactory.getEntityManager();
	}

	public Response incluir(Atividade atividade) {
		
		try {
			userTransaction.begin();
			em.persist(atividade);
			userTransaction.commit();
			return new Response("Atividade salva com sucesso.",1);
		} catch (Exception e) { 
			return new Response("Erro ao salvar atividade."+e.getMessage(),2);
		}
	}

	public Response excluir(Long id) {
		
		try {
			Atividade atividade = consultar(id);
			userTransaction.begin();
			em.remove(atividade);
			userTransaction.commit();
			return new Response("Atividade excluida com sucesso.",1);
		}catch (Exception e) {
			return new Response("Erro ao excluir atividade."+e.getMessage(),2);
		}
		
	}

	public boolean alterar(Atividade atividade) {
		this.getEntityManager().merge(atividade);
		try {
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Atividade consultar(long id) {
		try {
			return getEntityManager().find(Atividade.class,id);
		} catch (Exception e) {
			return null;
		}finally {
			
		}
		
	}
	
	public List<Atividade> listar() {
		List<Atividade> a = getEntityManager().createQuery("select a from Atividade a", Atividade.class).getResultList();
		return a;
		
	}
}
