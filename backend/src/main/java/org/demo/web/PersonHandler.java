package org.demo.web;

import org.demo.domain.Person;
import org.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;
import static org.springframework.web.reactive.function.server.ServerResponse.notFound;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
public class PersonHandler {

    private final PersonService personService;

    @Autowired
    public PersonHandler(PersonService personService) {
        this.personService = personService;
    }

    public Mono<ServerResponse> get(ServerRequest serverRequest) {
        final String personId = serverRequest.pathVariable("id");
        Optional<Person> person = personService.findPersonById(personId);

        return person.map(p -> ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(fromPublisher(Mono.just(p), Person.class))).orElseGet(() -> notFound().build());


    }

    public Mono<ServerResponse> all(ServerRequest serverRequest) {
        return ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(fromPublisher(Flux.fromIterable(personService.findAllPersons()), Person.class));
    }


}
