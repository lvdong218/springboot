package com.ld.demo.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * 实现recuriveAction farkJoin分而治之
 */
public class FindDirFile extends RecursiveAction {
    private File path;
    public FindDirFile(File path){
        this.path=path;
    }
    @Override
    protected void compute(){
        List<FindDirFile> subTasks= new ArrayList();
        File[] files=path.listFiles();
        if(files==null)
            return;
        for(File file:files){
            if(file.isDirectory()){
                subTasks.add(new FindDirFile(file));
            }else{
                if(file.getAbsolutePath().endsWith("txt")){
                    System.out.println("文件："+file.getAbsoluteFile());
                }
            }
        }
        if(subTasks!=null&&!subTasks.isEmpty()){
            for(FindDirFile subtask:subTasks){
                subtask.invoke();
            }
        }
    }
    public static void main(String[] args) throws InterruptedException{
        ForkJoinPool forkJoinPool=new ForkJoinPool();
        FindDirFile findDirFile=new FindDirFile(new File("C:/"));
        forkJoinPool.execute(findDirFile);
        System.out.println("Task Running.........");
        Thread.sleep(1);
        int outWork=0;
        for(int i=0;i<100;i++){
            outWork+=i;
        }
        System.out.println("Main Thread does sth......,otherWork"+outWork);
        findDirFile.join();
        System.out.println("Task end");
    }

}
