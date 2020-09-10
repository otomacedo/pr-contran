package br.gov.presidencia.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.gov.presidencia.entity.Atividade;
import br.gov.presidencia.entity.Departamento;
import br.gov.presidencia.entity.Graduacao;
import br.gov.presidencia.entity.Gratificacao;
import br.gov.presidencia.entity.Setor;
import br.gov.presidencia.entity.TipoGratificacao;
import br.gov.presidencia.negocio.ejb.AdministracaoEJB;
import br.gov.presidencia.util.Response;

@Path("/administracao")

public class AdministracaoRest {
	
	AdministracaoEJB ejb = new AdministracaoEJB();
	
	@POST
	@Path("salvarAtividade")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarAtividade(Atividade atividade) {
	     try {
	    	ejb.salvarAtividade(atividade);
	 		return new Response("Atividade salva com sucesso",1);
		} catch (Exception e) {
			return new Response("Erro ao salvar Atividade", 12);
		}
}
	
	@DELETE
	@Path("excluirAtividade/{id}") 
	public Response excluirAtividade(@PathParam("id") Long id) {
		try {
			ejb.excluirAtividade(id);
			return new Response("Atividade Excluido com sucesso",1);
		} catch (Exception e) {
			return new Response("Erro ao Excluir atividade",2);
		}
	}
	
	@DELETE
	@Path("excluirDepartamento/{id}")
	public Response excluirDepartamento(@PathParam("id")Long id) {
		try {
			ejb.excluirDepartamento(id);
			return new Response("Departamento excluido com Sucesso",1);
		} catch (Exception e) {
			return new Response("Erro ao excluir departamento.",2);
		}
	}
	
	@DELETE
	@Path("excluirGraduacao/{id}")
	public Response excluirGraduacao(@PathParam("id")Long id) {
		try {
			ejb.excluirGraduacao(id);
			return new Response("Graduação excluido com Sucesso",1);
		} catch (Exception e) {
			return new Response("Erro ao excluir graduação.",2);
		}
	}
	
	@DELETE
	@Path("excluirSetor/{id}")
	public Response excluirSetor(@PathParam("id")Long id){
		try {
			ejb.excluirSetor(id);
			return new Response("Setor excluido com Sucesso",1);
		} catch (Exception e) {
			return new Response("Erro ao excluir setor.",2);
		}
	}
	
	@DELETE
	@Path("excluirGratificacao/{id}")
	public Response excluirGratificacao(@PathParam("id")Long id) {
		try {
			ejb.excluirGratificacao(id);
			return new Response("Gratificação excluido com Sucesso",1);
		} catch (Exception e) {
			return new Response("Erro ao excluir gratificação.",2);
		}
	}
	
	@GET
	@Path("listarAtividade/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Atividade> listarAtividade(){
		try {
			return ejb.listarAtividade();
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<Atividade>();
		}
	}
	
	@GET
	@Path("listarDepartamento")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Departamento> listarDepartamento(){
		try {
			return ejb.listarDepartamento();
		} catch (Exception e) {
			return null;
		}
	}
	
	@GET
	@Path("listarGraduacao")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Graduacao> listarGraduacao(){
		try {
			return ejb.listarGraduacao();
		}catch (Exception e) {
			return null;
		}
	}
	
	@POST
	@Path("salvarTipoGratificacao")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvatTipoGratificacao(TipoGratificacao tipoGratificacao) {
	try {
		ejb.salvarTipoGratificacao(tipoGratificacao);
		return new Response("Tipo Gratificação salva com Sucesso",1);
		} catch (Exception e) {
			return new Response("Erro ao salvar Tipo Gratificação",2);
		}
	}
	
	@GET
	@Path("listarSetor")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Setor> listarSetor(){
		try {
			return ejb.listarSetor();
		} catch (Exception e) {
			return null;
		}
	}
	
	@POST
	@Path("salvarSetor")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarSetor(Setor setor) {
		try {
			ejb.salvarSetor(setor);
			return new Response("Setor Salvo com sucesso.",1);
		} catch (Exception e) {
			return new Response("Erro ao salvar Setor",2);
		}
	}
	
	@POST
	@Path("salvarDepartamento")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarDepartamento(Departamento departamento) {
		try {
			ejb.salvarDepartamento(departamento);
			return new Response("Departamento Salvo com Sucesso",1);
		} catch (Exception e) {
			return new Response("Erro ao Salvar Departamento",2);
		}
	}
	
	@POST
	@Path("salvarGratificacao")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarGratificacao(Gratificacao gratificacao) {
		try {
			ejb.salvarGratificacao(gratificacao);
			return new Response("Gratificação Salva com Sucesso.",1);
		} catch (Exception e) {
			return new Response("Erro ao Salvar Gratificação",2);
		}
	}

	
	@POST
	@Path("salvarGraduacao")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarGraduacao(Graduacao graduacao) {
		try {
			ejb.salvarGraducao(graduacao);
			return new Response("Graduação Salva com Sucesso.",1);			
		} catch (Exception e) {
			return new Response("Erro ao salvar Graduação",2);
		}
	}
	
	
	@GET
	@Path("listarGratificacao")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Gratificacao> listarGratificacao(){
		try {
			return ejb.listarGratificacao();
		} catch (Exception e) {
			return null;
		}
	}
	





















}