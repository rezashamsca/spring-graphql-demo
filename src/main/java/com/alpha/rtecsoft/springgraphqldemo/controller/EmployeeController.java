package com.alpha.rtecsoft.springgraphqldemo.controller;

import com.alpha.rtecsoft.springgraphqldemo.model.Employee;
import com.alpha.rtecsoft.springgraphqldemo.service.EmployeeService;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @QueryMapping()
    public List<Employee> allEmployees() {
        return this.employeeService.getAllEmployees();
    }

    @QueryMapping()
    public Flux<Employee> allEmployeesReactive() {
        return this.employeeService.getAllEmployeesReactive();
    }
}
