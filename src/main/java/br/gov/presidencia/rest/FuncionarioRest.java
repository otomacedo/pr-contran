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

import br.gov.presidencia.entity.Funcionario;
import br.gov.presidencia.negocio.ejb.FuncionarioEJB;
import br.gov.presidencia.util.Response;

@Path("/funcionario")
public class FuncionarioRest {
	
	@Inject
	FuncionarioEJB ejb;
	
	@POST
	@Path("salvar")
	public Response salvarFuncionario(Funcionario funcionario) {
    	return ejb.salvar(funcionario);		
	}
	
	@DELETE
	@Path("excluir/{id}")
	public Response excluirFuncionario(@PathParam("id") Integer id) {
		try {
			ejb.excluir(id);
			return new Response("excluído com sucesso",1);
		} catch (Exception e) {
			return new Response("Erro ao excluir",1);
		}
	}
	
	@GET
	@Path("consultar")
	public Funcionario consultarFuncionario(Funcionario funcionario) {
		ejb.consultar(funcionario.getIdFuncionario());
		return null;
	}

	@GET
	@Path("/listar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Funcionario> listarFuncionarios() {
		return ejb.listarFuncionario();
	}
	
	@GET
	@Path("/listarAtivos")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Funcionario> listarFuncionariosAtivos(){
		return ejb.listarFuncionariosAtivos();
	}

	@GET
	@Path("/listarInativos")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Funcionario> listarFuncionariosInativos(){
		return ejb.listarFuncionariosInativos();
	}
	
	@PUT
	@Path("editar")
	public Response alterarFuncionario(Funcionario funcionario) {
		return ejb.editar(funcionario);
	}
	@PUT
	@Path("atualizarStatus")
	public Response atualizarStatus(Funcionario funcionario) {
		return ejb.atualizarStatusFuncionario(funcionario);
	}
	
	@GET
	@Path("/filtrar/{tipo}/{valor}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Funcionario> filtrarFuncionarios(@PathParam("tipo") String tipo,@PathParam("valor") String valor){
		return ejb.filtrarFuncionarios(tipo, valor);
	}
}
