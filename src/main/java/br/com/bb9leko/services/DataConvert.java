package br.com.bb9leko.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DataConvert implements IDataConvert {

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T obterDados(String json, Class<T> classe)  {
        try {
            return mapper.readValue(json, classe);
        }
        catch (JsonProcessingException e) {

            throw new RuntimeException(e);

        }
    }



}