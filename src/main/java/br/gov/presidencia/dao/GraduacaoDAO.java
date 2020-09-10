package br.gov.presidencia.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;
import javax.enterprise.inject.Model;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import br.gov.presidencia.entity.Graduacao;
import br.gov.presidencia.util.Response;

@Model
public class GraduacaoDAO extends CotranDAO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext
	EntityManager em;
	
	@Resource
	UserTransaction userTransaction;
	public GraduacaoDAO () {
		//this.em = ConexaoFactory.getEntityManager();
	}

	public Response incluir(Graduacao graduacao) {
		try {
			userTransaction.begin();
			em.persist(graduacao);
			userTransaction.commit();
			return new Response("Graduação salva com sucesso.",1);
		} catch (Exception e) {
			return new Response("Erro ao salvar gradução."+e.getMessage(),2);
		}
		
	}

	public Response excluir(Long id) {
		try {
			Graduacao graduacao = consultar(id);
			userTransaction.begin();
			em.remove(graduacao);
			userTransaction.commit();
			return new Response("Gradução excluida com sucesso.",1);
		} catch (Exception e) {
			return new Response("Erro ao excluir graduação."+e.getMessage(),2);
		}
			
	}

	public Response alterar(Graduacao graduacao) {
		try {
		this.getEntityManager().merge(graduacao);
		return new Response("Graduação alterada com sucesso.",1);
	} catch (Exception e) {
		return new Response("Erro ao excluir graduação."+e.getMessage(),2);
	}
	}

	public Graduacao consultar(long id) {
		try {
			return this.getEntityManager().find(Graduacao.class,id);
		} catch (Exception e) {
			return null;
		}finally {
		}
	}
	
	public List<Graduacao> listar() {
		List<Graduacao> g = getEntityManager().createQuery("select g from Graduacao g", Graduacao.class).getResultList();
		return g;
	}

}
