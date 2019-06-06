package com.kiratech.javaknow.lambda.main;


import com.kiratech.javaknow.lambda.inter.MyFunctionalInterface2;

public class MyFunctionalMain2 {
    public static void main(String[] args) {
// 参数列表可以省略参数类型，当只有一个参数时可以省略小括号 (String name) --> (name) --> name
        // 当方法体中只有一行代码并且有返回值时可以同时省略花括号和return
        // { return name + ": " + "happy new year everyone!";} --> name + ": " + "happy new year everyone!";
        MyFunctionalInterface2 iHello = name -> name + "," + "good afternoon!";
        System.out.println(iHello.sayHello("liu"));
    }
}
