package com.example.domain.country;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

/**
 * @author yichuan
 * 国家
 */
@Entity
@Getter
@Setter
@ToString
public class Country {
    /**
     * ID
     */
    @Id
    @GeneratedValue
    @Column(name = "country_id")
    private Integer countryId;

    /**
     * 国家
     */
    @Column(name = "country")
    private String country;
    /**
     * 最后修改时间
     */
    @Column(name = "last_update")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime lastUpdate;
}
