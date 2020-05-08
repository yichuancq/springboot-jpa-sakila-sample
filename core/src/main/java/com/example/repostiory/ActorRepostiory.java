package com.example.repostiory;

import com.example.domain.actor.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author yichuan
 */
public interface ActorRepostiory extends JpaRepository<Actor,Integer> {
}
