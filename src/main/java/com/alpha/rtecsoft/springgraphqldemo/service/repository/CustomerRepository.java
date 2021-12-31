package com.alpha.rtecsoft.springgraphqldemo.service.repository;

import com.alpha.rtecsoft.springgraphqldemo.model.Customer;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface CustomerRepository extends ReactiveCrudRepository<Customer, Integer> {
}
