package com.example.service.actor;

import com.example.domain.actor.Actor;

/**
 *
 */
public interface ActorService {

    /**
     * @param actorId
     * @return
     */
    Actor findOneById(Integer actorId);
}
