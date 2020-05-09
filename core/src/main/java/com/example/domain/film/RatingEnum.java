package com.example.domain.film;

/**
 * @author yichuan
 * 分配给电影评级。可以是 G， PG，PG - 13，R 或NC - 17
 */
public enum RatingEnum {
    G("G"),
    PG("PG"),
    PG13("PG-13"),
    R("R"),
    NC17("NC-17");
    String name;
    RatingEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
