package com.ld.demo.util;

/**
 * ThreadLocal的使用
 */
public class UserThreadLocal {
    private static ThreadLocal<Integer> threadLocal=new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue(){
            return 1;
        }
    };

    /**
     * 运行三个线程
     */
    public void startThreadArray(){
        Thread[] runs=new Thread[3];
        for(int i=0;i<runs.length;i++){
            runs[i]=new Thread(new TestThread(i));
        }
        for(int i=0;i<runs.length;i++){
            runs[i].start();
        }
    }
    public static class TestThread implements Runnable{
        int id;
        public TestThread(int id){
            this.id=id;
        }
        @Override
        public void run() {
            System.out.println(Thread.currentThread()+" start");
            Integer temp=threadLocal.get();
            temp+=id;
            threadLocal.set(temp);
            System.out.println(Thread.currentThread().getName()+":"+threadLocal.get());
        }
    }
    public static void main(String[] args){
        UserThreadLocal userThreadLocal=new UserThreadLocal();
        userThreadLocal.startThreadArray();
    }
}
