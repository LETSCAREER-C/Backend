package com.letscareer_c.infra.s3.application;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;
import java.util.UUID;

@Transactional
@Slf4j
@RequiredArgsConstructor
@Service
public class S3FileService {

    private final AmazonS3 amazonS3;

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;


    public String uploadImage(MultipartFile file) {
        // jpeg, jpg, png 만 허용
        validateImageType(Objects.requireNonNull(file.getContentType()));
        // 파일 사이즈도 검증해야함.

        String fileName = createFileName(file.getOriginalFilename());
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentLength(file.getSize());
        objectMetadata.setContentDisposition(file.getContentType());
        try {
            amazonS3.putObject(bucket, fileName, file.getInputStream(), objectMetadata);
        } catch (Exception e) {
            log.error("S3 파일 업로드 실패", e);
            throw new RuntimeException("S3 파일 업로드 실패", e);
        }
        return amazonS3.getUrl(bucket, fileName).toString();
    }

    private String createFileName(String originalFileName) {
        return UUID.randomUUID().toString() + "_" + originalFileName;
    }

    private void validateImageType(String contentType) {
        // 이미지가 올바른 타입인지 확인 jpeg, jpg, png 만 허용
        if (!contentType.equals("image/jpeg") && !contentType.equals("image/jpg") && !contentType.equals("image/png")) {
            throw new IllegalArgumentException("jpeg, jpg, png 형식의 이미지 파일만 업로드 가능합니다.");
        }
    }

}
