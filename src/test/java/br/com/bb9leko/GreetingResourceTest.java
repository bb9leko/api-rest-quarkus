package br.com.bb9leko;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.inject.Inject;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class GreetingResourceTest {

    private static final Logger LOG = LoggerFactory.getLogger(GreetingResourceTest.class);

    private String accessToken;

    @BeforeEach
    void setUp() {
         LOG.info("Access Token in Test: " + accessToken);
    }

    @Test
    void testHelloEndpoint() {
        given()
          .when().get("/testsHello/hello")
          .then()
             .statusCode(401);

    }

}