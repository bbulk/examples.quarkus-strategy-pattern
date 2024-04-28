package dev.bbulk.quarkus_strategy_pattern;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class GreetingResourceTest {

    @Test
    void testHelloEndpointWithoutQueryParam() {
        given()
                .when().get("/hello")
                .then()
                .statusCode(200)
                .body(is("Hello!"));
    }

    static Stream<Arguments> languagesAndResult() {
        return Stream.of(
                Arguments.of("en", "Hello!"),
                Arguments.of("fr", "Bonjour!"),
                Arguments.of("de", "Hallo!"),
                Arguments.of("pl", "Hello!"));
    }

    @ParameterizedTest
    @MethodSource("languagesAndResult")
    void testHelloEndpointEN(String language, String expectedResult) {
        given()
                .when().get("/hello?lang=" + language)
                .then()
                .statusCode(200)
                .body(is(expectedResult));
    }

}