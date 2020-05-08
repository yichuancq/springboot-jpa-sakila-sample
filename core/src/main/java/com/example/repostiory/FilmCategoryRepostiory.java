package com.example.repostiory;

import com.example.domain.film.FilmCategory;
import com.example.domain.film.key.FilmCategoryKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmCategoryRepostiory extends JpaRepository<FilmCategory, FilmCategoryKey> {
}
