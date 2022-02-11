package com.qingjiu.demospringframwork;

import com.qingjiu.demospringframwork.service.ServiceDemo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoApplication {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("services.xml");
        ServiceDemo service = context.getBean("demo",ServiceDemo.class);
        String s = service.showInfo();
    }
}
