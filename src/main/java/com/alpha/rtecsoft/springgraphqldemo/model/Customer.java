package com.alpha.rtecsoft.springgraphqldemo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

// This requires Java14+
//public record Customer(@JsonProperty("id") @Id Integer id, @JsonProperty("name") String name){
//}

@Data
@AllArgsConstructor
public class Customer {
    @JsonProperty("id")
    @Id
    private final Integer id;
    @JsonProperty("name")
    private final String name;
}
