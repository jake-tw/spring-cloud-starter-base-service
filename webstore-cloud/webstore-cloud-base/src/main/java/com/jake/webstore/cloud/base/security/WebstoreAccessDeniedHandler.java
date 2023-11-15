package com.jake.webstore.cloud.base.security;

import com.jake.webstore.cloud.base.enums.ResultType;
import com.jake.webstore.cloud.base.exception.WebstoreException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class WebstoreAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        System.out.println("WebstoreAccessDeniedHandler");
        throw new WebstoreException(ResultType.FORBIDDEN);
    }
}
