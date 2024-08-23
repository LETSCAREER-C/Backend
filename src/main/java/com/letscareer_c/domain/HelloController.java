package com.letscareer_c.domain;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping
    public String hello() {
        return "재미있는 CI/CD \\( ˆoˆ )/\u200B";
    }
}
