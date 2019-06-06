package com.kiratech.javaknow.lambda.main;


import com.kiratech.javaknow.lambda.inter.MyFunctionalInterface3;

public class MyFunctionalMain3 {
    public static void main(String[] args) {
// 当表达式没有参数时一对小括号是不能省略掉的
        MyFunctionalInterface3 iHello = () -> System.out.println("liu" + "," + "good new year!");
        iHello.sayHello();
    }
}
