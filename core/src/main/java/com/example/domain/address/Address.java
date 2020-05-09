package com.example.domain.address;

import com.example.domain.city.City;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author yichuan
 * 地址
 */
@Entity
@Getter
@Setter
@ToString
public class Address {

    @Id
    @GeneratedValue
    @Column(name = "address_id")
    private Integer addressId;
    /**
     * 地址
     */
    @Column(name = "address")
    private String address;
    /**
     * 第二地址
     */
    @Column(name = "address2")
    private String address2;
    /**
     * 该地区的所属地区，这可以是国家，省，县等
     */
    @Column(name = "district")
    private String district;
    /**
     * 指向城市表的外键
     */
    @JoinColumn(name = "city_id", referencedColumnName = "city_id")
    @OneToOne
    private City city;
    /**
     * 邮政编码
     */
    @Column(name = "postal_code")
    private String postalCode;
    /**
     * 电话
     */
    @Column(name = "phone")
    private String phone;
    /**
     * 最后修改时间
     */
    @Column(name = "last_update")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime lastUpdate;
}

