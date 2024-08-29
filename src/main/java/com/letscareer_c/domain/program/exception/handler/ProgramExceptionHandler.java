package com.letscareer_c.domain.program.exception.handler;

import com.letscareer_c.domain.program.exception.ProgramException;
import com.letscareer_c.global.common.exception.BaseException;
import com.letscareer_c.global.common.response.BaseErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.TypeMismatchException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.io.IOException;
import java.util.stream.Collectors;

import static com.letscareer_c.global.common.exception.errorcode.BaseExceptionErrorCode.*;

@Slf4j
@RestControllerAdvice
public class ProgramExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ProgramException.class)
    public BaseErrorResponse handleUserException(ProgramException e) {
        log.error("[ProgramException: handle_ProgramException 호출]", e);
        return new BaseErrorResponse(e.getExceptionStatus(), e.getMessage());
    }
}
