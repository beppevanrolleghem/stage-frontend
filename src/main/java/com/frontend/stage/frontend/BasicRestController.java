package com.frontend.stage.frontend;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicRestController {

    @RequestMapping("/")
    public String index() {
        return "it works!";
    }


    @RequestMapping("/stage-frontend")
    public String index2() { return "it do work"; }


}
