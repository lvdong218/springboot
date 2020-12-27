package com.ld.demo.util;

import com.ld.demo.App;
import com.ld.demo.dao.UsersMapper;
import com.ld.demo.model.Users;
import com.ld.demo.util.pool.SleepTools;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.concurrent.CountDownLatch;

@org.springframework.boot.test.context.SpringBootTest(classes = {App.class})
@RunWith(SpringRunner.class)
public class SpringBootTest {
    @Resource
    private UsersMapper usersMapper;
    @Test
    public void testAdd() {
        /**
         *
        Users user = new Users() ;
        user.setPasswd("123");
        user.setUsername("enjoy");
        usersMapper.insertSelective(user);
         */
        CountDownLatch countDownLatch=new CountDownLatch(10);
        for(int i=0;i<10;i++){
            Thread thread = new ThreadTest(countDownLatch);
            thread.setName("thread-"+(i+1));
            thread.start();
            countDownLatch.countDown();
        }

    }
    public static void main(String[] args){
        CountDownLatch countDownLatch=new CountDownLatch(10);
        for(int i=0;i<10;i++){
            Thread thread = new ThreadTest(countDownLatch);
            thread.setName("thread-"+(i+1));
            thread.start();
            countDownLatch.countDown();
        }
    }
    private static class ThreadTest extends Thread{
        private final CountDownLatch countDownLatch;
        public ThreadTest(CountDownLatch countDownLatch){
            this.countDownLatch=countDownLatch;
        }
        public void run (){
            try {
                countDownLatch.await();
                System.out.println("线程:"+Thread.currentThread().getName()+"进行线程执行方法");
                SleepTools.second(5);
                System.out.println("线程:"+Thread.currentThread().getName()+"执行线程方法执行完毕");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
