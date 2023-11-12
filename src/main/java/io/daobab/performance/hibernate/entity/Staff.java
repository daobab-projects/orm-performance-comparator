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
@Table(name = "staff")
@Getter
@Setter
@EqualsAndHashCode
public class Staff implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "staff_id")
    private int staffId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @Column(name = "email")
    private String email;

    @Column(name = "active")
    private byte active;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @CreationTimestamp
    @Column(name = "last_update")
    private LocalDateTime lastUpdate;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    @OneToMany(mappedBy = "staff")
    private List<Payment> payments = new ArrayList<>();

    @OneToMany(mappedBy = "staff")
    private List<Rental> rentals = new ArrayList<>();


}
