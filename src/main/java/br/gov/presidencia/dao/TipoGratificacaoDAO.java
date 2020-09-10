package br.gov.presidencia.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.transaction.UserTransaction;

import br.gov.presidencia.entity.TipoGratificacao;
import br.gov.presidencia.util.Response;

@Stateless
public class TipoGratificacaoDAO extends CotranDAO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public TipoGratificacaoDAO() {
		//this.em = ConexaoFactory.getEntityManager();
	}
	
	@Resource
	UserTransaction userTransaction;
	
	public Response incluir(TipoGratificacao tipoGratificacao) {
		try {
			userTransaction.begin();
			getEntityManager().persist(tipoGratificacao);
			userTransaction.commit();
			return new Response("Tipo gratificação salva com sucesso.",1);
		} catch (Exception e) {
			return new Response("Erro ao excluir tipo gratificação"+e.getMessage(),2);
		}
	}
	
	public Response excluir(Integer id) {
		try {
			TipoGratificacao tipoGratificacao = consultar(id);
			userTransaction.begin();
			getEntityManager().remove(tipoGratificacao);
			userTransaction.commit();
			return new Response("Tipo gratificação excluida com sucesso.",1);
		} catch (Exception e) {
			return new Response("Erro ao excluir tipo gratificação."+e.getMessage(),2);
		}
	}
		
	public boolean alterar(TipoGratificacao tipoGratificacao) {
	try {
		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().merge(tipoGratificacao);
		this.getEntityManager().getTransaction().commit();
		return true;
	} catch (Exception e) {
		return false;
	}	
	}
	
	public TipoGratificacao consultar(long id) {
		try {
			return this.getEntityManager().find(TipoGratificacao.class,id);
		} catch (Exception e) {
			return null;
		}finally {
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<TipoGratificacao> listar(){
		Query q = this.getEntityManager().createQuery("SELECT c FROM TipoGratificacao c");
		return q.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<TipoGratificacao> listarTiposPorGratificacao(long id) {
		Query q = this.getEntityManager().createQuery("SELECT g FROM TipoGratificacao g WHERE g.idGratificacao = "+ id);
		return q.getResultList();
	}
	
	
	
}
