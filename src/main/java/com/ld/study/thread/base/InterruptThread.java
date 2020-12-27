package com.ld.study.thread.base;


import org.junit.Test;

/**
 * @Classname InterruptThread
 * @Description interrupt 设置线程中断标志位 线程中断方法
 * interrupted只会将中断标志改为false 并且是调用后即修改   思考：应用场景
 * isInterruput 查询线程中断标志位，是否被中断。不对线程中断标志位进行任何操作。
 * @Date 2020/12/24 11:56
 * @Authr by lvdong
 */
public class InterruptThread {
    /**
     * 关于interrupt的使用与测试
     */
    @Test
    public void test() throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();
        Thread.sleep(1000);
        myThread.interrupt();
        Thread.sleep(5000);
        System.out.println("退出主线程");
    }

    private class MyThread extends Thread {

        @Override
        public void run() {

            while (!isInterrupted()){
                System.out.println("11111");
            }
            System.out.println("Thread isInterrupt:"+isInterrupted());
            /**
             * 修改线程中断标志位
             */
            System.out.println("Thread interrupt:" +interrupted());
            System.out.println("Thread isInterrupt:"+isInterrupted());
            System.out.println("Thread interrupt:" +interrupted());
            System.out.println("Thread isInterrupt:"+isInterrupted());
            System.out.println("线程中断退出循环");
        }
    }
}
