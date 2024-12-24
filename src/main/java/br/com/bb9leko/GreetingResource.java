package br.com.bb9leko;

//import br.com.bb9leko.application.TokenService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/testsHello")
public class GreetingResource {

    private static final Logger LOG = LoggerFactory.getLogger(GreetingResource.class);

    //@Inject
    //TokenService tokenService;

    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    @RolesAllowed("api-rest-quarkus")
    public String hello() {
        //tokenService.acquireTokens();
        LOG.info("Requisição recebida em /hello");
        return "É isso ai Leandro!";
    }

    @GET
    @Path("/helloJson")
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed("api-rest-quarkus")
    public Response helloJson() {
        LOG.info("Requisição recebida em /helloJson");

        JsonObject json = Json.createObjectBuilder()
                .add("message", "Retorno em JSON")
                .add("status", "OK")
                .build();

        return Response.ok(json).build();
    }
}
