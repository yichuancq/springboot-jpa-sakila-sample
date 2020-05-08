package com.example.repostiory;

import com.example.domain.film.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepostiory extends JpaRepository<Film, Integer> {
}
