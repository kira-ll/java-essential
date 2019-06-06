package com.kiratech.javaknow.lambda.main;


import com.kiratech.javaknow.lambda.inter.MyFunctionalInterface1;

public class MyFunctionalMain1 {
    public static void main(String[] args) {
        // 将一个Lambda表达式赋值给一个接口，说明Lambda表达式就是一种接口数据类型，只不过该接口只能有一个抽象方法
        // 参数列表可以省略参数类型，可以写成(name, msg)，
        // 在JDK1.8中有个叫做类型推断的东西，可以自动推断出参数的类型，
        // 因为IHello中只有一个抽象方法,知道方法了就知道参数列表了，从而就能推出参数类型来
        MyFunctionalInterface1 iHello = (String name, String msg) -> {
            String hello = name + "," + msg;
            return hello;
        };

        System.out.println(iHello.sayHello("liu", "good morning!"));
    }
}
