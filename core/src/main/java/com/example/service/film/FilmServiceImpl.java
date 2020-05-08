package com.example.service.film;

import com.example.domain.film.Film;
import com.example.repostiory.FilmRepostiory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FilmServiceImpl implements FilmService {

    @Autowired
    private FilmRepostiory filmRepostiory;


    @Override
    public Film findOneById(Integer filmId) {

        Optional<Film> film = filmRepostiory.findById(filmId);
        if (film.isPresent()) {
            return film.get();
        }
        return null;
    }
}
