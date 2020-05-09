package com.example.domain.film;

import com.example.domain.film.key.FilmActorKey;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.time.LocalDateTime;

/**
 * @author yichuan
 * <p>
 * 表是用来支持许多电影和演员之间的多对多关系 。对于每一个给定的电影演员，
 * 将有film_actor表中列出的演员和电影中的一个行.
 */
@Entity
@Getter
@Setter
@ToString
public class FilmActor {

    @EmbeddedId
    private FilmActorKey filmActorKey;

    /**
     * lastUpdate
     */
    @Column(name = "last_update")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime lastUpdate;
}
