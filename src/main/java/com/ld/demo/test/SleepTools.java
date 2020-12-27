package com.ld.demo.test;

import java.util.concurrent.TimeUnit;

/**
 * 线程休眠工具类
 */
public class SleepTools {
    /**
     *
     * @param second
     */
    public final static void second(int second){
        try{
            TimeUnit.SECONDS.sleep(second);
        }catch (InterruptedException e){

        }

    }
}
