package br.com.bb9leko.services;

import jakarta.enterprise.context.ApplicationScoped;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@ApplicationScoped
public class ApiConsumer {

    public String obterDados(String endereco) {
        //HttpClient client = HttpClient.newHttpClient();
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();
        //HttpResponse<String> response = null;
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            return json;
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("ERRO!?");
        }
    }
}

