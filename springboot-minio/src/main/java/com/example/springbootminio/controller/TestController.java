package com.example.springbootminio.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhang song
 * @date 2021/4/22 18:23
 */
@RestController
public class TestController {
    @GetMapping("test")
    public String test() {
        return "hello";
    }

}
