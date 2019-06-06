package com.kiratech.javaknow.threadexp;

public class NotConcurrentCount {
    private int c = 0;

    public NotConcurrentCount() {
    }

    public NotConcurrentCount(int c) {
        this.c = c;
    }

    public int increment() {
        return c++;
    }

    public int decrement() {
        return c--;
    }

    public int value() {
        return c;
    }
}
