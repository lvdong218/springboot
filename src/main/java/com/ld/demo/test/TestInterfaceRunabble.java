package com.ld.demo.test;

public class TestInterfaceRunabble implements Runnable {

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(20);
                System.out.println("this is Thread"+Thread.currentThread().getName());
                Thread.currentThread().interrupt();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //System.out.println("this flag "+Thread.currentThread().isInterrupted());
        //System.out.println("Testinterface stop");
    }
    public static void main(String[] args) throws InterruptedException{
        TestInterfaceRunabble testInterfaceRunabble=new TestInterfaceRunabble();
        Thread thread=new Thread(testInterfaceRunabble);
        thread.start();
        Thread.sleep(20);
        thread.interrupt();
        //System.out.println("Main stop");
    }
}
