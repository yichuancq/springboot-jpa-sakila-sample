package com.example.domain.actor;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 演员
 *
 * @author yichuan
 */
@Entity
@Getter
@Setter
@ToString
public class Actor {

    @Id
    @GeneratedValue
    @Column(name = "actor_id")
    private Integer actorId;
    /**
     * 演员的名字
     */
    @Column(name = "first_name")
    private String firstName;
    /**
     * 演员的姓氏
     */
    @Column(name = "last_name")
    private String lastName;

    /**
     * 该行已创建或最近更新的时间
     */
    @Column(name = "last_update")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date lastUpdate;
}
