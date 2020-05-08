package com.example.service.actor;

import com.example.domain.actor.Actor;
import com.example.repostiory.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ActorServiceImpl implements ActorService {

    @Autowired
    private ActorRepository actorRepostiory;

    /**
     * @param actorId
     * @return
     */
    @Override
    public Actor findOneById(Integer actorId) {
        Optional<Actor> actor = actorRepostiory.findById(actorId);
        if (actor.isPresent()) {
            return actor.get();
        }
        return null;
    }
}
