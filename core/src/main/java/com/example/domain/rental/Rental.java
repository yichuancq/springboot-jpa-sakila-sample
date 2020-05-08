package com.example.domain.rental;


import com.example.domain.customer.Customer;
import com.example.domain.film.Film;
import com.example.domain.inventory.Inventory;
import com.example.domain.staff.Staff;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author yichuan
 * <p>
 * 租借表的一行表示每个inventory的租借客户、租借时间、归还时间
 */
@Entity
@Getter
@Setter
@ToString
public class Rental {

    @Id
    @GeneratedValue
    @Column(name = "rental_id")
    private Integer rentalId;


    @JoinColumn(name = "inventory_id", referencedColumnName = "inventory_id")
    @ManyToMany
    private List<Inventory> inventoryList;
    /**
     *
     */
    @JoinColumn(name = "staff_id", referencedColumnName = "staff_id")
    @ManyToMany
    private List<Staff> staffList;


    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    @ManyToMany
    private List<Customer> customerList;


    @Column(name = "rental_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime rentalDate;


    @Column(name = "return_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime returnDate;

    /**
     * lastUpdate
     */
    @Column(name = "last_update")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime lastUpdate;

}