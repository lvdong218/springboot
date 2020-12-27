package com.ld.demo.test;

import java.util.Random;

public class TestMyThreadPool {
    public static void main(String[] args){

        MyThreadPool pool = new MyThreadPool(0,3);
        pool.excute(new MyTask("task1"));
        pool.excute(new MyTask("task2"));
        pool.excute(new MyTask("task3"));
        pool.excute(new MyTask("task4"));
        pool.excute(new MyTask("task5"));

        System.out.println(pool);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pool.destroy();
    }

    /**
     * 自定义一个线程池实现类
     */
    static class MyTask implements Runnable{
        private  String name;
        private Random r= new Random();

        public MyTask(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }
        @Override
        public void run() {
            try {
                Thread.sleep(r.nextInt(1000)+2000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getId()+" sleep InterruptedException:"
                        +Thread.currentThread().isInterrupted());
                e.printStackTrace();
            }
            System.out.println("任务"+name + " 完成");
        }
    }
}
