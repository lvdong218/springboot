package com.ld.demo.test;

public class SyncAndClass {
    public static void main(String[] args){
        Object o= new Object();
        try {
            System.out.println("o 进入等待");
            o.wait();
            System.out.println(" o 被唤醒");
            o.notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    private static class SyncClass extends Thread{
        public void run(){
            System.out.println("SyncClass is running");

        }
    }
    private static synchronized void syncClass(){

    }
}
