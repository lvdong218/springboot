package com.ld.demo.forkjoin.sort;

/**
 *
 */
public class InsertionSort {
    public static int[] sort(int[] array){
        if(array==null||array.length==0){
            return array;
        }
        int currentValue;
        for(int i=0;i<array.length;i++){
            int preIndex=i;
            currentValue=array[preIndex+1];
            while(preIndex>=0&&currentValue<array[preIndex]){
                array[preIndex+1]=array[preIndex];
                preIndex--;
            }
            array[preIndex+1]=currentValue;
        }
        return array;
    }
}
