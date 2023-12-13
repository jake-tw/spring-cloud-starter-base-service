package com.jake.webstore.cloud.base.security;

import com.jake.webstore.cloud.base.utils.ConstantUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;


@Component
public class JwtSecurityFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUserDetailsService jwtUserDetailsService;

    @Override
    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var header = request.getHeader(ConstantUtil.Header.AUTHORIZATION);
        if (StringUtils.hasText(header) && header.startsWith(ConstantUtil.Header.BEARER)) {
            var token = header.substring(7);
            var user = jwtUserDetailsService.loadUserByUsername(token);
            var t = UsernamePasswordAuthenticationToken.authenticated(user, token, user.getAuthorities());
            // no need to set additional info
            // t.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(t);
        }

        filterChain.doFilter(request, response);
    }
}
