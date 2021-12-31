package com.alpha.rtecsoft.springgraphqldemo.model;

// This requires Java 14+
//public record CustomerEvent(Customer customer, CustomerEventType event) {
//}

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerEvent {
    private final Customer customer;
    private final CustomerEventType event;
}
