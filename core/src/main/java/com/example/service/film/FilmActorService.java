package com.example.service.film;

import com.example.domain.film.FilmActor;
import com.example.domain.film.key.FilmActorKey;

public interface FilmActorService {

    FilmActor findOneById(FilmActorKey filmActorKey);
}
