package io.daobab.performance.hibernate.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "city")
@Getter
@Setter
@EqualsAndHashCode
public class City implements Serializable {

    @OneToMany(mappedBy = "city")
    List<Address> addresses = new ArrayList<>();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private int city_id;
    @Column(name = "city")
    private String city;
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;
    @UpdateTimestamp
    @Column(name = "last_update")
    private LocalDateTime lastUpdate;

}
