package io.daobab.performance.hibernate.dao;

import io.daobab.performance.hibernate.entity.Payment;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;


@Repository
public class PaymentDao extends AbstractDao<Payment> {

    protected PaymentDao() {
        super(Payment.class);
    }

    public Double getCustomerPaymentSum(int id) {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("select sum(p.amount) from " + entityClass.getSimpleName() + " p where p.customer.customerId=:id", Double.class)
                .setParameter("id", id)
                .getSingleResult();
    }
}
