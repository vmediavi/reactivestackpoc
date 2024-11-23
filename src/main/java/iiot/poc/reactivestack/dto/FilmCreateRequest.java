package iiot.poc.reactivestack.dto;

import iiot.poc.reactivestack.model.Film;

import java.time.LocalDate;

public record FilmCreateRequest(
        String title,
        String description,
        Integer releaseYear,
        Long languageId,
        Integer rentalDuration,
        Double rentalRate,
        Integer length,
        Double replacementCost,
        String rating,
        String specialFeatures,
        LocalDate lastUpdate) {

    public static Film createFilm(FilmCreateRequest filmCreateRequest) {
        var film = new Film();
        film.setTitle(filmCreateRequest.title());
        film.setDescription(filmCreateRequest.description());
        film.setReleaseYear(filmCreateRequest.releaseYear());
        film.setLanguageId(filmCreateRequest.languageId());
        film.setRentalDuration(filmCreateRequest.rentalDuration());
        film.setRentalRate(filmCreateRequest.rentalRate());
        film.setLength(filmCreateRequest.length());
        film.setReplacementCost(filmCreateRequest.replacementCost());
        film.setRating(filmCreateRequest.rating());
        film.setSpecialFeatures(filmCreateRequest.specialFeatures());
        film.setLastUpdate(filmCreateRequest.lastUpdate());
        return film;
    }
}

