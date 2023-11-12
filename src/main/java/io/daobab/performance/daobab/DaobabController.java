package io.daobab.performance.daobab;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping(path = "/daobab", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class DaobabController implements SakilaTables {

    private final DaobabService service;

    @GetMapping(value = "/getActorById/{id}")
    String getActorById(@PathVariable("id") Integer id) {
        return service.getActorById(id).toJson();
    }

    @GetMapping(value = "/getActors")
    String getActors() {
        return service.getActors().toJson();
    }

    @GetMapping(value = "/getCustomerPaymentSum/{id}")
    Double getPaymentSum(@PathVariable("id") Integer id) {
        return service.getCustomerPaymentsSum(id);
    }

    @GetMapping(value = "/getCustomerAddresses")
    String getCustomerAddresses() {
        return service.getCustomerAddresses().findMany().toJson();
    }
}
