package dev.bbulk.quarkus_strategy_pattern.context;

import dev.bbulk.quarkus_strategy_pattern.greeting.GreetingStrategy;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Instance;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;

import java.util.List;

public class GreetingProducer {

    @Context
    UriInfo uriInfo;

    @Inject
    Instance<GreetingStrategy> strategies;

    private static final String DEFAULT_LANGUAGE = "en";

    @Produces
    @RequestScoped
    @FromQueryParams
    public GreetingStrategy getInstanceFromQueryContext() {
        List<String> languageList = uriInfo.getQueryParameters().get("lang");
        String language = languageList == null ? DEFAULT_LANGUAGE : languageList.getFirst();
        return strategies.stream()
                .filter(strategy -> strategy.appliesTo(language))
                .findAny()
                .orElseGet(() -> strategies.stream()
                        .filter(strategy -> strategy.appliesTo(DEFAULT_LANGUAGE))
                        .findAny()
                        .orElseThrow());
    }

}
