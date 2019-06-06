package com.kiratech.javaknow.classsample;

public class MoreClassFileExample {

    public static final String bye = "goodbye.";

    public static void main(String[] args) {
        MyHello hello = new MyHello();
        hello.greet();
    }
}

interface Hello{
    public void greet();
}

class MyHello implements Hello{
    @Override
    public void greet() {
        System.out.println(MoreClassFileExample.bye);
    }
}

