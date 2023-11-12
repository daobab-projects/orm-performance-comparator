package io.daobab.performance.jpa.repository;

import io.daobab.performance.hibernate.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentJpaService extends JpaRepository<Payment, Integer> {

    @Query("select sum(p.amount) from Payment p  where p.customer.customerId=:id")
    Double getCustomerPaymentSum(@Param("id") int id);

}
