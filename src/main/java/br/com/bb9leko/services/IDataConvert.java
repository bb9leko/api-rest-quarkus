package br.com.bb9leko.services;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface IDataConvert {
    //Generics
    <T> T obterDados(String json, Class<T> classe) throws JsonProcessingException;

}
