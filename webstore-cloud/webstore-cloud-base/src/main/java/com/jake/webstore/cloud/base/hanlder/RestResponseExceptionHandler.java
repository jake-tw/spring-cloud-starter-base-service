package com.jake.webstore.cloud.base.hanlder;

import com.jake.webstore.cloud.base.exception.BizException;
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
public class RestResponseExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler()
    protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {

        ResultType type;
        if (ex instanceof BizException b) {
            type = b.getType();
        } else {
            type = ResultType.FAILED;
        }

        logger.error("Catch exception", ex);
        return handleExceptionInternal(ex, CommonResult.failed(type), new HttpHeaders(), HttpStatus.OK, request);
    }
}
