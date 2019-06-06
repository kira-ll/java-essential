package com.kiratech.javaknow.threadexp;

public class SimpleThread {
    public static void threadMessage(String msg) {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + ":" + msg);
    }

    public static void main(String[] args) throws InterruptedException {
        long waitTime = 15000;
        long startTime = System.currentTimeMillis();
        threadMessage("messageloop thread started.");
        Thread msgThread = new Thread(new MessageLoop());
        msgThread.start();

        while (msgThread.isAlive()) {
            threadMessage("still waiting.");
            msgThread.join(1000);
            if (System.currentTimeMillis() - startTime > waitTime
                    & msgThread.isAlive()) {
                threadMessage("tried to interrupt.");
                msgThread.interrupt();
                msgThread.join();
            }
        }
        threadMessage("process completed.");

    }

    private static class MessageLoop implements Runnable {
        @Override
        public void run() {
            String[] msg = {
                    "first",
                    "second",
                    "third",
                    "forth"
            };

            try {
                for (int i = 0; i < msg.length; i++) {
                    Thread.sleep(4000);
                    System.out.println(msg[i]);
                }
            } catch (InterruptedException e) {
                threadMessage("interrupted.");
            }
        }
    }

}
