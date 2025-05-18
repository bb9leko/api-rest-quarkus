package br.com.bb9leko.services;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class ApiRestClientConsumer {

    @RestClient
    ApiRestClient apiRestClient;

    public String obterDados() {
        return apiRestClient.fetchData();
    }
}