package iiot.poc.reactivestack.repository;

import iiot.poc.reactivestack.model.Film;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.ReactiveHashOperations;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class FilmReactiveRepositoryAdapter implements FilmRepository {

    private final FilmReactiveRepository filmReactiveRepository;
    private final ReactiveHashOperations<String, Long, Film> hashOperations;
    private static final String KEY = "film";

    private Mono<Film> updateRedisCache(Film film) {
        return hashOperations.put(KEY, film.getFilmId(), film)
                .thenReturn(film);
    }

    @Override
    public Mono<Film> save(Film entity) {
        return filmReactiveRepository.save(entity)
                .flatMap(this::updateRedisCache);
    }

    @Override
    public Mono<Film> findById(Long id) {
        return hashOperations.get(KEY, id)
                .switchIfEmpty(filmReactiveRepository.findById(id))
                .flatMap(this::updateRedisCache);
    }

    @Override
    public Flux<Film> findAll() {
        return filmReactiveRepository.findAll();
    }

    @Override
    public Mono<Void> deleteById(Long id) {
        return hashOperations.remove(KEY, id)
                .flatMap(filmReactiveRepository::deleteById);
    }
}
