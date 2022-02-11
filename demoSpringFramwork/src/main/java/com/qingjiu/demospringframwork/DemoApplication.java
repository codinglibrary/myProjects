package com.qingjiu.demospringframwork;

import com.qingjiu.demospringframwork.service.Reading;
import com.qingjiu.demospringframwork.service.ServiceDemo;
import com.qingjiu.demospringframwork.service.Shopping;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoApplication {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("services.xml");
        ServiceDemo service = context.getBean("demo",ServiceDemo.class);
        String s = service.showInfo();

        Reading reading = context.getBean("reading", Reading.class);
        reading.showState();

//        Shopping shopping = context.getBean("shopping",Shopping.class);
//        shopping.showInfo();
    }
}
