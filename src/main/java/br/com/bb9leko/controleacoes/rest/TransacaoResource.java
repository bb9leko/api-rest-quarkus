package br.com.bb9leko.controleacoes.rest;

import br.com.bb9leko.controleacoes.dto.ClassificacaoAtivo;
import br.com.bb9leko.controleacoes.dto.Evento;
import br.com.bb9leko.controleacoes.dto.TransacaoDTO;
import br.com.bb9leko.controleacoes.model.Transacao;
import br.com.bb9leko.controleacoes.repository.TransacaoRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/transacao")
public class TransacaoResource {

    @Inject
    TransacaoRepository transacaoRepository;

    @GET
    @Path("/listaTransacoes")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarTodasTransacoes() {
        List<Transacao> transacoes = transacaoRepository.listAll();
        return Response.ok(transacoes).build();
    }

    @POST
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
        transacao.setClassificacaoAtivo(ClassificacaoAtivo.valueOf(dto.getClassificacaoAtivo()));
        // valorTotal será calculado automaticamente pelo metodo @PrePersist/@PreUpdate

        transacaoRepository.persist(transacao);
        return Response.ok().build();
    }



}
