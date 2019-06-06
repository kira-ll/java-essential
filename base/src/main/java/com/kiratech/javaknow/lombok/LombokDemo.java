package com.kiratech.javaknow.lombok;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

public class LombokDemo {
    @Getter(value = AccessLevel.PUBLIC)
    @Setter(value = AccessLevel.PUBLIC)
    public static class Person {
        private String name;
        private int age;
        private boolean friendly;
    }

    public static class Animal {
        private String name;
        private int age;
        @Setter
        @Getter
        private boolean funny;

        public Animal() {
        }
    }

}


