package com.example.repostiory;

import com.example.domain.film.FilmCategory;
import com.example.domain.film.key.FilmCategoryKey;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author yichuan
 */
public interface FilmCategoryRepository extends JpaRepository<FilmCategory, FilmCategoryKey> {
}
