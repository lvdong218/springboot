package com.ld.study.thread.base;

import org.junit.Test;

import java.util.concurrent.Callable;

/**
 * @Classname NewThread
 * @Description 创建线程方式，共分为两种（接口实现与继承类实现。其中接口实现有两种方式。）
 * @Date 2020/12/24 11:34
 * @Authr by lvdong
 */
public class NewThread {

    @Test
    public void test(){
        Thread t1= new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });


    }

    /**
     * 使用继承方式实现thread
     */
    private class classThread extends Thread{

        @Override
        public void run() {

        }
    }
    /**
     * 使用call实现thread
     */
    private class interfaceCallThread implements Callable<Integer>{

        @Override
        public Integer call() throws Exception {
            return null;
        }
    }

    /**
     * 使用runnable实现thread
     */
    private class interfaceNoCallThread implements Runnable{

        @Override
        public void run() {

        }
    }
}
