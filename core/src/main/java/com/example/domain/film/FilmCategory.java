package com.example.domain.film;

import com.example.domain.film.key.FilmCategoryKey;
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
 */
@Entity
@Getter
@Setter
@ToString
public class FilmCategory {

    @EmbeddedId
    private FilmCategoryKey filmCategoryKey;
    /**
     * lastUpdate
     */
    @Column(name = "last_update")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime lastUpdate;

}
