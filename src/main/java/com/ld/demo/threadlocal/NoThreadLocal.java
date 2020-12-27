package com.ld.demo.threadlocal;

public class NoThreadLocal {
    public class TestThread implements Runnable{
        int id;
        public TestThread(int id){
            this.id=id;
        }
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+" start:");
            count=count+id;
            System.out.println(Thread.currentThread().getName()+" : end count:" +count);
        }
    }
    static Integer count=new Integer(1);
    public void startThreadArray(){
        Thread[] runs=new Thread[3];
        for(int i=0;i<runs.length;i++){
            runs[i] = new Thread(new TestThread(i));
        }
        for(int i=0;i<runs.length;i++){
            runs[i].start();
        }
    }
    public static void main(String[] args){
        NoThreadLocal noThreadLocal=new NoThreadLocal();
        noThreadLocal.startThreadArray();
    }
}
