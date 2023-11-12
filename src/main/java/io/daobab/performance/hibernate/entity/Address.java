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
@Table(name = "address")
@Getter
@Setter
@EqualsAndHashCode
public class Address implements Serializable {

    @OneToMany(mappedBy = "address")
    List<Store> stores = new ArrayList<>();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private int addressId;
    @Column(name = "address")
    private String address;
    @Column(name = "address2")
    private String address2;
    @Column(name = "district")
    private String district;
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;
    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "phone")
    private String phone;

    @UpdateTimestamp
    @Column(name = "last_update")
    private LocalDateTime lastUpdate;


    @OneToMany(mappedBy = "address")
    private List<Customer> customers = new ArrayList<>();

    @OneToMany(mappedBy = "address")
    private List<Staff> staffs = new ArrayList<>();


}
