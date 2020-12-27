package com.ld.demo.test;
// 将单向链表reverse，如ABCD变成DCBA，只能搜索链表一次。
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Link {
    public List reverse(List list){

        List result=new ArrayList();
        List linkResult=new LinkedList();
        for(int i=0;i<list.size();i++){
            result.add(list.get(i));
        }
        for(int i=result.size()-1;i>0;i--){
            linkResult.add(result.get(i));
        }
        return linkResult;
    }
}
