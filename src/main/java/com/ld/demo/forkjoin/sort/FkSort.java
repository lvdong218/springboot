package com.ld.demo.forkjoin.sort;

/**
 * 使用forkJoin实现递归算法
 */
public  class FkSort {
    public synchronized static void main(String[] args){
        String s= " w e";
        synchronized (s){

        }
        System.out.println(s.replace(" ","%20"));
    }
}