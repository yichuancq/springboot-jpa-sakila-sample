package com.example.repostiory;

import com.example.domain.actor.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author yichuan
 */
public interface ActorRepository extends JpaRepository<Actor,Integer> {
}
