package br.com.bb9leko.services;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/dados")
@RegisterRestClient
public interface ApiRestClient {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    String fetchData();
}
