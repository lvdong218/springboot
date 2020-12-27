package com.ld.demo.util.pool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class DBPoolsTest {
    static DBPool pool=new DBPool(10);
    static CountDownLatch end;
    public static void main(String[] args) throws Exception{
        //线程数
        int threadCount=50;
        end = new CountDownLatch(threadCount);
        int count=20;//每个线程的操作次数
        AtomicInteger got=new AtomicInteger();//计数器，统计可以拿到连接的线程
        AtomicInteger notGot=new AtomicInteger();//计数器，统计没有拿到连接的线程;
        for(int i=0;i<threadCount;i++){
            new Thread(new Worker(count,got,notGot),"work_"+i).start();
        }
        end.await();//main在此等待
        System.out.println("总共尝试了："+(threadCount*count));
        System.out.println("拿到连接的次数:"+got);
        System.out.println("没有拿到连接的次数:"+notGot);
    }
    static class Worker implements Runnable{
        int count;
        AtomicInteger got,notGot;
        public Worker(int count,AtomicInteger got,AtomicInteger notGot){
            this.count=count;
            this.got=got;
            this.notGot=notGot;
        }
        @Override
        public void run() {
            while(count>0){
                //从线    程池中获取连接，如果1000ms无法获取，则返回null
                //分别统计连接获取数量got和未获取数量notgot
                try {
                    Connection connection=pool.fetchConn(1000);
                    if(connection!=null){
                        try {
                            connection.createStatement();
                            connection.commit();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }finally {
                            pool.releaseCon(connection);
                            got.incrementAndGet();
                        }

                    }else{
                        notGot.incrementAndGet();
                        System.out.println(Thread.currentThread().getName()+"等待超时");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally{
                    count--;
                }

            }
            end.countDown();
        }
    }
}
