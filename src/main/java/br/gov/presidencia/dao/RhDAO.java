package br.gov.presidencia.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;
import javax.enterprise.inject.Model;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.UserTransaction;

import br.gov.presidencia.entity.Rh;
import br.gov.presidencia.util.Response;

@Model
public class RhDAO extends CotranDAO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext
	EntityManager e;
	
	@Resource
	UserTransaction userTransaction;
	
	public RhDAO() {
		//this.em = ConexaoFactory.getEntityManager();
	}
	
	public Response incluir(Rh rh) {
		try {
			userTransaction.begin();
			e.createNativeQuery("insert into rh values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)")
			.setParameter(1, null)
			.setParameter(2, 1)
			.setParameter(3, rh.getMatriculaPr())
			.setParameter(4, rh.getMatriculaSiape())
			.setParameter(5, rh.getOrgaoOrigem())
			.setParameter(6, rh.getPossePr())
			.setParameter(7, rh.getAtividade().getIdAtividade())
			.setParameter(8, rh.getDepartamento().getIdDepartamento())
			.setParameter(9, rh.getFuncionario().getIdFuncionario())
			.setParameter(10, rh.getGraduacao().getIdGraduacao())
			.setParameter(11, rh.getGratificacao().getIdGratificacao())
			.setParameter(12, rh.getSetor().getIdSetor())
			.setParameter(13, rh.getTipo().getIdTipoGratificacao())
			.setParameter(14, rh.getTercerizado()).executeUpdate();
			userTransaction.commit();
			return new Response("RH salvo com sucesso.",1);
		} catch (Exception e) { 
			return new Response("Erro ao salvar com sucesso.",2);
		}finally {
			
		}
	}

	public Response excluir(Integer id) {
		try {
			Rh rh = consultar(id);
			userTransaction.begin();
			this.e.remove(rh);
			userTransaction.commit();
			return new Response("RH excluido com sucesso.",1);
		} catch (Exception e) {
			return  new Response("Erro ao excluir RH."+e.getMessage(),2);
		}
	}

	public Response alterar(Rh rh) {
		try {
			userTransaction.begin();
			this.e.merge(rh);
			userTransaction.commit();
			return new Response("RH salvo com sucesso.",1);
		} catch (Exception e) {
			return new Response("Erro ao salvar RH."+e.getMessage(),2);
		}
	}

	public Rh consultar(Integer id) {
		return this.getEntityManager().find(Rh.class,id);
	}
	
	public List<Rh> listar() {
		List<Rh> r = e.createQuery("from Rh", Rh.class).getResultList();
		return r;
	}
	
	public Rh consultarPorFuncionario(Integer idFuncionario) {
		Query q = this.getEntityManager().createQuery("SELECT r FROM Rh r WHERE r.funcionario.idFuncionario = "+idFuncionario);
		return  q.getResultList().isEmpty() ? new Rh() : (Rh) q.getResultList().get(0);
	}
	@SuppressWarnings("unchecked")
	public List<Rh> listarTercerizados(){
		Query q = this.getEntityManager().createQuery("SELECT r FROM Rh r WHERE r.tercerizado = 1");
		return q.getResultList();
	}

}
