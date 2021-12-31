package com.alpha.rtecsoft.springgraphqldemo.service;

import com.alpha.rtecsoft.springgraphqldemo.model.CustomerEvent;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.Queue;

@Service
public class CustomerQueue {
    private Queue<CustomerEvent> customerEventQueue = new LinkedList<>();

    public void addEvent(CustomerEvent customerEvent) {
        this.customerEventQueue.add(customerEvent);
    }

    public CustomerEvent getEvent() {
        return this.customerEventQueue.remove();
    }
}
