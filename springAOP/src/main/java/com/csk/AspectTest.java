package com.csk;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class AspectTest {
    @Before(value = "execution(public void com.csk.Taop.eat())")
    public void beforeEat(){
        System.out.println("这是Before");
    }
    @After(value = "execution(public void com.csk.Taop.drink())")
    public void afterDrink(){
        System.out.println("这是After");
    }
}
