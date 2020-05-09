package com.example.repostiory;

import com.example.domain.actor.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author yichuan
 */
public interface ActorRepository extends JpaRepository<Actor, Integer>,
        JpaSpecificationExecutor<Actor> {
}
