package com.jake.webstore.cloud.base.filter;

import com.jake.webstore.cloud.base.component.JwtUserDetailsService;
import com.jake.webstore.cloud.base.enums.ResultType;
import com.jake.webstore.cloud.base.exception.WebstoreException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;


@Component
public class JwtSecurityFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUserDetailsService jwtUserDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("JwtSecurityFilter");
        filterChain.doFilter(request, response);
    }
}
