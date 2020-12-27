package com.ld.demo.test;

import java.util.ArrayList;
import java.util.List;

//求2~2000的所有素数.有足够的内存,要求尽量快
public class primeNumber {
    public List count(){
        List list=new ArrayList();
        for(int i=2;i<2000;i++){
            int temp=0;
            for(int j=2;j<i;j++){
                if(i%j==0&&i!=j){
                    temp=i;
                }
            }
            if(temp==0){
                list.add(i);
            }else{
                temp=0;
            }
        }
        return list;
    }


}
