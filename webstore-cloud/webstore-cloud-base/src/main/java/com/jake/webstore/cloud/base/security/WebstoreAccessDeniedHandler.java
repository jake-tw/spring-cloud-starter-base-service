package com.jake.webstore.cloud.base.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jake.webstore.cloud.base.dto.CommonResult;
import com.jake.webstore.cloud.base.enums.ResultType;
import com.jake.webstore.cloud.base.exception.WebstoreException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class WebstoreAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        System.out.println("WebstoreAccessDeniedHandler");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        // TODO use json string
        response.getWriter().println(CommonResult.failed(ResultType.FORBIDDEN));
        // don't need to flush() or close() the writer
        // because when a response is closed,
        // the container must immediately flush all remaining content
    }
}
