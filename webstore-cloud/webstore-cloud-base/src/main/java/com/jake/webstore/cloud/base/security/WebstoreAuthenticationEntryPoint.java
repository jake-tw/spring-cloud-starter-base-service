package com.jake.webstore.cloud.base.security;

import com.jake.webstore.cloud.base.dto.CommonResult;
import com.jake.webstore.cloud.base.enums.ResultType;
import com.jake.webstore.cloud.base.exception.WebstoreException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class WebstoreAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        System.out.println("WebstoreAuthenticationEntryPoint");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        // TODO use json string
        response.getWriter().println(CommonResult.failed(ResultType.UNAUTHORIZED));
        // don't need to flush() or close() the writer
        // because when a response is closed,
        // the container must immediately flush all remaining content
    }
}
