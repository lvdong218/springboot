package com.ld.demo.test;

public class TestMyQueue {
    public static void main(String[] args) throws InterruptedException {
        Object o = new String("1123123");
        Thread t = new Thread(){
            public void run(){
                System.out.println("执行thread方法");
            }
        };

        MyBlockingQueue queue=new MyBlockingQueue();
        queue.add(t);
        queue.task();
        System.out.println("尝试执行");
        t.start();
        Thread.sleep(1000);

        System.out.println("二次尝试执行");

    }
}
