package com.ld.demo.threadlocal;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadLocalOOM {
    private static final int TASK_LOOP_SIZE = 10000;
    final static ThreadPoolExecutor poolExcutor =
            new ThreadPoolExecutor(5,5,5, TimeUnit.MINUTES,new LinkedBlockingQueue<>());
    static class LocalVariable{
        //设置一个5M大小的byte类型的数组
        private byte[] a = new byte[1024*1024*5];
    }
    ThreadLocal<LocalVariable> localVariable;
    public static void main(String[] args){
        for(int i=0;i<TASK_LOOP_SIZE;i++){
            poolExcutor.execute(new Runnable() {
                @Override
                public void run() {
                    ThreadLocalOOM oom = new ThreadLocalOOM();
                    oom.localVariable = new ThreadLocal<>();
                    oom.localVariable.set(new LocalVariable());
                    System.out.println("use local varaible");
                }
            });
        }
    }
}
