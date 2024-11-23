package iiot.poc.reactivestack.repository;

import iiot.poc.reactivestack.model.Film;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmReactiveRepository extends ReactiveCrudRepository<Film, Long> {
}

