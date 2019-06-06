package com.kiratech.javaknow.lambda.main;

import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class NativeFunctionalMain {
    public static String end = "";

    // 直接使用JDK1.8提供的接口，不需要再定义IHello接口, 直接使用JDK提供的接口来接收Lambda表达式
    public static void main(String[] args) {
        Supplier<String> supplier = () -> "supplier,how old a u?";
        String content = supplier.get();
        System.out.println(content);

        Consumer<String> consumer = name -> System.out.println(name + ",how old a u?");
        consumer.accept("consumers");

        Function<Integer, Integer> add3 = a -> a + 3;
        Integer b = 1;
        Integer c = add3.apply(b);
        System.out.println("Function add3:" + b + "+3=" + c);

        // 在代码块的内部可以访问静态全局变量
        // 在代码块中可以访问外边局部变量
        // 在代码块的内部可以修改全局静态变量
        // 在代码块内部是不能访问接口中的其它方法的
        String split = ",";
        BiFunction<String, String, String> biFunction = (name, msg) -> {
            end = "!";
            return name + split + msg + end;
        };
        String cd = biFunction.apply("biFunction", "hello");
        System.out.println(cd);

        // 根据字符串长度比较大小
        Comparator<String> comp = (o1, o2) -> {
            return  o1.length() - o2.length();
        };
        int compRs = comp.compare("short", "len");
        System.out.println(compRs);

    }
}
