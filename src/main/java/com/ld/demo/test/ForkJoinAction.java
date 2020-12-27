package com.ld.demo.test;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinAction  {
    private static class ForkJoinTask extends RecursiveTask<Integer>{
        private int[] src;
        private Integer fromIndex;
        private Integer toIndex;
        private static final Integer THRESHOLD=MakeArray.ARRAY_LENGTH/10;
        public ForkJoinTask(int[] src,Integer fromIndex,Integer toIndex){
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
                ForkJoinTask leftTask=new ForkJoinTask(src,fromIndex,mid);
                ForkJoinTask rightTask=new ForkJoinTask(src,mid+1,toIndex);
                invokeAll(leftTask,rightTask);
                return leftTask.join()+rightTask.join();
            }
        }
    }
    public static void main(String[] args){
        ForkJoinPool pool=new ForkJoinPool();
        int[] srcs=MakeArray.makeArray();
        ForkJoinTask task=new ForkJoinTask(srcs,0,srcs.length-1);
        pool.invoke(task);
    }

}
