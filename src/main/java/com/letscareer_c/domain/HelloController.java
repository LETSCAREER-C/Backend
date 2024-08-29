package com.letscareer_c.domain;

import com.letscareer_c.infra.s3.application.S3FileService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
public class HelloController {

    private final S3FileService s3FileService;

    public HelloController(S3FileService s3FileService) {
        this.s3FileService = s3FileService;
    }

    @GetMapping
    public String hello() {
        return "우하하하 재밌눈 코딩";
    }

    @PostMapping
    public List<String> imagePostTest(@RequestParam("images") List<MultipartFile> imageFiles) throws IOException {
        return s3FileService.uploadImage(imageFiles);
    }

    @DeleteMapping
    public void imageDeleteTest(@RequestParam("fileName") String fileName) {
        s3FileService.deleteImage(fileName);
    }
}
