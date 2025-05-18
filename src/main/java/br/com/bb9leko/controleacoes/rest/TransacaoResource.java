package br.com.bb9leko.controleacoes.rest;

import br.com.bb9leko.controleacoes.dto.TransacaoDTO;
import br.com.bb9leko.controleacoes.model.Evento;
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
    public Response insereTransacao(TransacaoDTO dto) {
        Transacao transacao = new Transacao();
        transacao.setDataEvento(dto.getDataEvento());
        transacao.setTicket(dto.getTicket());
        transacao.setQuantidade(dto.getQuantidade());
        transacao.setValorCorretagem(dto.getValorCorretagem());
        transacao.setValorTaxasEmolumentos(dto.getValorTaxasEmolumentos());
        transacao.setValorUnitario(dto.getValorUnitario());
        transacao.setCorretora(dto.getCorretora());
        transacao.setCompraOUVenda(Evento.valueOf(dto.getCompraOUVenda())); // ajuste conforme seu enum

        // valorTotal será calculado automaticamente pelo metodo @PrePersist/@PreUpdate

        transacaoRepository.persist(transacao);
        return Response.ok().build();
    }



}
