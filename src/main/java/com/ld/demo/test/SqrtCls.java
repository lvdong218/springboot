package com.ld.demo.test;

public class SqrtCls {
    //sqrt(2) 的值大约是1.41 即其所处区间为1.41,1.42
    static double  threshold=0.0000000001;
    public static void count(){
        double left =1.41;
        double right=1.42;
        double mid=(left+right)/2;
        while((right-left)>threshold){
            mid=(left+right)/2;
            if(mid*mid>2){
                right=mid;
            }else{
                left=mid;
            }
        }
        System.out.println(mid);
    }
    public static void main(String[] args){
        count();
    }

}
