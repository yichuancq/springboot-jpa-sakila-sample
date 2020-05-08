package com.example.repostiory;

import com.example.domain.film.Film;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author yichuan
 */
public interface FilmRepository extends JpaRepository<Film, Integer> {
}
