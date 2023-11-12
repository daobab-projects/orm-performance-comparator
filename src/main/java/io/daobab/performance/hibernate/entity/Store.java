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
@Table(name = "store")
@Getter
@Setter
@EqualsAndHashCode
public class Store implements Serializable {

    @OneToMany(mappedBy = "store")
    List<Inventory> inventories = new ArrayList<>();
    @OneToMany(mappedBy = "store")
    List<Staff> staffs = new ArrayList<>();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    private int storeId;
    @Column(name = "manager_staff_id")
    private byte managerStaffId;
    @Column(name = "last_update")
    @UpdateTimestamp
    private LocalDateTime lastUpdate;
    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;
    @OneToMany(mappedBy = "store")
    private List<Customer> customers = new ArrayList<>();


}
