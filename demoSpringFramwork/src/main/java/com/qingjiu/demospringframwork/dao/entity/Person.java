package com.qingjiu.demospringframwork.dao.entity;

import lombok.Data;

@Data
public class Person {
    private Long id;
    private String name;
    private Address address;
}
