package cn.hist.greenHouse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class Hello {
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}
