package com.letscareer_c.global.common.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.letscareer_c.global.common.response.status.ResponseStatus;
import lombok.Getter;

import static com.letscareer_c.global.common.exception.errorcode.BaseExceptionErrorCode.*;

@Getter
@JsonPropertyOrder({"code","status","message","result"})
public class BaseResponse<T> implements ResponseStatus {
    private final int code;
    private final int status;
    private final String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final T result;


    public BaseResponse(T result) {
        this.code = SUCCESS.getCode();
        this.status = SUCCESS.getStatus();
        this.message = SUCCESS.getMessage();
        this.result = result;
    }

    public BaseResponse() {
        this.code = SUCCESS.getCode();
        this.status = SUCCESS.getStatus();
        this.message = SUCCESS.getMessage();
        this.result = null;
    }

    public int getCode() {
        return code;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
