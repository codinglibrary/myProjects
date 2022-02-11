package com.qingjiu.demospringframwork.dao.entity;

import lombok.Builder;
import lombok.Data;

@Data
public class Address {
    private String Country;
    private String Province;
    private String city;
    private String area;
}
