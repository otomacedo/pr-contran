package br.gov.presidencia.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;


public abstract class CotranDAO {


	@PersistenceUnit(unitName="pr-cotran-viagem")
	private  EntityManagerFactory emF;
	
	private  EntityManager em;
	
	protected EntityManager getEm() {
		return em;
	}

	protected EntityManager getEntityManager() {
		try {
			if (emF == null) {
				emF = Persistence.createEntityManagerFactory("pr-cotran-viagem");
			}
				
		} catch (Exception e) {
			System.out.println("Erro na cria��o do EntityManagerFactory" + e);
		}
		try {
			if (em == null)
				em = emF.createEntityManager();
		} catch (Exception e) {
			System.out.println("Erro na cria��o do EntityManager" + e);
		}
		return em;
	}
}
