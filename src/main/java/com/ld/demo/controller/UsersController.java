package com.ld.demo.controller;

import com.ld.demo.service.IUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Resource
    IUserService iUserService;
    @RequestMapping("/hello")
    public String sayHello(){
        return "hello";
    }

    @RequestMapping("/login")
    public String login(String username,String password){
        boolean login=iUserService.login(username,password);
        if(login)
            return "登录成功";
        else
            return "登录失败";
    }
    @RequestMapping("/register")
    public String register(String username,String password){
        if(iUserService.register(username,password))
            return "注册成功";
        else
            return "注册失败";
    }

    @RequestMapping("/batchAdd")
    public String battchAdd(String username,String password){
        iUserService.batchAdd(username,password);
        return "成功";
    }
    public static void main(String[] args){
        System.out.println("1".hashCode());
        System.out.println("2wefrervg43rvrvr3r".hashCode());
    }
}
