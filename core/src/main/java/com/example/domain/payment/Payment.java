package com.example.domain.payment;

import com.example.domain.customer.Customer;
import com.example.domain.rental.Rental;
import com.example.domain.staff.Staff;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author yichuan
 */
@Entity
@Getter
@Setter
@ToString
public class Payment {

    @Id
    @GeneratedValue
    @Column(name = "payment_id")
    private Integer paymentId;
    /***
     *
     */
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    @OneToOne
    private Customer customer;
    /**
     *
     */
    @JoinColumn(name = "staff_id", referencedColumnName = "staff_id")
    @OneToOne
    private Staff staff;
    /**
     *
     */
    @JoinColumn(name = "rental_id", referencedColumnName = "rental_id")
    @OneToOne(fetch = FetchType.LAZY)
    private Rental rental;
    /**
     *
     */
    @Column(name = "amount")
    private BigDecimal amount;
    /**
     *
     */
    @Column(name = "payment_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime paymentDate;

    /**
     * lastUpdate
     */
    @Column(name = "last_update")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime lastUpdate;

}