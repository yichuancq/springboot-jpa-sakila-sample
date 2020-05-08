package com.example.domain.film;

import com.example.domain.language.Language;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author yichuan
 */

@Getter
@Setter
@ToString
@Entity
public class Film {

    @Id
    @GeneratedValue
    @Column(name = "film_id")
    private Integer filmId;

    /**
     * 标题
     */
    @Column(name = "title")
    private String title;

    /**
     * 一个简短的描述或电影的情节摘要
     */
    @Column(name = "description")
    private String description;

    /**
     * 电影发行的年份
     */
    @Column(name = "release_year")
    private Date releaseYear;

    /**
     * 使用外键来标示语言
     */
    @JoinColumn(name = "language_id", referencedColumnName = "language_id", insertable = false, updatable = false)
    @OneToOne
    private Language language;

    /**
     * 使用外键来标示语言
     * Film中的original_language_id字段参考Language表中的language_id字段
     */
    @JoinColumn(name = "original_language_id", referencedColumnName = "language_id", insertable = false, updatable = false)
    @OneToOne
    private Language originalLanguage;

    /**
     * 租赁期限的长短，以天作为单位
     */
    @Column(name = "rental_duration")
    private Integer rentalDuration;
    /**
     * 指定的期限内电影的租金
     */
    @Column(name = "rental_rate")
    private BigDecimal rentalRate;
    /**
     * 影片的长度，以分钟为单位。
     */
    @Column(name = "length")
    private Integer length;
    /**
     * 如果电影未被归还或损坏状态向客户收取的款项
     */
    @Column(name = "replacement_cost")
    private BigDecimal replacementCost;
    /**
     * 包括DVD上常见的特殊功能的列表
     */
    @Column(name = "special_features")
    private String specialFeatures;
    /**
     * 分配给电影评级。可以是 G， PG，PG - 13 ， R 或NC - 17
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "rating")
    private RatingEnum rating;
}
