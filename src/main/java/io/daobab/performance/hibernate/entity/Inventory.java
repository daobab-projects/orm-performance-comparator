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
@Table(name = "inventory")
@Getter
@Setter
@EqualsAndHashCode
public class Inventory implements Serializable {

    @OneToMany(mappedBy = "inventory")
    List<Rental> rentals = new ArrayList<>();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventory_id")
    private int inventoryId;
    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film film;
    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;
    @Column(name = "last_update")
    @UpdateTimestamp
    private LocalDateTime lastUpdate;


}
