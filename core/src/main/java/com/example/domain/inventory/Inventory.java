package com.example.domain.inventory;

import com.example.domain.film.Film;
import com.example.domain.store.Store;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 库存表的一行为存放在一个给定的商店里的一个给定的电影的copy副本。库存表是使用外键来识别电影和存
 *
 * @author yichuan
 */
@Entity
@Getter
@Setter
@ToString
public class Inventory {

    @Id
    @GeneratedValue
    @Column(name = "inventory_id")
    private Integer inventoryId;
    /**
     * 使用外键来识别电影
     */
    @JoinColumn(name = "film_id", referencedColumnName = "film_id")
    @OneToOne
    private Film film;

    /**
     * 使用外键来识别物品所在的商店
     */
    @JoinColumn(name = "store_id", referencedColumnName = "store_id")
    @OneToOne
    private Store store;

    /**
     * lastUpdate
     */
    @Column(name = "last_update")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime lastUpdate;
}
