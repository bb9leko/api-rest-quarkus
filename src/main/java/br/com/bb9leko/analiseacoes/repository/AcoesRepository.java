package br.com.bb9leko.analiseacoes.repository;

import br.com.bb9leko.analiseacoes.model.Acoes;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AcoesRepository implements PanacheRepository<Acoes> {

}
