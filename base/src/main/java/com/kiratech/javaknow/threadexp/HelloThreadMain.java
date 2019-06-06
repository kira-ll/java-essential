package com.kiratech.javaknow.threadexp;

public class HelloThreadMain {
    public static void main(String[] args) throws InterruptedException{

        (new Thread(new HelloRunnable())).start();
        (new HelloThread()).start();

        Thread sleepT = new Thread(new SleepThread());
        sleepT.start();

//        Thread.sleep(2000);
//        sleepT.interrupt();
        sleepT.join();

        for (int i = 0; i < 6; i++) {
            Thread.sleep(1000);
            System.out.println(i);
        }

    }
}

class HelloRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("thread from runnable.");
    }
}

class HelloThread extends Thread{
    @Override
    public void run() {
        System.out.println("thead from thread.");
    }
}



class SleepThread implements Runnable{
    @Override
    public void run() {
        String[] msg = {
                "first",
                "second",
                "third",
                "forth"
        };
        for (int i = 0; i < msg.length; i++) {
            try {
                Thread.sleep(1000);
                System.out.println(msg[i]);
            } catch (InterruptedException e) {
                System.out.println("thread interrupted.");
                return;
            }
        }
    }
}
