package br.gov.presidencia;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

import br.gov.presidencia.filter.CorsFilter;

@ApplicationPath("api")
public class ProjetoApplication extends ResourceConfig{

	public ProjetoApplication() {
		packages("br.gov.presidencia.rest");
		register(CorsFilter.class);
	}
}
