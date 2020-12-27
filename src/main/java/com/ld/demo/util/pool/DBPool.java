package com.ld.demo.util.pool;

import java.sql.*;
import java.util.LinkedList;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

/**
 * 手写一个数据库连接池
 */
public class DBPool {
    private LinkedList<Connection> pool=new LinkedList<>();
    private static final int DUALT_INITSIZE=10;

    public DBPool(int initSize){
        if(initSize>0){
            for(int i=0;i<initSize;i++){
                pool.addLast(SqlConnectionImpl.fetch());
            }
        }else{
            for(int i=0;i<DUALT_INITSIZE;i++){
                pool.addLast(SqlConnectionImpl.fetch());
            }
        }
    }
    /*
     *  ms 下时间还拿不到连接则返回一个null
     *  传入时间为小于等于0时，等待直到拿到连接
     *  当传入时间大于0时
     */
    public Connection fetchConn(long mills) throws InterruptedException {
        synchronized (pool){
            if(mills<0){
                while(pool.isEmpty()){
                    pool.wait();
                }
                return pool.removeFirst();
            }else{
                long overTime=System.currentTimeMillis()+mills;
                long remain=mills;
                while(pool.isEmpty()&&remain>0){
                    pool.wait(mills);
                    remain=overTime-System.currentTimeMillis();
                }
                Connection result=null;
                if(!pool.isEmpty()){
                    result=pool.removeFirst();
                }
                return result;
            }
        }
    }

    /**
     * 释放连接
     *
     * @param connection
     */
    public void releaseCon(Connection connection){
        if(connection!=null){
            synchronized (pool){
                pool.addLast(connection);
                pool.notifyAll();
            }
        }

    }
}
