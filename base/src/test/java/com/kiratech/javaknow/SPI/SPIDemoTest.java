package com.kiratech.javaknow.SPI;

import org.junit.Test;

import java.util.ServiceLoader;
import java.util.function.Consumer;

public class SPIDemoTest {
    @Test
    public void test1() {
        ServiceLoader<Robot> serviceLoader = ServiceLoader.load(Robot.class);
        System.out.println("Java SPI.");
        Consumer<Robot> sayHello = Robot::sayHello;
        serviceLoader.forEach(sayHello);
    }


    @Test
    public void test2() {

    }


    @Test
    public void test_() {
    }

}

