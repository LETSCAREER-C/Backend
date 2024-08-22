package com.letscareer_c.infra.health.api;

import com.letscareer_c.global.common.response.BaseResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/health-check")
public class HealthCheckApi {
    static final String GREETING_MESSAGE = "Hello LetsCareer Team C";

    @GetMapping
    public BaseResponse<String> testHealthCheck(){
        String response = GREETING_MESSAGE;

        return new BaseResponse<>(response);
    }
}
