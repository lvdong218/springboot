package com.ld.demo.threadlocal;

/**
 * threadlocal 的使用
 */
public class UseThreadLocal {
    private static ThreadLocal<Integer> intLocal = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue(){
            return 1;
        }
    };
    private static ThreadLocal<String> stringThreadLocal;
    public static class TestThread implements Runnable{
        int id;
        public TestThread(int id){
            this.id=id;
        }
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+": start");
            Integer s=intLocal.get();
            s+=id;
            intLocal.set(s);
            System.out.println(Thread.currentThread().getName()+" s:"+intLocal.get());
        }
    }
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
        UseThreadLocal useThreadLocal=new UseThreadLocal();
        useThreadLocal.startThreadArray();
    }

}
