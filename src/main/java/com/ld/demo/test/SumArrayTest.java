package com.ld.demo.test;

import net.bytebuddy.build.Plugin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class SumArrayTest  {
    /**
     * 使用静态内部类
     */
    private static class SumArray extends RecursiveTask<Integer>{
        //阈值
        private static final int THRESHOLD=MakeArray.ARRAY_LENGTH/10;
        //要统计的数组
        private static int[] src;
        //下标起始位置
        private  int fromIndex;
        //下表终止位置
        private  int toIndex;

        public SumArray(int[] src,int fromIndex,int toIndex){
            this.src=src;
            this.fromIndex=fromIndex;
            this.toIndex=toIndex;
        }
        @Override
        protected Integer compute() {
            if(toIndex-fromIndex<THRESHOLD){
                int count=0;
                for(int i=fromIndex;i<=toIndex;i++){
                    count+=src[i];
                }
                return count;
            }else{
                int mid=(fromIndex+toIndex)/2;
                SumArray left=new SumArray(src,fromIndex,mid);
                SumArray right=new SumArray(src,mid+1,mid);
                invokeAll(left,right);
                return left.join()+right.join();
            }

        }
    }
    public static void main(String[] args){
        ForkJoinPool pool=new ForkJoinPool();
        int[] src=MakeArray.makeArray();
        SumArray innerFind=new SumArray(src,0,src.length-1);
        long start=System.currentTimeMillis();
        pool.invoke(innerFind);
        System.out.println("task is running");
        System.out.println("当前数组运算结果"+innerFind.join()+",当前数组运算花费时间:"+(System.currentTimeMillis()-start)+"ms");
    }
}
