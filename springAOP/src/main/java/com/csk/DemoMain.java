package com.csk;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ClassPathXmlApplicationContext;
@ComponentScan(basePackages = {"com.csk"})
public class DemoMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        Taop taop = context.getBean(Taop.class);
        taop.eat();
        taop.drink();
    }
}
