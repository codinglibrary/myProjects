package com.qingjiu.demospringframwork;

import com.qingjiu.demospringframwork.service.Reading;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoApplication {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("services.xml");

        Reading reading = context.getBean("reading-person", Reading.class);
        reading.showState();


//        Shopping shopping = context.getBean("shopping",Shopping.class);
//        shopping.showInfo();
    }
}
