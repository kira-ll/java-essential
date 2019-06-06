package com.kiratech.javaknow.genericexample;

import java.util.Arrays;
import java.util.List;

public class Box<T> {
    private T t;

    public T get() {
        return t;
    }

    public void set(T t) {
        this.t = t;
    }

    public <U extends Integer> void inspect(U u) {
        System.out.println("u.intValue():"+u.intValue());
        System.out.println("type T:"+t.getClass().getName());
        System.out.println("type U:"+u.getClass().getName());

    }

    public static <E> void printList1(List<E> list) {
        System.out.println(list.getClass().getName());
        for(E elem:list){
            System.out.println(elem.getClass().getName());
            System.out.println(elem);
        }
    }
    public static void printList2(List<?> list) {
        System.out.println(list.getClass().getName());
        for(Object elem:list){
            System.out.println(elem.getClass().getName());
            System.out.println(elem);
        }
    }


    public static void main(String[] args) {
        OrderPair<String, Integer> orderPair = new OrderPair<>("a", 8);
        System.out.println(orderPair.getKey() + ":" + orderPair.getValue());

        Box<String> box = new Box<>();
        OrderPair<String, Box<String>> order = new OrderPair<>("box", box);
        System.out.println(order.getKey() + ":" + order.getValue());

        box.set("abc");
        box.inspect(10);

        Box rawBox = new Box();
        box = rawBox;
        System.out.println(box);

        OrderPair<String, String> p1 = new OrderPair<>("k", "v1");
        OrderPair<String, String> p2 = new OrderPair<>("k", "v2");
        System.out.println(Util.compare(p1,p2));

        List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
        List<String> list2 = Arrays.asList("a","b","c","d");
        printList1(list1);
        printList1(list2);
        printList2(list1);
        printList2(list2);


    }
}

interface Pair<K, V> {
    public K getKey();

    public V getValue();
}

class OrderPair<K, V> implements Pair<K, V> {
    private K key;
    private V value;

    public OrderPair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return this.key;
    }

    @Override
    public V getValue() {
        return this.value;
    }
}

class Util{
    public static <K,V> boolean compare(OrderPair<K,V> p1,OrderPair<K,V> p2){
        return p1.getKey().equals(p2.getKey()) &&
                p1.getValue().equals(p2.getValue());
    }

}