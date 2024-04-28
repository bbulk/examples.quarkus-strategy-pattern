package dev.bbulk.quarkus_strategy_pattern.greeting;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GermanGreeting implements GreetingStrategy {

    @Override
    public boolean appliesTo(String language) {
        return language.equals("de");
    }

    @Override
    public String greet() {
        return "Hallo!";
    }
}
