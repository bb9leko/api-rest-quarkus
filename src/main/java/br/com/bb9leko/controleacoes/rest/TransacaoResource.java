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
import java.util.stream.Collectors;

@Path("/transacao")
public class TransacaoResource {

    @Inject
    TransacaoRepository transacaoRepository;

    @GET
    @Path("/listaTransacoes")
    public List<TransacaoDTO> listarTodasTransacoes() {
        return transacaoRepository.listAll()
                .stream()
                .map(transacao -> {
                    TransacaoDTO dto = new TransacaoDTO();
                    dto.setDataEvento(transacao.getDataEvento());
                    dto.setTicket(transacao.getTicket());
                    dto.setQuantidade(transacao.getQuantidade());
                    dto.setValorCorretagem(transacao.getValorCorretagem());
                    dto.setValorTaxasEmolumentos(transacao.getValorTaxasEmolumentos());
                    dto.setValorUnitario(transacao.getValorUnitario());
                    dto.setValorTotal(transacao.getValorTotal().doubleValue());
                    dto.setCompraOUVenda(transacao.getCompraOUVenda().name());
                    dto.setCorretora(transacao.getCorretora());
                    dto.setClassificacaoAtivo(transacao.getClassificacaoAtivo().name());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    @POST
    @Path("/insereTransacao")
    @Produces(MediaType.APPLICATION_JSON)
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
