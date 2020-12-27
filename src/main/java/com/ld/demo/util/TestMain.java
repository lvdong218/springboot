package com.ld.demo.util;

import com.ld.demo.util.pool.SleepTools;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.CountDownLatch;

public class TestMain {
    /**
     *

    public static void main(String[] args){
        //虚拟机线程管理接口
        ThreadMXBean tb= ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos=tb.dumpAllThreads(false,false);
        for(ThreadInfo threadInfo:threadInfos){
            System.out.println("线程"+threadInfo.getThreadId()+",线程名称"+threadInfo.getThreadName());
        }
    }
     *
     */
    public static void main(String[] args){
        CountDownLatch countDownLatch=new CountDownLatch(10);
        for(int i=0;i<10;i++){
            Thread thread = new ThreadTest(countDownLatch);
            thread.setName("thread-"+(i+1));
            thread.start();
            countDownLatch.countDown();
        }
    }
    private static class ThreadTest extends Thread{
        private final CountDownLatch countDownLatch;
        public ThreadTest(CountDownLatch countDownLatch){
            this.countDownLatch=countDownLatch;
        }
        public void run (){
            try {
                countDownLatch.await();
                System.out.println("线程:"+Thread.currentThread().getName()+"进行线程执行方法");
                SleepTools.second(5);
                System.out.println("线程:"+Thread.currentThread().getName()+"执行线程方法执行完毕");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * 代码优化 ，优化代码格式等
     * @param webview
     * @return

    public Bitmap getFavicon(final WebView webview) {
        Bitmap bitmap=null;
        if (null != webview )
            bitmap=webview.getFavicon();
        return bitmap==null?BitmapFactory.decodeResource(getResources(), R.drawable.default_favicon):bitmap;
    }
     */
}
