package dev.bbulk.quarkus_strategy_pattern;

import dev.bbulk.quarkus_strategy_pattern.greeting.GreetingStrategy;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;

@ApplicationScoped
public class GreetingService {

    @Inject
    Instance<GreetingStrategy> strategies;

    public String getGreeting(String language) {
        return strategies.stream()
                .filter(strategy -> strategy.appliesTo(language))
                .findAny()
                .map(GreetingStrategy::greet)
                .orElseThrow(() -> new IllegalArgumentException(language + " not supported!"));
    }

}
