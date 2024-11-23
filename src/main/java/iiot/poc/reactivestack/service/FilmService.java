package iiot.poc.reactivestack.service;
import iiot.poc.reactivestack.model.Film;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface FilmService {
    Flux<Film> getAllFilms();
    Mono<Film> getFilmById(Long id);
    Mono<Film> createFilm(Film film);
    Mono<Film> updateFilm(Film film);
    Mono<Void> deleteFilm(Long id);
}

