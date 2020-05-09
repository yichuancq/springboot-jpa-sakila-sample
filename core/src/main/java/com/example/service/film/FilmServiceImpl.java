package com.example.service.film;

import com.example.domain.film.Film;
import com.example.repostiory.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author yichuan
 */
@Service
public class FilmServiceImpl implements FilmService {

    @Autowired
    private FilmRepository filmRepository;


    @Override
    public Film findOneById(Integer filmId) {

        Optional<Film> film = filmRepository.findById(filmId);
        if (film.isPresent()) {
            return film.get();
        }
        return null;
    }

    /**
     * 影片的多条件查询
     *
     * @param queryFilm
     * @param pageNumber
     * @param pageSize
     * @return
     */
    @Override
    public Page<Film> findAllByPage(Film queryFilm, int pageNumber, int pageSize) {
        Pageable pageable = new PageRequest(pageNumber - 1, pageSize);
        mySpecification(queryFilm);

        Specification<Film> specification = this.mySpecification(queryFilm);
        Page<Film> page = filmRepository.findAll(specification, pageable);
        return page;
    }

    /**
     * @param queryFilm
     * @return
     */
    @Override
    public List<Film> queryByConditions(Film queryFilm) {

        Specification<Film> specification = this.mySpecification(queryFilm);
        List<Film> filmList = filmRepository.findAll(specification);
        return filmList;
    }

    /**
     * specification
     *
     * @param queryFilm
     * @return
     */
    private Specification<Film> mySpecification(Film queryFilm) {
        Specification<Film> specification = (Specification<Film>) (root, query, cb) -> {
            List<Predicate> predicateList = new ArrayList<Predicate>();
            /**
             * title like
             */
            if (queryFilm != null && !StringUtils.isEmpty(queryFilm.getTitle())) {
                Predicate predicate = cb.like(root.get("title"), "%" + queryFilm.getTitle() + "%");
                predicateList.add(predicate);
            }
            /**
             * 语言 eq
             */
            if (queryFilm != null && !StringUtils.isEmpty(queryFilm.getLanguage())
                    && !StringUtils.isEmpty(queryFilm.getLanguage().getName())) {
                Predicate predicate = cb.equal(root.get("language").get("name"),
                        queryFilm.getLanguage().getName());
                predicateList.add(predicate);
            }
            /**
             * 描述 like
             */
            if (queryFilm != null && !StringUtils.isEmpty(queryFilm.getDescription())) {
                Predicate predicate = cb.like(root.get("description"), "%" + queryFilm.getDescription() + "%");
                predicateList.add(predicate);
            }
            /**
             * film 的文本信息对象属性查询）
             */
            if (queryFilm != null && !StringUtils.isEmpty(queryFilm.getFilmText())
                    && !StringUtils.isEmpty(queryFilm.getFilmText().getTitle())) {
                Predicate predicate = cb.equal(root.get("filmText").get("title"), queryFilm.getFilmText().getTitle());
                predicateList.add(predicate);
            }
            return cb.and(predicateList.toArray(new Predicate[predicateList.size()]));
        };
        return specification;
    }
}
