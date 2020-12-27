package com.ld.demo.volat;

import com.ld.demo.util.pool.SleepTools;

public class NoSafeVolatile {
    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    private   long  count=0;
    public void inCount(){
        count++;
    }
    private static class Count extends Thread{
        private NoSafeVolatile noSafeVolatile;
        public Count(NoSafeVolatile noSafeVolatile){
            this.noSafeVolatile = noSafeVolatile;
        }
        @Override
        public void run(){
            for(int i=0;i<10000;i++){
                synchronized (noSafeVolatile){
                    noSafeVolatile.inCount();
                }

            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        NoSafeVolatile noSafeVolatile1 = new NoSafeVolatile();
        Count count1 = new Count(noSafeVolatile1);
        Count count2 = new Count(noSafeVolatile1);
        count1.start();
        count2.start();
        Thread.sleep(50);
        System.out.println(noSafeVolatile1.getCount());
    }
}
