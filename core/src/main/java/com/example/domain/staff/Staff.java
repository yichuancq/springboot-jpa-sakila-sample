package com.example.domain.staff;

import com.example.domain.address.Address;
import com.example.domain.store.Store;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author yichuan
 * 工作人员表
 */
@Entity
@Getter
@Setter
@ToString
public class Staff {

    @Id
    @GeneratedValue
    @Column(name = "staff_id")
    private Integer staffId;

    /**
     * 工作人员的地址在地址表的外键
     */
    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
    @OneToOne
    private Address address;

    /**
     * 工作人员所在的商店，用外键标识
     */
    @JoinColumn(name = "store_id", referencedColumnName = "store_id")
    @OneToOne
    private Store store;

    /**
     *
     */
    @Column(name = "first_name")
    private String firstName;

    /**
     *
     */
    @Column(name = "last_name")
    private String lastName;

    /**
     * 工作人员的照片，使用了 BLOB属性
     */
    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "picture", columnDefinition = "BLOB", nullable = true)
    private byte[] picture;

    /**
     * 工作人员的电子邮件地址
     */
    private String email;

    /**
     * 是否是活跃的工作人员
     */
    private Integer active = 1;

    /**
     * 用户名，由工作人员用来访问租赁系统
     */
    private String username;

    /**
     * 工作人员访问租赁系统所使用的密码。使用了 SHA1 函数
     */
    private String password;

    /**
     * 最后修改时间
     */
    @Column(name = "last_update")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime lastUpdate;


}