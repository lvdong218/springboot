package com.ld.demo.util.pool;


import java.util.concurrent.TimeUnit;

/**
 * 线程休眠工具类
 */
public class SleepTools {
    /**
     * 按秒进行休眠
     * @param second
     */
    public static final void second(int second){
        try {
            TimeUnit.SECONDS.sleep(second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 按照毫秒进行休眠
     * @param ms
     */
    public static final void ms(int ms){
        try {
            TimeUnit.MILLISECONDS.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
