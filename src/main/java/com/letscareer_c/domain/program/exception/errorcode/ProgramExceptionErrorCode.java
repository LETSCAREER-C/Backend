package com.letscareer_c.domain.program.exception.errorcode;

import com.letscareer_c.global.common.response.status.ResponseStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
public enum ProgramExceptionErrorCode implements ResponseStatus {

    /**
     * 4000: Program 도메인 오류
     */

    INVALID_REQUEST_CAREER_TAG(4000, HttpStatus.BAD_REQUEST.value(), "Program List 조회: 올바른 커리어 태그 값을 입력해야 합니다."),
    INVALID_REQUEST_PROGRAM_TYPE(4001, HttpStatus.BAD_REQUEST.value(), "Program List 조회: 올바른 프로그램 타입 값을 입력해야 합니다."),
    // 존재하지 않는 프로그램 에러 반환
    PROGRAM_NOT_FOUND(4002, HttpStatus.NOT_FOUND.value(), "존재하지 않는 프로그램입니다.");

    private final int code;
    private final int status;
    private final String message;


    @Override
    public int getCode() {
        return code;
    }

    @Override
    public int getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

