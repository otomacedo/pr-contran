package br.gov.presidencia.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;
import javax.enterprise.inject.Model;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.UserTransaction;
import br.gov.presidencia.entity.Funcionario;
import br.gov.presidencia.util.Response;

@Model
public class FuncionarioDAO extends CotranDAO implements Serializable{

	private static final long serialVersionUID = 1L;

	public FuncionarioDAO () {
		// this.em = ConexaoFactory.getEntityManager();
	}

	@PersistenceContext
	EntityManager em;
	
	@Resource
	UserTransaction userTransaction;
	public Response incluir(Funcionario funcionario) {
		try {
			userTransaction.begin();
			this.em.persist(funcionario);
			userTransaction.commit();
			return new Response("Salvo com sucesso.", 1);
		} catch (Exception e) { 
			return new Response("Erro ao salvar funcionario."+e.getMessage(),2);
		}
	}

	public Response excluir(Integer id) {
		try {
			Funcionario funcionario = consultar(id);
			userTransaction.begin();
			this.em.remove(funcionario);
			userTransaction.commit();
			return new Response("Funcionario excluido com sucesso!",1);
		} catch (Exception e) {
			return new Response("Erro ao excluir funcionario."+e.getMessage(),2);
		}
	}

	public Response alterar(Funcionario funcionario) {
		try {
			userTransaction.begin();
			this.em.merge(funcionario);
			userTransaction.commit();
			return new Response("Atualizado com sucesso!",1);
		} catch (Exception e) {
			return new Response("Erro ao atualizar:"+e.getMessage(),1);
		}
	}
	
	public Response atualizarStatusFuncionario(Funcionario funcionario) {
		try {
			userTransaction.begin();
			Query q = this.em.createQuery("UPDATE Funcionario set status = "+funcionario.isStatus()+" WHERE idFuncionario = "+funcionario.getIdFuncionario());
			q.executeUpdate();
			userTransaction.commit();
			if(funcionario.isStatus())
				return new Response("Funcionario ativado com sucesso",1);
			else
				return new Response("Funcionario inativado com sucesso",2);
		} catch (Exception e) {
			return new Response("Erro ao atualizar status do funcionario: "+e.getMessage(),2);
		}
	}

	public Funcionario consultar(Integer id) {
		return this.em.find(Funcionario.class,id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Funcionario> listar() {
		List<Funcionario> f = this.em.createQuery("select f from Funcionario f").getResultList();
		return f;
	}
	
	@SuppressWarnings("unchecked")
	public List<Funcionario> filtrarFuncionario(String query){
		Query q = this.getEntityManager().createQuery(query);
		return q.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Funcionario> listarFuncionariosAtivos(){
		Query q = this.getEntityManager().createQuery("SELECT f FROM Funcionario f WHERE f.status = 1");
		return q.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Funcionario> listarFuncionariosInativos(){
		Query q = this.getEntityManager().createQuery("SELECT f FROM Funcionario f WHERE f.status = 0");
		return q.getResultList();
	}
	
}
