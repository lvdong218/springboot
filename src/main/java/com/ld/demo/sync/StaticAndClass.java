package com.ld.demo.sync;

import com.ld.demo.util.pool.SleepTools;

import java.awt.*;

public class StaticAndClass {
    private static Object obj=new Object();
    private static class SyncClass extends Thread{
        @Override
        public void run(){
            System.out.println("SyncClass is running");
        }
    }
    private static synchronized void syncClass(){
        System.out.println("syncClass is running");
        SleepTools.second(1);
        System.out.println("syncClass is end");
    }
    private static class SyncStatic extends Thread{
        @Override
        public void run(){
            System.out.println("SyncStatic is running");
        }
    }
    private static void syncStatic(){
        synchronized (obj){
            System.out.println("syncStatic running");
        }

    }
}
