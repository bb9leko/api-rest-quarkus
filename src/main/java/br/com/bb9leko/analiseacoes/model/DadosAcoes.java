package br.com.bb9leko.analiseacoes.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosAcoes(@JsonAlias("Papel") String papel,
                         @JsonAlias("Cotação") String cotacao,
                         @JsonAlias("P/VP") String pvp,
                         @JsonAlias("P/L") String pl) {
}
