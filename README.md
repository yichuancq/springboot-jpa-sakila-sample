# springboot-jpa-sakila-sample

  多条件查询
  
``` java
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
            if (queryFilm != null && !StringUtils.isEmpty(queryFilm.getFilmText()) && !StringUtils.isEmpty(queryFilm.getFilmText().getTitle())) {
                Predicate predicate = cb.equal(root.get("filmText").get("title"), queryFilm.getFilmText().getTitle());
                predicateList.add(predicate);
            }
            return cb.and(predicateList.toArray(new Predicate[predicateList.size()]));
        };
        Page<Film> page = filmRepository.findAll(specification, pageable);
        return page;
    }

```
