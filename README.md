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
  
  Payment 关联对象复合查询
  
```
   /**
    * Payment 关联对象复合查询
    * @param queryPayment
    * @param pageNumber
    * @param pageSize
    * @return
    */
    @Override
    public Page<Payment> queryPageByConditions(Payment queryPayment, int pageNumber, int pageSize) {

        Pageable pageable = new PageRequest(pageNumber - 1, pageSize);

        //表关联查询 Payment 为主表
        Specification<Payment> specification = (Specification<Payment>) (root, query, cb) -> {
            //
            Predicate predicate = cb.conjunction();
            //left join
            Join<Payment, Staff> ruleJoin = root.join("staff", JoinType.LEFT);
            Join<Payment, Customer> ruleCustomerJoin = root.join("customer", JoinType.LEFT);
            // 通过staff Id过滤
            if (queryPayment != null && !StringUtils.isEmpty(queryPayment.getStaff())
                    && !StringUtils.isEmpty(queryPayment.getStaff().getStaffId())) {
                //拼接查询条件
                predicate = cb.and(predicate, cb.equal(ruleJoin.get("staffId"),
                        queryPayment.getStaff().getStaffId())); //拼接副表中的查询条件
            }
            // first name过滤
            if (queryPayment != null && !StringUtils.isEmpty(queryPayment.getStaff())
                    && !StringUtils.isEmpty(queryPayment.getStaff().getFirstName())) {
                //拼接查询条件
                predicate = cb.and(predicate, cb.equal(ruleJoin.get("firstName"),
                        queryPayment.getStaff().getFirstName())); //拼接副表中的查询条件
            }

            //payment->customer->name
            if (queryPayment != null && !StringUtils.isEmpty(queryPayment.getCustomer())
                    && !StringUtils.isEmpty(queryPayment.getCustomer().getFirstName())) {
                //拼接查询条件
                predicate = cb.and(predicate, cb.equal(ruleCustomerJoin.get("firstName"),
                        queryPayment.getCustomer().getFirstName())); //拼接副表中的查询条件
            }
            //payment->customer->address->phone
            if (queryPayment != null && !StringUtils.isEmpty(queryPayment.getCustomer())
                    && !StringUtils.isEmpty(queryPayment.getCustomer().getAddress().getPhone())) {
                //拼接查询条件
                predicate = cb.and(predicate, cb.equal(ruleCustomerJoin.get("address").get("phone"),
                        queryPayment.getCustomer().getAddress().getPhone())); //拼接副表中的查询条件
            }
            query.where(predicate);
            query.distinct(true);
            return query.getRestriction();
        };
        Page<Payment> payments = paymentRepository.findAll(Specification.where(specification), pageable);
        return payments;
    }
```