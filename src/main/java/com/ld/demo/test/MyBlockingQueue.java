package com.ld.demo.test;

import java.util.ArrayList;
import java.util.List;

public class MyBlockingQueue<E> {
    private List<Object> list;
    public MyBlockingQueue(){
        System.out.println("执行初始化queue");
        list = new ArrayList<>();
    }
    public void add(Object o){
        synchronized (o){
            System.out.println("向阻塞队列中添加元素");
            list.add(o);
            System.out.println("向阻塞队列中添加元素成功");
        }

    }

    public void task(){
        Object obj = list.remove(0);
    }
}
