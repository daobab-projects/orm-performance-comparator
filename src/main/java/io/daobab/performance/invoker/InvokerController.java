package io.daobab.performance.invoker;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RestController
@RequestMapping(path = "/invoker")
@Slf4j
@RequiredArgsConstructor
public class InvokerController {

    private final InvokerService service;

    @GetMapping("/testGetActors/{repeats}")
    public String testGetActors(@PathVariable("repeats") Integer repeats) throws IOException {
        return service.testGetActors(repeats);
    }

    @GetMapping("/testGetActorById/{id}/{repeats}")
    public String testGetActorById(@PathVariable("id") Integer id, @PathVariable("repeats") Integer repeats) throws IOException {
        return service.testGetActorById(id, repeats);
    }

    @GetMapping("/testGetCustomerPaymentSum/{repeats}")
    public String testGetCustomerPaymentSum(@PathVariable("repeats") Integer repeats) throws IOException {
        return service.testGetCustomerPaymentSum(repeats);
    }

    @GetMapping("/testGetCustomerAddresses/{repeats}")
    public String testGetCustomerAddresses(@PathVariable("repeats") Integer repeats) throws IOException {
        return service.testGetCustomerAddresses(repeats);
    }

}
