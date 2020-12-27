package com.ld.demo.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class FindDirTask extends RecursiveAction {
    private File path;
    private FindDirTask(File path){
        this.path=path;
    }
    @Override
    protected void compute() {
        List<FindDirTask> subList=new ArrayList<FindDirTask>();
        File[] files=path.listFiles();
        if(files!=null){
            for(File file:files){
                if(file.isDirectory()){
                    subList.add(new FindDirTask(file));
                }else{
                    if(file.getAbsolutePath().endsWith("txt")){
                        System.out.println("获取文件路径为："+file.getAbsolutePath());
                    }
                }
            }
            for(FindDirTask task:invokeAll(subList)){
                task.join();
            }
        }else{
            System.out.println("当前文件夹下没有txt结尾的文件");
        }

    }
    public static void main(String[] args){
        ForkJoinPool pool=new ForkJoinPool();
        FindDirTask task=new FindDirTask(new File("C://"));
        pool.invoke(task);
        pool.execute(task);
        System.out.println("主线程执行task");
        //不对子线程进行等待
        task.join();
        System.out.println("主线程执行task完成");
    }
}
