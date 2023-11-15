package com.jake.webstore.cloud.base.controller;

import com.jake.webstore.cloud.base.dto.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HealthCheckController {

    @Value("${spring.application.name}")
    private String appName;

    // TODO change to real authority
    @GetMapping("/health")
    @PreAuthorize("hasAuthority('admin')")
    public CommonResult<?> health() {
        log.info("[{}] health check", appName);
        return CommonResult.success(null);
    }
}
