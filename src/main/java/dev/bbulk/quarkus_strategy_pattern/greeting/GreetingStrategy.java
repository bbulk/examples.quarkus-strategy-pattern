package dev.bbulk.quarkus_strategy_pattern.greeting;

public interface GreetingStrategy {
    boolean appliesTo(String language);
    String greet();
}
