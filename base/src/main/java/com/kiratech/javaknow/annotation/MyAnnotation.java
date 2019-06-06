package com.kiratech.javaknow.annotation;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.FIELD, ElementType.METHOD})
public @interface MyAnnotation {
    String id() default "";

    int num() default -1;
}
