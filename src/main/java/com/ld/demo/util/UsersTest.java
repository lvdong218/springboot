package com.ld.demo.util;

import com.ld.demo.App;
import com.ld.demo.dao.UsersMapper;
import com.ld.demo.model.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest(classes = {App.class})
@RunWith(SpringRunner.class)
public class UsersTest {
    @Resource
    private UsersMapper usersMapper;
    @Test
    public void testAdd() {
        Users user = new Users() ;
        user.setPasswd("123");
        user.setUsername("enjoy");
        usersMapper.insertSelective(user);
    }
    @Test
    public void testFindUser() {
        Users enjoy = usersMapper.findByUsernameAndPasswd("enjoy", "123");
        System.out.println(enjoy);
    }
}
