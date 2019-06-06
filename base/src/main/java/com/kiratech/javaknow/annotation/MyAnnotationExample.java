package com.kiratech.javaknow.annotation;

import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;

@MyAnnotation
public class MyAnnotationExample {

    @MyAnnotation
    public String name;

    @MyAnnotation(id = "aaa", num = 10)
    public void display(int a, String b) {
        System.out.println("my annotation example.");
    }

    public static void main(String[] args) throws Exception {
        Class<MyAnnotationExample> c = MyAnnotationExample.class;
        if (c.isAnnotationPresent(MyAnnotation.class)) {
            System.out.println("class " + c.getName() + " is annotated by " + MyAnnotation.class.getName());
        } else {
            System.out.println("no annotation for class " + c.getName());
        }

        Method method = c.getMethod("display", new Class[]{int.class, String.class});
        if (method.isAnnotationPresent(MyAnnotation.class)) {
            System.out.println("method display is annotated by " + MyAnnotation.class.getName());
            MyAnnotation myAnnotation = method.getAnnotation(MyAnnotation.class);
            System.out.println(myAnnotation.id());
            System.out.println(myAnnotation.num());

            System.out.println("method declaringclass:" + method.getDeclaringClass());
            System.out.println("method return type:" + method.getReturnType());
            Class<?>[] parameterTypes = method.getParameterTypes();
            for (Class<?> type : parameterTypes) {
                System.out.println("paramterTypes:" + type);
            }

            TypeVariable<Method>[] typeVariables = method.getTypeParameters();
            for (TypeVariable<Method> type : typeVariables) {
                System.out.println("typevariable:" + type);
            }

        } else {
            System.out.println("no annotation for method display");
        }

        method.invoke(new MyAnnotationExample(), 1, "aaa");

    }
}

