package xyz.zsly.springbootfilter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhang song
 * @date 2021/5/25 10:23
 */
@RestController
public class HelloController {
  @GetMapping("hello")
  public String hello(){
    return "hello";
  }

}
