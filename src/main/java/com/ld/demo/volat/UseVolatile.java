package com.ld.demo.volat;

import com.ld.demo.util.pool.SleepTools;

/**
 * volatile 的使用学习
 */
public class UseVolatile {
    private  static boolean ready;
    private static int number;
    private static class PrintThread extends Thread{
        @Override
        public void run(){
            System.out.println("PrintThread is running");
            while (!ready){

                System.gc();
            };
            System.out.println("PringThread is end number:"+number);
        }
    }
    public static void main(String[] args){
        System.out.println("main is running");
        new PrintThread().start();
        SleepTools.second(1);
        number=51;
        ready=true;
        SleepTools.second(5);
        System.out.println("main is end");
    }
}
