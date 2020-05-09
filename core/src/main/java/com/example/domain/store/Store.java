package com.example.domain.store;

import com.example.domain.address.Address;
import com.example.domain.staff.Staff;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author yichuan
 */
@Entity
@Getter
@Setter
@ToString
public class Store {

    @Id
    @GeneratedValue
    @Column(name = "store_id")
    private Integer storeId;

    /**
     * 店面地址表的外键
     */
    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
    @OneToOne
    private Address address;

    /**
     *
     */
    @JoinColumn(name = "manager_staff_id", referencedColumnName = "staff_id")
    @OneToOne
    private Staff staff;

    /**
     * lastUpdate
     */
    @Column(name = "last_update")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime lastUpdate;
}