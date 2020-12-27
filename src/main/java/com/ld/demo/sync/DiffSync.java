package com.ld.demo.sync;

import com.ld.demo.util.pool.SleepTools;

/**
 * 锁内部资源需注意
 * @author lvdong
 */
public class DiffSync {
    private static class InstanceSyn implements Runnable{
        private DiffSync diffSync;
        public InstanceSyn(DiffSync diffSync){
            this.diffSync=diffSync;
        }
        @Override
        public void run() {
           System.out.println("TestInstanceSyc:"+diffSync);
           diffSync.instance();
        }
    }

    private static class InstanceSyncCopy implements Runnable{
        private DiffSync diffSync;
        public InstanceSyncCopy(DiffSync diffSync){
            this.diffSync=diffSync;
        }
        @Override
        public void run() {
            System.out.println("InstanceSyncCopy:"+diffSync);
            diffSync.instanceCopy();
        }
    }
    private synchronized void instance(){
        SleepTools.second(3);
        System.out.println("instance is going"+this.toString());
        SleepTools.second(3);
        System.out.println("instance is end :"+this.toString());
    }
    private synchronized void instanceCopy(){
        SleepTools.second(3);
        System.out.println("instanceCopy is going"+this.toString());
        SleepTools.second(3);
        System.out.println("instanceCopy is end :"+this.toString());
    }
    public static void main(String[] args){
        System.out.print("main running");
        DiffSync diffSync1=new DiffSync();
        Thread t1=new Thread(new InstanceSyn(diffSync1));
        DiffSync diffSync2=new DiffSync();
        Thread t2=new Thread(new InstanceSyncCopy(diffSync2));
        t2.start();
        t1.start();
        System.out.print("main running end");
    }
}
