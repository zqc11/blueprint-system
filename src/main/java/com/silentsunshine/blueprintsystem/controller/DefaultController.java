package com.silentsunshine.blueprintsystem.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhouqichun
 **/
@RestController
@RequestMapping("/hello")
public class DefaultController {
    @GetMapping
    public String sayHello() {
        return "hello";
    }
}
