package iiot.poc.reactivestack.controller;

import iiot.poc.reactivestack.dto.FilmCreateRequest;
import iiot.poc.reactivestack.dto.FilmUpdateRequest;
import iiot.poc.reactivestack.model.Film;
import iiot.poc.reactivestack.service.FilmService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/films")
@RequiredArgsConstructor
public class FilmController {

    private final FilmService filmService;

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Film> getAllFilms() {
        return filmService.getAllFilms();
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Film>> getFilmById(@PathVariable Long id) {
        return filmService.getFilmById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Mono<Film> createFilm(@RequestBody FilmCreateRequest request) {
        return filmService.createFilm(FilmCreateRequest.createFilm(request));
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<Film>> updateFilm(
            @PathVariable Long id, @RequestBody FilmUpdateRequest request) {
        return filmService.getFilmById(id)
                .flatMap(existingFilm -> {
                    FilmUpdateRequest.updateFilm(existingFilm, request);
                    return filmService.updateFilm(existingFilm);
                })
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> deleteFilm(@PathVariable Long id) {
        return filmService.deleteFilm(id)
                .map(deleted -> ResponseEntity.ok().<Void>build())
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
