package com.example.service.country;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

/**
 *
 */
@Entity
@Getter
@Setter
@ToString
public class Country {
    @Id
    @GeneratedValue
    @Column(name = "country_id")
    private Integer countryId;

    private String country;

    @Column(name = "last_update")
    private LocalDateTime lastUpdate;

}
//'country_id', 'smallint(5) unsigned', 'NO', 'PRI', NULL, 'auto_increment'
//        'country', 'varchar(50)', 'NO', '', NULL, ''
//        'last_update', 'timestamp', 'NO', '', 'CURRENT_TIMESTAMP', 'on update CURRENT_TIMESTAMP'
