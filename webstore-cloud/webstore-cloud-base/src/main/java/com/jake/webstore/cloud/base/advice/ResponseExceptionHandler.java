package com.jake.webstore.cloud.base.advice;

import com.jake.webstore.cloud.base.exception.WebstoreException;
import com.jake.webstore.cloud.base.dto.CommonResult;
import com.jake.webstore.cloud.base.enums.ResultType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Slf4j
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler()
    protected ResponseEntity<Object> handleException(RuntimeException ex, WebRequest request) {
        System.out.println("ResponseExceptionHandler");
        ResultType type;
        if (ex instanceof WebstoreException b) {
            type = b.getType();
        } else {
            type = ResultType.INTERNAL_SERVER_ERROR;
        }

        logger.error("Catch exception", ex);
        return handleExceptionInternal(ex, CommonResult.failed(type), new HttpHeaders(), HttpStatus.OK, request);
    }
}
