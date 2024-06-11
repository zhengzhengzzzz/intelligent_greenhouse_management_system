package cn.hist.greenHouse.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {
    @GetMapping("/hello")
    @PreAuthorize("hasAnyRole('1','0')")
    public String hello(){
        return "hello";
    }
}
