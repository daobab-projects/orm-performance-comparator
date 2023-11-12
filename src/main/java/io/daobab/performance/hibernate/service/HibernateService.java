package io.daobab.performance.hibernate.service;

import io.daobab.performance.hibernate.dao.ActorDao;
import io.daobab.performance.hibernate.dao.CustomerDao;
import io.daobab.performance.hibernate.dao.PaymentDao;
import io.daobab.performance.hibernate.entity.Actor;
import io.daobab.performance.hibernate.model.CustomerAddress;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HibernateService {

    private final ActorDao actorDao;
    private final PaymentDao paymentDao;
    private final CustomerDao customerDao;

    public Actor getActor(Integer id) {
        return actorDao.getById(id);
    }

    public List<Actor> getActors() {
        return actorDao.getAll();
    }

    public Double getCustomerPaymentSum(Integer id) {
        return paymentDao.getCustomerPaymentSum(id);
    }

    public List<CustomerAddress> getCustomerAddresses() {
        return customerDao.getCustomerAddresses();
    }


}
