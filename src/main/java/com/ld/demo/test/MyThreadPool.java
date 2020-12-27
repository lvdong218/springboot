package com.ld.demo.test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 自己手写一个线程池
 */

public class MyThreadPool {
    //初始化线程设置默认参数
    private static final Integer THREADSIZE=5;
    private MyThread[] theadPool;
    private BlockingQueue<Runnable> bq ;
    private Runnable before;
    //taskCount 阻塞队列长度
    //workCount thread数量
    public MyThreadPool(int taskCount,int workCount){
        if(workCount<=0)workCount=THREADSIZE;
        if(taskCount<=0)taskCount=100;
        if(null==theadPool){
            theadPool = new MyThread[workCount];
            bq = new ArrayBlockingQueue(taskCount);
            for(int i = 0;i<workCount;i++){
                theadPool[i]= new MyThread();
                theadPool[i].start();
            }
        }
    }

    /**
     * 将任务加入到队列中
     * @param run
     */
    public void excute(Runnable run){
        try {
            bq.put(run);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void destroy(){
        System.out.println("ready closing");
        for(int i = 0; i<theadPool.length;i++){
            theadPool[i].stopThread();
            theadPool[i]=null;
        }
    }

    /**
     * 内部thread实现类
     */
     class MyThread extends Thread{
        Runnable runnable=null;
        public void run(){
            before.run();
            try {
                while(!isInterrupted()){
                        runnable = bq.take();
                        if(runnable!=null){
                            System.out.println(getId()+" ready excute  " +((TestMyThreadPool.MyTask)runnable).getName());
                            runnable.run();
                        }
                        runnable = null;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println(" this "+isInterrupted());
            }
        }
        public void stopThread(){
            interrupt();
        }
    }

    class BeforeExcute implements Runnable{

        @Override
        public void run() {
            System.out.println(111);
        }
    }
    /*
    public static void main(String[] args){
        MyThread myThread=new MyThread();
        myThread.start();
        new Thread(new MyThreadB()).start();
    }
    static class MyThreadB implements Runnable{

        @Override
        public void run() {

        }
    }*/




}
