package io.daobab.performance.hibernate.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "payment")
@Getter
@Setter
@EqualsAndHashCode
public class Payment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private int paymentId;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "staff_id")
    private Staff staff;

    @ManyToOne
    @JoinColumn(name = "rental_id")
    private Rental rental;

    @Column(name = "amount")
    private double amount;

    @Column(name = "payment_date")
    private LocalDateTime paymentDate;

    @CreationTimestamp
    @Column(name = "last_update")
    private LocalDateTime lastUpdate;


}
