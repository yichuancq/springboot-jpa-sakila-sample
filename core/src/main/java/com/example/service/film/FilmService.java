package com.example.service.film;

import com.example.domain.film.Film;
import org.springframework.data.domain.Page;

import java.util.List;

public interface FilmService {

    /***
     * 通过Id查询
     * @param filmId
     * @return
     */
    Film findOneById(Integer filmId);

    /**
     * 分页查询
     *
     * @param film
     * @param pageNumber
     * @param pageSize
     * @return
     */
    Page<Film> findAllByPage(Film film, int pageNumber, int pageSize);

    /**
     * 多条件动态查询
     *
     * @param film
     * @return
     */
    List<Film> queryByConditions(Film film);
}
