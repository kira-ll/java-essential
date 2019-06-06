package com.kiratech.javaknow.lambda.main;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionFunctionalMain {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("good", "good", "study", "day", "day", "up");
        // 写法一：使用匿名内部类
        Collections.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(words);

        // 写法二：使用Lambda表达式
        words = Arrays.asList("ni", "hen", "bu", "hao", "bu", "hai", "shi");
        Collections.sort(words, (String o1, String o2) -> {
            return o1.compareTo(o2);
        });
        System.out.println(words);

        // 写法三：使用Lambda表达式(简写)
        words = Arrays.asList("we", "two", "two", "and", "who");
        Collections.sort(words, (o1, o2) -> o1.compareTo(o2));
        System.out.println(words);

    }
}
