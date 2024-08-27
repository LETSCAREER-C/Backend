package com.letscareer_c.domain;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping
    public String hello() {
        return "쿼리dsl도 공부해야하는데 ㅜㅡㅜ";
    }
}
