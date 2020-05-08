package com.example.domain.customer;


import com.example.domain.address.Address;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
public class Customer {

    @Id
    @GeneratedValue
    @Column(name = "customer_id")
    private Integer customerId;
    /**
     * firstName
     */
    @Column(name = "first_name")
    private String firstName;
    /**
     * lastName
     */
    @Column(name = "last_name")
    private String lastName;
    /**
     * 电子邮件
     */
    @Column(name = "email")
    private String email;
    /**
     * address
     */
    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
    @OneToOne
    private Address address;

    /**
     * active
     */
    @Column(name = "active")
    private Integer active;
    /**
     * createDate
     */
    @Column(name = "create_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createDate;
    /**
     * lastUpdate
     */
    @Column(name = "last_update")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime lastUpdate;
}

