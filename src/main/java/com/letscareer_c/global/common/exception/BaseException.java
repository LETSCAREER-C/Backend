package com.letscareer_c.global.common.exception;

import com.letscareer_c.global.common.response.status.ResponseStatus;
import lombok.Getter;

@Getter
public class BaseException extends RuntimeException{
    private final ResponseStatus exceptionStatus;


    public BaseException(ResponseStatus exceptionStatus) {
        super(exceptionStatus.getMessage());
        this.exceptionStatus = exceptionStatus;
    }

    public BaseException(String exceptionMessage, ResponseStatus exceptionStatus) {
        super(exceptionMessage);
        this.exceptionStatus = exceptionStatus;
    }
}

