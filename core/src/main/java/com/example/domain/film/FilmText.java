package com.example.domain.film;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author yichuan
 * FileText
 */
@Entity
@Getter
@Setter
@ToString
public class FilmText {

    @Id
    @GeneratedValue
    @Column(name = "film_id")
    private Integer filmId;

    /**
     *
     */
    private String title;
    /***
     *
     */
    private String description;

}
