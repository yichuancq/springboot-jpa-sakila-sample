package com.example.service.city;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
public class City {

    @Id
    @GeneratedValue
    @Column(name = "city_id")
    private Integer cityId;

    private String city;
    private Integer countryId;

    @Column(name = "last_update")
    private LocalDateTime lastUpdate;

}
//'city', 'varchar(50)', 'NO', '', NULL, ''
//        'city_id', 'smallint(5) unsigned', 'NO', 'PRI', NULL, 'auto_increment'
//        'country_id', 'smallint(5) unsigned', 'NO', 'MUL', NULL, ''
//        'last_update', 'timestamp', 'NO', '', 'CURRENT_TIMESTAMP', 'on update CURRENT_TIMESTAMP'
