package com.cms.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorld {

    @RequestMapping(value = "/hello")
    public String sayHello() {
        return "Hello! World";
    }
}