package br.com.bb9leko.controleacoes.rest;

import br.com.bb9leko.controleacoes.repository.TransacaoRepository;
import br.com.bb9leko.controleacoes.model.Transacao;
import br.com.bb9leko.analiseacoes.repository.AcoesRepository;
import br.com.bb9leko.services.ApiConsumer;
import br.com.bb9leko.services.DataConvert;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static io.quarkus.arc.ComponentsProvider.LOG;

@Path("/transacao")
public class TransacaoResource {

    @Inject
    TransacaoRepository transacaoRepository;

    @Inject
    AcoesRepository ticketsRepository;

    @Inject
    ApiConsumer apiConsumer;

    @Inject
    DataConvert conversor;

    @GET
    @Path("/listaAcoesTransacoes")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listaAcoesTransacoes() {
        List<String> tickets = transacaoRepository.listAll().stream()
                .map(Transacao::getTicket)
                .collect(Collectors.toList());
        Map<String, List<String>> response = new HashMap<>();
        response.put("acoesCustodiadas", tickets);
        return Response.ok(response).build();
    }

    @PUT
    @Path("/insereTransacao")
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response insereTransacao(Transacao transacao) {
        LOG.info("Requisição recebida em /insereTransacao");
        LOG.info("Data do Evento: " + transacao.getDataEvento());
        LOG.info("Ticket: " + transacao.getTicket());
        LOG.info("Quantidade: " + transacao.getQuantidade());
        LOG.info("Valor da Corretagem: " + transacao.getValorCorretagem());
        LOG.info("Valor das Taxas e Emolumentos: " + transacao.getValorTaxasEmolumentos());
        LOG.info("Valor Unitário: " + transacao.getValorUnitario());
        LOG.info("Valor Total: " + transacao.getValorTotal());
        LOG.info("Compra ou Venda: " + transacao.getCompraOUVenda());
        LOG.info("Corretora: " + transacao.getCorretora());

        transacaoRepository.persist(transacao);
        return Response.ok().build();
    }



}
