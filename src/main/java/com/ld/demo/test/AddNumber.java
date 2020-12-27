package com.ld.demo.test;

public class AddNumber {
    private int x;
    private int y;
    private int z;
    //此方程应为这样
    //1x+2y+5z=100;
    public Integer count(){
        int count=0;
        for(int i=0;i<100;i++){
            for (int j=0;j<50;i++){
                for(int x=0;x<20;x++){
                    if(i+2*j+5*x==100){
                        count++;
                    }
                }
            }
        }
        return null;
    }

}
