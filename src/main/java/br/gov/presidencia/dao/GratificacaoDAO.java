package br.gov.presidencia.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;
import javax.enterprise.inject.Model;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import br.gov.presidencia.entity.Gratificacao;
import br.gov.presidencia.util.Response;

@Model
public class GratificacaoDAO extends CotranDAO implements Serializable {
	private static final long serialVersionUID = 1L;

	@PersistenceContext
	EntityManager em;
	
	@Resource
	UserTransaction userTransaction;
	
	public GratificacaoDAO() {
		// this.em = ConexaoFactory.getEntityManager();
	}

	public Response incluir(Gratificacao gratificacao) {
		try {
			userTransaction.begin();
			em.persist(gratificacao);
			userTransaction.commit();
			return new Response("Gratificação salva com sucesso.", 1);
		} catch (Exception e) {
			return new Response("Erro ao salvar gratificação."+e.getMessage(), 2);
		}
	}

	public Response excluir(Long id) {
		try {
			Gratificacao gratificacao = consultar(id);
			userTransaction.begin();
			em.remove(gratificacao);
			userTransaction.commit();
			return new Response("Gratificação excluida com sucesso.", 1);
		} catch (Exception e) {
			return new Response("Erro ao excluir gratificação."+e.getMessage(), 2);
		}
	}

	public Response alterar(Gratificacao gratificacao) {
		try {
			this.getEntityManager().merge(gratificacao);
			return new Response("Gratificação salva com sucesso.", 1);
		} catch (Exception e) {
			return new Response("Erro ao excluir gratificação."+e.getMessage(), 2);
		}
	}

	public Gratificacao consultar(long id) {
		try {
			return this.getEntityManager().find(Gratificacao.class, id);
		} catch (Exception e) {
			return null;
		} finally {
		}
	}

	public List<Gratificacao> listar() {
		if (!getEntityManager().isOpen()) {
			System.out
					.println("#################################   CONEXÃO FECHADA   #################################");
		}
		List<Gratificacao> g = getEntityManager().createQuery("select g from Gratificacao g", Gratificacao.class)
				.getResultList();
		return g;

	}
}
