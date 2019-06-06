package com.kiratech.javaknow.threadexp;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedBuffer {
    private final Lock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();
    private final Object[] items = new Object[100];
    int putptr, takeptr, count;

    public BoundedBuffer() {
        this.putptr = 0;
        this.takeptr = 0;
        this.count = 0;
    }

    public void put(Object x) throws InterruptedException {
        lock.lock();
        try {
            while (count == items.length) {
                notFull.await();
            }
            items[putptr++] = x;
            if (putptr == items.length) {
                putptr = 0;
            }
            count++;
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public Object take() throws InterruptedException {
        Object item = null;
        lock.lock();
        try {
            while (count == 0) {
                notEmpty.await();
            }
            item = items[takeptr++];
            if (takeptr == items.length) {
                takeptr = 0;
            }
            count--;
            notFull.signal();
        } finally {
            lock.unlock();
        }
        return item;
    }
}
