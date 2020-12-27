package com.ld.study.thread.base;

import org.junit.Test;

import java.util.Random;

/**
 * @Classname JoinThread
 * @Description Thread 中join的使用
 * @Date 2020/12/24 12:44
 * @Authr by lvdong
 */
public class JoinThread {
    /**
     * 自定义内部类实现线程 主要用于测试join方法
     */
    private class MyThread extends Thread{
        String name;
        public  MyThread(String name){
            this.name = name;
        }
        @Override
        public void run() {
            System.out.println("Thread:"+this.name + "代码执行");
            try {
                Thread.sleep((long)(Math.random()*1000)+1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread:"+this.name + "执行完成");
        }
    }

    /**
     * join 方式只是保证在当前线程中调用时，会等待被调用的线程执行完成。而当前线程调用多个join 每个join 会等待上行join结束继续执行.
     * @throws InterruptedException
     */
    @Test
    public void test() throws InterruptedException {
        MyThread t1 = new MyThread("t1");
        MyThread t2 = new MyThread("t2");
        MyThread t3 = new MyThread("t3");

        t3.start();
        t2.start();
        t1.start();
        System.out.println("t1 join");
        t1.join();
        System.out.println("t2 join");
        t2.join();
        System.out.println("t3 join");
        t3.join();


        System.out.println("main 执行完成");

    }
}
