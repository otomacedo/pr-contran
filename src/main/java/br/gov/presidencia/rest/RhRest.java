package br.gov.presidencia.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.gov.presidencia.entity.Rh;
import br.gov.presidencia.negocio.ejb.RhEJB;
import br.gov.presidencia.util.Response;

@Path(value = "rh")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RhRest {
	
	@Inject
	RhEJB ejb;

	@POST	
	@Path("salvarRh")
	public Response salvarRh(Rh rh) {
	try {
		ejb.salvar(rh);
		return new Response("RH Salvo com Sucesso",1);
	} catch (Exception e) {
		return new Response("Erro ao salvar RH",2);
	}
	}
	
	@PUT
	@Path("editarRh")
	public Response alterarRh(Rh rh) {
	try {
		ejb.editar(rh);
		return new Response("RH Alterado com sucesso!",1);
	} catch (Exception e) {
		return new Response("Erro ao Alterar RH",2);
	}	
	}

	@GET
	@Path("consultarRh/{id}")
	public Rh consultarRh(@PathParam("id") Integer id) {
		return ejb.conultarRh(id);
	}
	@DELETE
	@Path("excluirRh/{id}")	
	public Response excluirRh(@PathParam("id") Integer id ) {
		
			return ejb.excluir(id);
	}
	 
	@GET
	@Path("consultarRhPorFuncionario/{id}")
	public Rh consultarRhPorFuncionario(@PathParam("id") Integer id ) {
		try {
			return ejb.consultarRhPorFuncionario(id);
		} catch (Exception e) {
			return new Rh();
		}
	}
	
	@DELETE
	@Path("excluirFerias/{id}")	
	public Response excluirFerias(@PathParam("id") Integer id ) {
			return ejb.excluirFerias(id);
	}
	
	@GET
	@Path("/listarTercerizados")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Rh> listarFuncionarios() {
		return ejb.listarTercerizados();
	}
	
	
}
