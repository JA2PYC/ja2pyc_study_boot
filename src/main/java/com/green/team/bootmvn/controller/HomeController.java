package com.green.team.bootmvn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ch.qos.logback.core.model.Model;


@Controller
public class HomeController {
    @GetMapping("/")
    public String indexController(Model model) {
        return new String();
    }
    
    
}
