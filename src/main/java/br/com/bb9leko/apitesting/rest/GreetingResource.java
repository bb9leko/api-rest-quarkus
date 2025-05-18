package br.com.bb9leko.apitesting.rest;

import br.com.bb9leko.apitesting.service.TokenService;
import io.quarkus.oidc.client.Tokens;
import io.smallrye.mutiny.Uni;
import jakarta.annotation.security.RolesAllowed;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/")
public class GreetingResource {

    private static final Logger LOG = LoggerFactory.getLogger(GreetingResource.class);

    @Inject
    TokenService tokenService;

    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    @RolesAllowed("api-rest-quarkus")
    public String hello() {
        LOG.info("Requisição recebida em /hello");
        return "Hello World!";
    }

    @GET
    @Path("/helloJson")
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed("api-rest-quarkus")
    public Uni<Response> helloJson() {
        LOG.info("Requisição recebida em /helloJson");

        JsonObject json = Json.createObjectBuilder()
                .add("message", "Retorno em JSON")
                .add("status", "OK")
                .build();

        return Uni.createFrom().item(() -> Response.ok(json).build());
    }

    @GET
    @Path("/token")
    @Produces(MediaType.TEXT_PLAIN)
    @RolesAllowed("api-rest-quarkus")
    public Response getTokens() {
        Tokens tokens = tokenService.getTokens();
        if (tokens != null) {
            return Response.ok().entity("Token de Acesso: " + tokens).build();
        } else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao obter token").build();
        }
    }


}


