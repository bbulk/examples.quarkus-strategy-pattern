package dev.bbulk.quarkus_strategy_pattern.greeting;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FrenchGreeting implements GreetingStrategy {

    @Override
    public boolean appliesTo(String language) {
        return language.equals("fr");
    }

    @Override
    public String greet() {
        return "Bonjour!";
    }
}
