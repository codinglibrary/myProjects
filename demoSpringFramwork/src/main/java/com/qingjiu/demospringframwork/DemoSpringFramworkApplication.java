package com.qingjiu.demospringframwork;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class DemoSpringFramworkApplication {
    private final static Logger log = LoggerFactory.getLogger(DemoSpringFramworkApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(DemoSpringFramworkApplication.class, args);
    }

}
