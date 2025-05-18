package br.com.bb9leko.controleacoes.repository;

import br.com.bb9leko.controleacoes.model.Transacao;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
    public class TransacaoRepository implements PanacheRepository<Transacao> {
}