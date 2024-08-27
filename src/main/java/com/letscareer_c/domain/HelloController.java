package com.letscareer_c.domain;

import com.letscareer_c.infra.s3.application.S3FileService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class HelloController {

    private final S3FileService s3FileService;

    public HelloController(S3FileService s3FileService) {
        this.s3FileService = s3FileService;
    }

    @GetMapping
    public String hello() {
        return "쿼리dsl도 공부해야하는데 ㅜㅡㅜ";
    }

    @PostMapping
    public String imagePostTest(MultipartFile file) throws IOException {
        return s3FileService.uploadImage(file);
    }
}
