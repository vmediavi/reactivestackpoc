package iiot.poc.reactivestack.dto;

import iiot.poc.reactivestack.model.Film;

import java.time.LocalDate;

public record FilmUpdateRequest(
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
        LocalDate lastUpdate
) {
    public static Film updateFilm(Film existingFilm, FilmUpdateRequest filmUpdateRequest) {
        existingFilm.setTitle(filmUpdateRequest.title());
        existingFilm.setDescription(filmUpdateRequest.description());
        existingFilm.setReleaseYear(filmUpdateRequest.releaseYear());
        existingFilm.setLanguageId(filmUpdateRequest.languageId());
        existingFilm.setRentalDuration(filmUpdateRequest.rentalDuration());
        existingFilm.setRentalRate(filmUpdateRequest.rentalRate());
        existingFilm.setLength(filmUpdateRequest.length());
        existingFilm.setReplacementCost(filmUpdateRequest.replacementCost());
        existingFilm.setRating(filmUpdateRequest.rating());
        existingFilm.setSpecialFeatures(filmUpdateRequest.specialFeatures());
        existingFilm.setLastUpdate(filmUpdateRequest.lastUpdate());
        return existingFilm;
    }
}

