package io.daobab.performance.jpa.repository;

import io.daobab.performance.hibernate.entity.Payment;
import io.daobab.performance.jpa.model.CustomerAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerJpaService extends JpaRepository<Payment, Integer> {

    @Query("select c.firstName as firstName, c.lastName as lastName, c.address.address as address, c.address.city.city as city from Customer c ")
    List<CustomerAddress> getCustomerAddresses();

}
