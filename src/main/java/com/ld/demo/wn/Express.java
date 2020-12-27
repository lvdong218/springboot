package com.ld.demo.wn;

/**
 * 快递实体类
 */
public class Express {
    public static final String CITY="ShangHai";
    private int km;//快递运输里程数
    private String site;//快递到达地点
    public Express(){

    }
    public Express(int km,String site){
        this.km=km;
        this.site=site;
    }
    public synchronized void changeKm(){
        this.km=101;
        notifyAll();
    }
    public synchronized void changeSite(String site){
        this.site="Beijing";
        notifyAll();
    }

    public synchronized void waitKm(){
        while(km<100){
            try{
                wait();
                System.out.println("Check site thread["+Thread.currentThread().getId()+"] is be notified");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("the Km is "+km+",I will change db");
    }
    public synchronized void waitSite(){
        while(site.equals(CITY)){
            try{
                wait();
                System.out.println("Check site Thread ["+Thread.currentThread().getId()+"]is be notified");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("the site is "+site+",I will call user");
    }
}
