package io.daobab.performance.hibernate.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "country")
@Getter
@Setter
@EqualsAndHashCode
public class Country implements Serializable {

    @OneToMany(mappedBy = "country")
    List<City> cities = new ArrayList<>();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    private int countryId;
    @Column(name = "country")
    private String country;
    @CreationTimestamp
    @Column(name = "last_update")
    private LocalDateTime lastUpdate;

}
