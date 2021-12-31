package com.alpha.rtecsoft.springgraphqldemo.controller;

import com.alpha.rtecsoft.springgraphqldemo.model.Customer;
import com.alpha.rtecsoft.springgraphqldemo.model.CustomerEvent;
import com.alpha.rtecsoft.springgraphqldemo.model.CustomerEventType;
import com.alpha.rtecsoft.springgraphqldemo.service.repository.CustomerRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SubscriptionMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

import java.time.Duration;
import java.util.stream.Stream;

@RestController
public class CustomerController {
    private final CustomerRepository customerRepository;
    final Sinks.Many<CustomerEvent> sink = Sinks.many().multicast().onBackpressureBuffer();

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @QueryMapping
    public Flux<Customer> customers() {
        return this.customerRepository.findAll();
    }

    @MutationMapping
    public Mono<Customer> addCustomer(@Argument String name) {
        return this.customerRepository.save(new Customer(null, name));
    }

    @SubscriptionMapping
    Flux<CustomerEvent> customerEvents(@Argument Integer id) {
        return this.customerRepository.findById(id)
                .flatMapMany(customer -> {
                    var stream = Stream.generate(() -> new CustomerEvent(customer, CustomerEventType.CREATED));
                    return Flux.fromStream(stream);
                })
                .delayElements(Duration.ofSeconds(1))
                .take(10);
    }
}
