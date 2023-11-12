package io.daobab.performance.hibernate;

import io.daobab.performance.hibernate.entity.Actor;
import io.daobab.performance.hibernate.model.CustomerAddress;
import io.daobab.performance.hibernate.service.HibernateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/hibernate", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class HibernateController {

    private final HibernateService hibernateService;

    @GetMapping(value = "/getActorById/{id}")
    Actor getActor(@PathVariable("id") Integer id) {
        return hibernateService.getActor(id);
    }

    @GetMapping(value = "/getActors")
    List<Actor> getActors() {
        return hibernateService.getActors();
    }

    @GetMapping(value = "/getCustomerPaymentSum/{id}")
    Double getPaymentSum(@PathVariable("id") Integer id) {
        return hibernateService.getCustomerPaymentSum(id);
    }

    @GetMapping(value = "/getCustomerAddresses")
    List<CustomerAddress> getCustomerAddresses() {
        return hibernateService.getCustomerAddresses();
    }
}
