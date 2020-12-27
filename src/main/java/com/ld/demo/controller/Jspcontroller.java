package com.ld.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jsp")
public class Jspcontroller {
    @RequestMapping("/hi")
    public String toIndex(){
        return "index";
    }
}
