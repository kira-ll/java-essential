package com.kiratech.javaknow.lambda.main;

import java.util.function.Predicate;

public class PredicateFunctionalMain {
    public static void main(String[] args) {
        String email = "shown@qq.com";

        Predicate<String> predicate = str -> str.length() < 20;
        boolean result = predicate.test(email);
        System.out.println(result);

        result = predicate.negate().test(email);
        System.out.println(result);

        Predicate<String> orPredicate = str -> str.contains("@");
        result = predicate.or(orPredicate).test(email);
        System.out.println(result);

        Predicate<String> andPredicate = str -> str.length() > 0;
        result = predicate.and(andPredicate).test(email);
        System.out.println(result);

        result = Predicate.isEqual("andy@qq.com").test(email);
        System.out.println(result);
    }
}
