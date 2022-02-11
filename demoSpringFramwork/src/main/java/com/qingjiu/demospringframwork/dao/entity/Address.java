package com.qingjiu.demospringframwork.dao.entity;

import lombok.Data;
import lombok.NonNull;

/**
 * @author David
 */
@Data
public class Address {
    @NonNull
    private String country;

    private String province;
    private String city;
    private String area;

    Address(){
        this.country = "China";
    }
    @Override
    public String toString(){
        return "Address:"+country+"."+province+"."+city+"."+area;
    }
}
