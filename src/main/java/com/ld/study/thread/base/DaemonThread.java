package com.ld.study.thread.base;

import org.junit.Test;

/**
 * @Classname DaemonThread
 * @Description 守护线程
 * @Date 2020/12/24 14:59
 * @Authr by lvdong
 */
public class DaemonThread {

    @Test
    public void test() throws InterruptedException {
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                Thread t1 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while(true){
                            System.out.println("执行t1");
                        }
                    }
                });
                t1.setDaemon(true);
                t1.start();
                System.out.println("t1是否为守护线程："+t1.isDaemon());
                System.out.println("线程t2执行完成");
            }
        });
        t2.start();
        Thread.sleep(20);
        t2.stop();
        Thread.sleep(1000);
        System.out.println("主线程执行完成");
    }
}
