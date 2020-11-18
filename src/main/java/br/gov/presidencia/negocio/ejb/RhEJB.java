package br.gov.presidencia.negocio.ejb;

import java.util.List;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.gov.presidencia.dao.FeriasDAO;
import br.gov.presidencia.dao.RhDAO;
import br.gov.presidencia.entity.Ferias;
import br.gov.presidencia.entity.Rh;
import br.gov.presidencia.negocio.interfaces.RhInterface;
import br.gov.presidencia.util.Response;

@Model
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class RhEJB implements RhInterface{

	@Inject
	RhDAO dao;
	
	@Inject 
	FeriasDAO feriasDAO;
	
	public List<Rh> listarRh() {
		return dao.listar();
	}

	public Response excluir(Integer id) {
		return dao.excluir(id);
	}

	public Response salvar(Rh rh) {
		return dao.incluir(rh);
	}

	public Response editar(Rh rh) {
		return dao.alterar(rh);
	}
	
	public Rh conultarRh(Integer id) {
		return dao.consultar(id);
	}

	public Rh consultarRhPorFuncionario(Integer id) {
			return dao.consultarPorFuncionario(id);
	}

	public Response excluirFerias(Integer id) {
		return feriasDAO.excluir(id);
	}
	
	public List<Rh> listarTercerizados (){
		return dao.listarTercerizados();
	}
	
	public void verificarFerias(Rh rh) {
		List<Ferias> ferias = dao.consultarFeriasPorRh(rh);
		
	}
	
	public Response salvarFerias(Rh rh) {
		return dao.salvarFerias(rh);
	}
}
