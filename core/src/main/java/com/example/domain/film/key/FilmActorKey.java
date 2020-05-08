package com.example.domain.film.key;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@ToString
@Embeddable
public class FilmActorKey implements Serializable {

    /**
     *
     */
    @Column(name = "actor_id")
    private Integer actorId;
    /**
     *
     */
    @Column(name = "film_id")
    private Integer filmId;
    // 省略setter,getter方法

}
