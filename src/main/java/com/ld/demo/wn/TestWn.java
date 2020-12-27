package com.ld.demo.wn;

public class TestWn {
    private static Express express=new Express(0,Express.CITY);

    /**
     * 检查里程数变化，如不满足条件则线程一直进行等待
     */
    private static class CheckKm extends Thread{
        public  void run(){
            express.waitKm();
        }
    }

    /**
     * 检查地点变化，如不满足条件则线程一直进行等待
     */
    private static class CheckSite extends Thread{
        public void run(){
            express.waitSite();
        }
    }
    public static void main(String[] args) throws InterruptedException {
        for(int i=0;i<3;i++){
            new CheckKm().start();
        }
        for(int i=0;i<3;i++){
            new CheckSite().start();
        }
        Thread.sleep(1000);
        express.changeKm();
    }
}
