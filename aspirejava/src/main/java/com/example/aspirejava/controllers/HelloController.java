package com.example.aspirejava.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    
    @GetMapping("hello/{name}")
    // if you forget ResponseBody all crashes without meaning
    public @ResponseBody String getMethodName(@PathVariable String name) {
        return "hello: " + name;
    }
    
}
