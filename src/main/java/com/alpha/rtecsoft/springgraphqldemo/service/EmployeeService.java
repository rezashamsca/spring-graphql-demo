package com.alpha.rtecsoft.springgraphqldemo.service;

import com.alpha.rtecsoft.springgraphqldemo.model.Employee;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.*;

@Service
public class EmployeeService {
    static Map<String,Employee> employeeData;
    static {
        employeeData = new HashMap<>();
        employeeData.put("1", new Employee("1", "James Bond"));
    }

    public List<Employee> getAllEmployees() {
        List<Employee> employeeList = new ArrayList<Employee>(employeeData.values());
        return employeeList;
    }

    public Flux<Employee> getAllEmployeesReactive() {
        return Flux.fromIterable(employeeData.values());
    }
}
