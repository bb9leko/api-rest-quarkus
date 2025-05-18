package br.com.bb9leko.analiseacoes.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ListaAcoes(@JsonAlias("Acoes") List<DadosAcoes> acoes){


}
