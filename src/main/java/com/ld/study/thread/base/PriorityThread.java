package com.ld.study.thread.base;

import org.junit.Test;

/**
 * @Classname PriorityThread
 * @Description 关于线程优先级 Thread设置priority 等级为1-10级 1级最低 10级最高，是指线程获取到CPU运行的程度
 * @Date 2020/12/24 14:52
 * @Authr by lvdong
 */
public class PriorityThread {

    @Test
    public void test() throws InterruptedException {
        Thread t1= new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    System.out.println("thread t1 : 1111");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        Thread t2= new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    System.out.println("thread t2 : 22222");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        Thread t3= new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    System.out.println("thread t3 : 3333");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        t2.setPriority(10);
        t1.setPriority(1);
        t3.setPriority(5);
        t1.start();
        t2.start();
        t3.start();
        Thread.sleep(2000);
    }
}
