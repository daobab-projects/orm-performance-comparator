package io.daobab.performance.jpa;

import io.daobab.performance.hibernate.entity.Actor;
import io.daobab.performance.jpa.model.CustomerAddress;
import io.daobab.performance.jpa.repository.ActorJpaService;
import io.daobab.performance.jpa.repository.CustomerJpaService;
import io.daobab.performance.jpa.repository.PaymentJpaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/jpa")
@RequiredArgsConstructor
public class JpaController {

    private final ActorJpaService actorService;
    private final PaymentJpaService paymentJpaService;
    private final CustomerJpaService customerJpaService;

    @GetMapping(value = "/getActorById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    Actor getActor(@PathVariable("id") Integer id) {
        return actorService.findById(id).get();
    }

    @GetMapping(value = "/getActors", produces = MediaType.APPLICATION_JSON_VALUE)
    List<Actor> getActors() {
        return actorService.findAll();
    }

    @GetMapping(value = "/getCustomerPaymentSum/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    Double getPaymentSum(@PathVariable("id") Integer id) {
        return paymentJpaService.getCustomerPaymentSum(id);
    }


    @GetMapping(value = "/getCustomerAddresses")
    List<CustomerAddress> getCustomerAddresses() {
        return customerJpaService.getCustomerAdresses();
    }


}
