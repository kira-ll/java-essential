package com.kiratech.javaknow.threadexp;

public class GuardsBlockString {

    public static void main(String[] args) {
        GuardsBlockObject guardsBlockObject=new GuardsBlockObject();
        for (int i = 0; i < 5; i++) {
            (new Thread(new Producer(guardsBlockObject))).start();
            (new Thread(new Consumer(guardsBlockObject))).start();

        }
    }

    static class GuardsBlockObject {
        private String msg;
        private boolean empty = true;

        public synchronized String take() {
            while (empty) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            empty = true;
            notifyAll();
            return msg;
        }

        public synchronized void put(String msg) {
            while (!empty) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            empty = false;
            this.msg = msg;
            notifyAll();
            return;
        }
    }

    static class Producer implements Runnable {
        GuardsBlockObject guardsBlockObject;

        public Producer(GuardsBlockObject guardsBlockObject) {
            this.guardsBlockObject = guardsBlockObject;
        }

        @Override
        public void run() {
            String[] msgs = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
            for (int i = 0; i < msgs.length; i++) {
                guardsBlockObject.put(msgs[i]);
                System.out.println(Thread.currentThread().getName()
                        + ":put " + msgs[i]);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            guardsBlockObject.put("done.");
            System.out.println(Thread.currentThread().getName()+":put is completed.");
        }
    }

    static class Consumer implements Runnable{
        GuardsBlockObject guardsBlockObject;

        public Consumer(GuardsBlockObject guardsBlockObject) {
            this.guardsBlockObject = guardsBlockObject;
        }

        @Override
        public void run() {
            String msg = guardsBlockObject.take();
            while (!msg.equals("done.")) {
                System.out.println(Thread.currentThread().getName() + ":take " + msg);
                msg=guardsBlockObject.take();
            }
            System.out.println(Thread.currentThread().getName()+":take is done.");
        }
    }
}
