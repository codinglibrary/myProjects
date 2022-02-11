package com.qingjiu.demospringframwork.dao.entity;

import lombok.Data;

@Data
public class Book {
    private Long id;
    private String name;
    private int number;
    private Locale locale;
}
