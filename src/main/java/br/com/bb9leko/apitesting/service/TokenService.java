package br.com.bb9leko.apitesting.service;


import io.quarkus.oidc.client.OidcClient;
import io.quarkus.oidc.client.Tokens;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.jboss.logging.Logger;

@ApplicationScoped
public class TokenService {

    private static final Logger LOG = Logger.getLogger(TokenService.class);

    @Inject
    OidcClient oidcClient;

    public Tokens getTokens() {
        try {
            Tokens tokens = oidcClient.getTokens().await().indefinitely();
            if (tokens != null) {
                LOG.info("Token de Acesso: " + tokens.getAccessToken());
                return tokens;
            } else {
                LOG.error("Falha ao obter tokens.");
                return null;
            }
        } catch (Exception e) {
            LOG.error("Erro ao obter tokens", e);
            return null;
        }
    }
}
