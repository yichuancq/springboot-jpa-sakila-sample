package com.example.domain.film.key;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author yichuan
 * FilmActorKey
 */
@Getter
@Setter
@ToString
@Embeddable
public class FilmActorKey implements Serializable {

    /**
     * 演员ID
     */
    @Column(name = "actor_id")
    private Integer actorId;
    /**
     * 电影Id
     */
    @Column(name = "film_id")
    private Integer filmId;
    // 省略setter,getter方法

}
