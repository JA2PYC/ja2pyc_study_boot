package com.green.team.bootmvn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


public class HomeController {
    @GetMapping("/")
    public String getIndex(@RequestParam String param) {
        return "index.html";
    }
    
    @GetMapping("/home")
    public String getHome(@RequestParam String param) {
        return "home.html";
    }
    
}
