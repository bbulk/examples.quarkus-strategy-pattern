package dev.bbulk.quarkus_strategy_pattern;

import dev.bbulk.quarkus_strategy_pattern.context.FromQueryParams;
import dev.bbulk.quarkus_strategy_pattern.greeting.GreetingStrategy;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    @Inject
    @FromQueryParams
    GreetingStrategy greetingStrategy;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return greetingStrategy.greet();
    }
}
