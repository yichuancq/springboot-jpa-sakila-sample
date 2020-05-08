package com.example.repostiory;

import com.example.domain.film.FilmText;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author yichuan
 */
public interface FilmTextRepository extends JpaRepository<FilmText, Integer> {
}
