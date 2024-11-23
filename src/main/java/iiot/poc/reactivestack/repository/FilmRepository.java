package iiot.poc.reactivestack.repository;

import iiot.poc.reactivestack.model.Film;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface FilmRepository {
    Mono<Film> save(Film entity);

    Mono<Film> findById(Long id);

    Flux<Film> findAll();

    Mono<Void> deleteById(Long id);
}
