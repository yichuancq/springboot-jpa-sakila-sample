package com.example.repostiory;

import com.example.domain.film.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author yichuan
 */
public interface FilmRepository extends JpaRepository<Film, Integer>,
        JpaSpecificationExecutor<Film> {
}
