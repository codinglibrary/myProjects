package com.qingjiu.demospringframwork.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServiceDemo {
    private final String info = "This is a service demo";
    private final Logger log = LoggerFactory.getLogger(ServiceDemo.class);

    public String showInfo(){
        log.info(info);
        return info;
    }
}
