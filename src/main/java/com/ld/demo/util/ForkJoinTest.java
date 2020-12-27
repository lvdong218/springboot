package com.ld.demo.util;

import org.apache.ibatis.mapping.FetchType;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * forkJoin学习
 * 无返回值forkjoin框架
 * @author lvdong
 */
public class ForkJoinTest extends RecursiveAction {
    private File path;
    public ForkJoinTest(File path){
        this.path=path;
    }
    /**
     * 初始化forkJoinPool池
     */
    public static void main(String[] args){
        ForkJoinPool forkJoinPool=new ForkJoinPool();
        System.out.println("进入main方法");
        ForkJoinTest forkJoinTest=new ForkJoinTest(new File("C:/"));
        forkJoinPool.execute(forkJoinTest);
        forkJoinTest.join();//阻塞方法
        System.out.println("main end");
    }

    @Override
    protected void compute() {
        List<ForkJoinTest> list=new ArrayList();
        File[] files=path.listFiles();
        try {
            FileOutputStream fos=new FileOutputStream("C:\\Users\\lvdong\\Desktop\\x.txt");
            fos.write("aaabbbccc".getBytes());
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(files!=null){
            for(File file:files){
                if(file.isDirectory()){
                    list.add(new ForkJoinTest(file));
                }else{
                    System.out.println("文件路径为:"+file.getAbsolutePath());
                }
            }
            if(!list.isEmpty()){
                for(ForkJoinTest test:invokeAll(list)){
                    test.join();//等待子线程任务完成
                }

            }
        }
    }
}
