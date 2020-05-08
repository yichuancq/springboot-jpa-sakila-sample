package com.example.service.film;

import com.example.domain.film.FilmActor;
import com.example.domain.film.key.FilmActorKey;
import com.example.repostiory.FilmActorRepostiory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FilmActorServiceImpl implements FilmActorService {

    @Autowired
    private FilmActorRepostiory filmActorRepostiory;

    @Override
    public FilmActor findOneById(FilmActorKey filmActorKey) {
        Optional<FilmActor> filmActor = filmActorRepostiory.findById(filmActorKey);
        if (filmActor.isPresent()) {
            return filmActor.get();
        }
        return null;
    }
}
