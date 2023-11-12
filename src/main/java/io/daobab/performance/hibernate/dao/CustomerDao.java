package io.daobab.performance.hibernate.dao;

import io.daobab.performance.hibernate.entity.Payment;
import io.daobab.performance.hibernate.model.CustomerAddress;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class CustomerDao extends AbstractDao<Payment> {

    protected CustomerDao() {
        super(Payment.class);
    }

    public List<CustomerAddress> getCustomerAddresses() {
        Session session = entityManager.unwrap(Session.class);
        return session
                .createQuery("select c.firstName, c.lastName, c.address.address, c.address.city.city from Customer c ", Object[].class)
                .getResultList()
                .stream()
                .map(o -> new CustomerAddress((String) o[0], (String) o[1], (String) o[2], (String) o[3]))
                .toList();
    }
}
