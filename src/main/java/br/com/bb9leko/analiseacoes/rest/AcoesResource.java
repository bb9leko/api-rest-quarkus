package br.com.bb9leko.analiseacoes.rest;

import br.com.bb9leko.analiseacoes.model.Acoes;
import br.com.bb9leko.analiseacoes.model.DadosAcoes;
import br.com.bb9leko.analiseacoes.model.ListaAcoes;
import br.com.bb9leko.analiseacoes.repository.AcoesRepository;
import br.com.bb9leko.controleacoes.repository.TransacaoRepository;
import br.com.bb9leko.services.ApiConsumer;
import br.com.bb9leko.services.ApiRestClientConsumer;
import br.com.bb9leko.services.DataConvert;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import static io.quarkus.arc.ComponentsProvider.LOG;

@Path("/acoes")
public class AcoesResource {

    @Inject
    TransacaoRepository transacaoRepository;

    @Inject
    AcoesRepository acoesRepository;

    @Inject
    ApiConsumer apiConsumer;

    @Inject
    DataConvert conversor;

    @Inject
    ApiRestClientConsumer apiRestClientConsumer;

    @GET
    @Path("/listaAcoes")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public DadosAcoes getTickets1() {
        var json = apiConsumer.obterDados("http://127.0.0.1:8000/api/dados");
        LOG.info("JSON: " + json);
        //DadosTickets dados = conversor.obterDados(json, DadosTickets.class);
        DadosAcoes dados = conversor.obterDados(json, DadosAcoes.class);
        LOG.info("Dados: " + dados);
        return dados;
    }

    @GET
    @Path("/listaAcoes2")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTickets2() {
        var json = apiRestClientConsumer.obterDados();
        LOG.info("JSON: " + json);
        //DadosTickets dados = conversor.obterDados(json, DadosTickets.class);
        ListaAcoes dados = conversor.obterDados(json, ListaAcoes.class);
        LOG.info("ListaAcoes: " + dados);
        return Response.ok(dados).build();
    }

    @GET
    @Path("/persisteAcoes")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public void getAcoes() {
        var json = apiConsumer.obterDados("http://127.0.0.1:8000/api/dados");
        LOG.info("JSON: " + json);
        ListaAcoes listaAcoes = conversor.obterDados(json, ListaAcoes.class);
        for (DadosAcoes dados : listaAcoes.acoes()) {
            LOG.info("Dados: " + dados);
            Acoes tickets = new Acoes(dados);
            LOG.info("Tickets: " + tickets);
            acoesRepository.persist(tickets);
        }
    }

    @GET
    @Path("/restClientConsumer")
    @Produces(MediaType.APPLICATION_JSON)
    public String getData() {
        return apiRestClientConsumer.obterDados();
    }
}
