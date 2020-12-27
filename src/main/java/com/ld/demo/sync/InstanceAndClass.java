package com.ld.demo.sync;

import com.ld.demo.util.pool.SleepTools;

/**
 * 类锁 对象锁 学习
 */
public class InstanceAndClass {
    private static class SyncClass extends Thread{
        @Override
        public void run (){
            System.out.print("SyncClass is running");
            syncClass();
        }
    }
    private static synchronized void syncClass(){
        SleepTools.second(1);
        System.out.print("syncClass method is going");
        SleepTools.second(1);
        System.out.print("syncClass method is end");
    }

    /**
     * 内部类 runnable接口实现线程
     */
    private static class InstanceClass implements Runnable{
        private InstanceAndClass instanceAndClass;
        public InstanceClass(InstanceAndClass instanceAndClass){
            this.instanceAndClass=instanceAndClass;
        }
        @Override
        public void run() {
            System.out.print("InstanceClass is running");
            instanceAndClass.instance();
        }
    }

    private synchronized  void instance(){
        SleepTools.second(1);
        System.out.print("instance method is running");
        SleepTools.second(1);
        System.out.println("instance method is end");
    }
    public static void main(String[] args){
        System.out.println("main running");
        Thread t1=new SyncClass();
        InstanceAndClass instanceAndClass=new InstanceAndClass();
        Thread t2=new Thread(new InstanceClass(instanceAndClass));
    }
}
