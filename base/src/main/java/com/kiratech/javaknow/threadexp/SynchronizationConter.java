package com.kiratech.javaknow.threadexp;

public class SynchronizationConter {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public synchronized void decrement() {
        count--;
    }

    public synchronized int value() {
        return count;
    }
}
