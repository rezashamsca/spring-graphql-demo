package com.alpha.rtecsoft.springgraphqldemo.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class Employee {
    @NonNull
    private String id;
    private String name;
}
