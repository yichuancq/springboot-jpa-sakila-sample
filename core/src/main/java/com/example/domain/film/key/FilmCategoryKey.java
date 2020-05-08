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
public class FilmCategoryKey implements Serializable {

    /**
     *
     */
    @Column(name = "film_id")
    private Integer filmId;
    /**
     *
     */
    @Column(name = "category_id")
    private Integer categoryId;
}
