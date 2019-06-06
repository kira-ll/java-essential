package com.kiratech.javaknow.threadexp;

public class NotConcurrentCountExample {
    public static void main(String[] args) throws InterruptedException {
        NotConcurrentCount counter = new NotConcurrentCount();

        Thread t1 = new Thread(new ThreadCount1(counter));
        Thread t2 = new Thread(new ThreadCount2(counter));
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("counter value is:" + counter.value());

        Thread.sleep(2000);

        NotConcurrentCount counter1 = new NotConcurrentCount();
        Thread t3 = new Thread(new ThreadCount1(counter1));
        Thread t4 = new Thread(new ThreadCount3(counter1));
        t3.start();
        t4.start();

        t3.join();
        t4.join();

        System.out.println("counter value is:" + counter1.value());

    }
}

class ThreadCount1 implements Runnable {
    NotConcurrentCount counter = null;

    public ThreadCount1(NotConcurrentCount counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            counter.increment();
        }
        System.out.println(Thread.currentThread().getName() + ":completed.");
    }
}

class ThreadCount2 implements Runnable {
    NotConcurrentCount counter = null;

    public ThreadCount2(NotConcurrentCount counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            counter.increment();
        }
        System.out.println(Thread.currentThread().getName() + ":completed.");
    }
}

class ThreadCount3 implements Runnable {
    NotConcurrentCount counter = null;

    public ThreadCount3(NotConcurrentCount counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            counter.decrement();
        }
        System.out.println(Thread.currentThread().getName() + ":completed.");
    }
}
