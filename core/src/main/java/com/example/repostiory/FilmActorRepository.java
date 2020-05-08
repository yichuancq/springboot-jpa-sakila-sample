package com.example.repostiory;

import com.example.domain.film.FilmActor;
import com.example.domain.film.key.FilmActorKey;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author yichuan
 */
public interface FilmActorRepository extends JpaRepository<FilmActor, FilmActorKey> {
}
