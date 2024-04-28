package dev.bbulk.quarkus_strategy_pattern.greeting;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EnglishGreeting implements GreetingStrategy {

    @Override
    public boolean appliesTo(String language) {
        return language.equals("en");
    }

    @Override
    public String greet() {
        return "Hello!";
    }
}
