package dev.bbulk.quarkus_strategy_pattern;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@QuarkusTest
class ServiceTest {

    @Inject
    GreetingService service;

    static Stream<Arguments> strategiesAndResults() {
        return Stream.of(
                Arguments.of("en", "Hello!"),
                Arguments.of("fr", "Bonjour!"),
                Arguments.of("de", "Hallo!"));
    }

    @ParameterizedTest
    @MethodSource("strategiesAndResults")
    void testStrategies(String language, String expectedResult) {
        String greeting = service.getGreeting(language);

        Assertions.assertEquals(expectedResult, greeting);
    }

}