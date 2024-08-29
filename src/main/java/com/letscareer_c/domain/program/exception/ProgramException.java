package com.letscareer_c.domain.program.exception;

import com.letscareer_c.global.common.response.status.ResponseStatus;
import lombok.Getter;

@Getter
public class ProgramException extends RuntimeException{
    private final ResponseStatus exceptionStatus;

    public ProgramException(ResponseStatus exceptionStatus) {
        super(exceptionStatus.getMessage());
        this.exceptionStatus = exceptionStatus;
    }
}
