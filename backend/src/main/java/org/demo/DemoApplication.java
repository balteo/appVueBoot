package org.demo;

import org.demo.web.PersonHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@EnableWebFlux
@SpringBootApplication
public class DemoApplication {

    @Bean
    public RouterFunction<ServerResponse> route(PersonHandler handler) {
        return RouterFunctions
                .route(GET("/person/{id}").and(accept(MediaType.APPLICATION_JSON)), handler::get)
                .andRoute(GET("/people").and(accept(MediaType.APPLICATION_JSON)), handler::all);
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
