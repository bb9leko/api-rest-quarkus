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
    public List<TransacaoDTO> listarTransacoes() {
        return transacaoRepository.listAll()
                .stream()
                .map(transacao -> {
                    TransacaoDTO dto = new TransacaoDTO();
                    dto.setDataEvento(transacao.getDataEvento());
                    dto.setCorretora(transacao.getCorretora());
                    dto.setClassificacaoAtivo(transacao.getClassificacaoAtivo().name());
                    dto.setTicket(transacao.getTicket());
                    dto.setCompraOUVenda(transacao.getCompraOUVenda().name());
                    dto.setQuantidade(transacao.getQuantidade());
                    dto.setValorUnitario(transacao.getValorUnitario());
                    dto.setValorTotal(transacao.getValorTotal());
                    dto.setValorTaxaLiquidacao(transacao.getValorTaxaLiquidacao());
                    dto.setValorTaxasEmolumentos(transacao.getValorTaxasEmolumentos());
                    dto.setValorImpostos(transacao.getValorImpostos());
                    dto.setOutrosValoresCobrados(transacao.getOutrosValoresCobrados());
                    dto.setValorCorretagem(transacao.getValorCorretagem());
                    dto.setValorTotalComCustosEDespesas(transacao.getValorTotalComCustosEDespesas());
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
        transacao.setCorretora(dto.getCorretora());
        transacao.setClassificacaoAtivo(ClassificacaoAtivo.valueOf(dto.getClassificacaoAtivo()));
        transacao.setTicket(dto.getTicket());
        transacao.setCompraOUVenda(Evento.valueOf(dto.getCompraOUVenda())); // ajuste conforme seu enum
        transacao.setQuantidade(dto.getQuantidade());
        transacao.setValorUnitario(dto.getValorUnitario());
        transacao.setValorTaxaLiquidacao(dto.getValorTaxaLiquidacao());
        transacao.setValorTaxasEmolumentos(dto.getValorTaxasEmolumentos());
        transacao.setValorImpostos(dto.getValorImpostos());
        transacao.setOutrosValoresCobrados(dto.getOutrosValoresCobrados());
        transacao.setValorCorretagem(dto.getValorCorretagem());
        // valorTotal e valorTotalComTaxasEDespesas será calculado automaticamente pelo metodo @PrePersist/@PreUpdate
        transacaoRepository.persist(transacao);
        return Response.ok().build();
    }

}
