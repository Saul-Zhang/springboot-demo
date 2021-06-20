package xyz.zsly.springboot.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zhang song
 * @date 2021/6/20 21:29
 */
@Controller
public class HelloController {

  @ResponseBody
  @GetMapping("/hello")
  public String hello() {
    return "hello";
  }
}
