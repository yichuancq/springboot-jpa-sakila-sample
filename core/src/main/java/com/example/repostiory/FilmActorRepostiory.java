package com.example.repostiory;

import com.example.domain.film.FilmActor;
import com.example.domain.film.key.FilmActorKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmActorRepostiory extends JpaRepository<FilmActor, FilmActorKey> {
}
