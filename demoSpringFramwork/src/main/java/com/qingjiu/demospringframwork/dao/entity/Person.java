package com.qingjiu.demospringframwork.dao.entity;

import lombok.Data;
import lombok.NonNull;

@Data
public class Person {
    private Long id;
    private String name;
    private Address address;

    Person(){
        this.name = "Anonymity";
        this.address = new Address();
    }
}
