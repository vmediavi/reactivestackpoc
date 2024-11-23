package iiot.poc.reactivestack.service.impl;

import iiot.poc.reactivestack.model.Film;
import iiot.poc.reactivestack.repository.FilmRepository;
import iiot.poc.reactivestack.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class FilmServiceImpl implements FilmService {

    @Autowired
    private FilmRepository filmRepository;

    @Override
    public Flux<Film> getAllFilms() {
        return filmRepository.findAll();
    }

    @Override
    public Mono<Film> getFilmById(Long id) {
        return filmRepository.findById(id);
    }

    @Override
    public Mono<Film> createFilm(Film film) {
        return filmRepository.save(film);
    }

    @Override
    public Mono<Film> updateFilm(Film film) {
        return filmRepository.save(film);
    }

    @Override
    public Mono<Void> deleteFilm(Long id) {
        return filmRepository.deleteById(id);
    }
}

